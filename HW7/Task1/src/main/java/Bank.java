import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Bank {
//    @NonFinal
    HashMap<String, Account> accounts = new HashMap<>();
    ConcurrentLinkedQueue<Transaction> transQ = new ConcurrentLinkedQueue<>();

    @SneakyThrows
    void executeTransactions()
    {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (val transaction:transQ) ex.execute(transaction);

        ex.awaitTermination(10, TimeUnit.SECONDS);
        ex.shutdown();
    }



    @SneakyThrows
    void loadTransactionsFromXML(String filename)
    {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(getClass().getResourceAsStream(filename));

        NodeList t = doc.getElementsByTagName("transaction");

        for(int i = 0; i<t.getLength(); i++)
        {
            NamedNodeMap nnm = t.item(i).getAttributes();
            String don = Optional.of(nnm.getNamedItem("donor").getNodeValue())
                    .filter(x->accounts.containsKey(x))
                    .orElseThrow(()->new TransactionException(String.format("Error in XML %s, donor", filename)));
            String con = Optional.of(nnm.getNamedItem("consumer").getNodeValue())
                    .filter(x->accounts.containsKey(x))
                    .orElseThrow(()->new TransactionException(String.format("Error in XML %s, consumer", filename)));
            Integer trans = Optional.of(Integer.valueOf(nnm.getNamedItem("transAmount").getNodeValue()))
                    .orElseThrow(()->new TransactionException("Null transaction"));
            addNewTransaction(don, con, trans);
        }
    }

    @SneakyThrows
    void loadAccountsFromXML(String filename)
    {
        if(!validateAccountsXML(filename))
        {
            return;
        }
        XMLStreamReader reader = XMLInputFactory.newInstance()
                .createXMLStreamReader(
                        getClass().getResourceAsStream(filename));
//                ClassLoader.getSystemResourceAsStream("accounts.xml")); // - альтернатива

        while (reader.hasNext()) {       // while not end of XML
            int event = reader.next();   // read next event
            if (event == XMLEvent.START_ELEMENT &&
                    "account".equals(reader.getLocalName()))
            {
                reader.next();reader.next(); //отстойная реализация, надо будет по-другому
                String acname = reader.getElementText();
                reader.next(); reader.next();
                Integer acbal = Integer.valueOf(reader.getElementText());
                addNewAccount(acname, acbal);
                //System.out.println(acname+acbal);
            }
        }
    }

    //private
    public boolean validateAccountsXML(String filename) {
        try {
            File xml = new File(getClass().getResource(filename).toURI());
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new File(getClass().getResource("accounts.xsd").toURI()))
                    .newValidator()
                    .validate(new StreamSource(xml)
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void addNewAccount(String name, Integer balance)
    {
        if(!accounts.containsKey(name)) accounts.put(name, new Account(name, balance));
        else System.out.printf("Account with name %s already exists!\n", name);
    }


    void addNewTransaction(String donor, String consumer, Integer transAmount)
    {
        if(donor == null || consumer == null || transAmount == null) throw new TransactionException("null");
        if(!accounts.containsKey(donor) || !accounts.containsKey(consumer))
            throw  new TransactionException(String.format("%s  or  %s", donor, consumer));
        transQ.add(new Transaction(accounts.get(donor), accounts.get(consumer), transAmount));
    }

    @AllArgsConstructor
    private class Transaction implements Runnable
    {
        Account donor;
        Account consumer;
        Integer transAmount;

        public void run(){
            donor.withdraw(transAmount);
            consumer.deposit(transAmount);

        }
        @Override
        public String toString(){
            return String.format("\n%s -> %s : %d", donor.getName(), consumer.getName(), transAmount);
        }


    }
    public String printAccounts(){
        StringBuilder s = new StringBuilder("\nAccounts:\n");
        for (val a:accounts.values()) s.append(a.toString());
        return s.toString();
    }

    public String printTransQueue(){return transQ.toString();}
}
