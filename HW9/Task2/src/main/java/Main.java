
import lombok.SneakyThrows;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;


public class Main {

    private static String filename = "menu.xml";

    @SneakyThrows
    public static void main(String[] args) {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new Main().getClass().getResourceAsStream(filename));
        Element root = doc.getDocumentElement();
        System.out.println("root node name is:" +root.getTagName());
        NodeList nl =  root.getChildNodes();
        System.out.println("child node name is:" +nl.item(1).getNodeName());
        System.out.println("number of children:" +nl.getLength());

        for(int i=1; i<nl.getLength(); i+=2) {
            Node n = nl.item(i);
            System.out.println("The structure is:");
            //System.out.println(n.getFirstChild().getTextContent());//.getNodeValue());
            NodeList nl2 = n.getChildNodes();
            //System.out.println(nl2.getLength());
            for(int k=1; i<nl2.getLength(); i+=2) {
                System.out.println("\t" + nl2.item(i).getNodeName());
            }

        }




    }




//    void loadTransactionsFromXML(String filename)
//    {
//
//
//        NodeList t = doc.getElementsByTagName("transaction");
//
//        for(int i = 0; i<t.getLength(); i++)
//        {
//            NamedNodeMap nnm = t.item(i).getAttributes();
//            String don = Optional.of(nnm.getNamedItem("donor").getNodeValue())
//                    .filter(x->accounts.containsKey(x))
//                    .orElseThrow(()->new TransactionException(String.format("Error in XML %s, donor", filename)));
//            String con = Optional.of(nnm.getNamedItem("consumer").getNodeValue())
//                    .filter(x->accounts.containsKey(x))
//                    .orElseThrow(()->new TransactionException(String.format("Error in XML %s, consumer", filename)));
//            Integer trans = Optional.of(Integer.valueOf(nnm.getNamedItem("transAmount").getNodeValue()))
//                    .orElseThrow(()->new TransactionException("Null transaction"));
//            addNewTransaction(don, con, trans);
//        }
//    }
//
//    @SneakyThrows
//    void loadAccountsFromXML(String filename)
//    {
//        XMLStreamReader reader = XMLInputFactory.newInstance()
//                .createXMLStreamReader(
//                        getClass().getResourceAsStream(filename));
////                ClassLoader.getSystemResourceAsStream("accounts.xml")); // - альтернатива
//
//        while (reader.hasNext()) {       // while not end of XML
//            int event = reader.next();   // read next event
//            if (event == XMLEvent.START_ELEMENT &&
//                    "account".equals(reader.getLocalName()))
//            {
//                reader.next();reader.next(); //отстойная реализация, надо будет по-другому
//                String acname = reader.getElementText();
//                reader.next(); reader.next();
//                Integer acbal = Integer.valueOf(reader.getElementText());
//                addNewAccount(acname, acbal);
//                //System.out.println(acname+acbal);
//            }
//        }
//    }

}