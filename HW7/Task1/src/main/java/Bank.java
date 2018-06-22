import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import lombok.val;
//import
//import javax.xml.bind.*;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Bank {
    @NonFinal
    HashSet<Account> accounts = new HashSet<Account>();;
    //ConcurrentLinkedQueue clq;






    public void loadTransactions()
    {
        while (true)
        {
//            clq.offer(readTransFromXML);
        }
//        clq.notifyAll();
    }

    public void createAccount(String name, Integer balance)
    {
        val acc = new Account(name, balance);
        if(!accounts.contains(acc)) accounts.add(acc);
        else System.out.printf("Account with name %s already exists!\n", name);
    }


    //Callable<Boolean> Transaction = () -> {
    //    return true;};

    @AllArgsConstructor
    class Transaction implements Callable<Boolean>
    {
        Account donor;
        Account consumer;
        Integer transAmount;

        public Boolean call(){
            donor.withdraw(transAmount);
            consumer.deposit(transAmount);

            return true;
        }
   }

    @SneakyThrows
    void loadAccountsFromXML(String filename)
    {
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
                createAccount(acname, acbal);
                //System.out.println(acname+acbal);
            }
        }
        System.out.println(accounts.toString());
    }



}
