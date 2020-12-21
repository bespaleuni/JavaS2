import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Runner {
    public static void DOMParser() {
        try {
            File inputFile = new File("src/file.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); // merges adjacent text() nodes and removes empty ones in the whole document.
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("channel");
            System.out.print("--------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
                    System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("Language : " + eElement.getElementsByTagName("language").item(0).getTextContent());
                    System.out.println("Image : " + eElement.getElementsByTagName("image").item(0).getTextContent());
                }
            }

            NodeList itemsNList = doc.getElementsByTagName("item");
            System.out.print("--------------------------");
            for (int temp = 0; temp < itemsNList.getLength(); temp++) {
                Node nNode = itemsNList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
                    System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("pubDate : " + eElement.getElementsByTagName("pubDate").item(0).getTextContent());
                    System.out.println("Category : " + eElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("Guid : " + eElement.getElementsByTagName("guid").item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SAXParser() {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bTitle = false;
                boolean bLink = false;
                boolean bDescription = false;
                boolean bLanguage = false;
                boolean bImage = false;
                boolean bUrl = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("title")) {
                        bTitle = true;
                    }

                    if (qName.equalsIgnoreCase("link")) {
                        bLink = true;
                    }

                    if (qName.equalsIgnoreCase("description")) {
                        bDescription = true;
                    }

                    if (qName.equalsIgnoreCase("language")) {
                        bLanguage = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bTitle) {
                        System.out.println("Title : " + new String(ch, start, length));
                        bTitle = false;
                    }

                    if (bLink) {
                        System.out.println("Link : " + new String(ch, start, length));
                        bLink = false;
                    }

                    if (bDescription) {
                        System.out.println("Description : " + new String(ch, start, length));
                        bDescription = false;
                    }

                    if (bLanguage) {
                        System.out.println("Language : " + new String(ch, start, length));
                        bLanguage = false;
                    }

                    if (bImage) {
                        System.out.println("Image : " + new String(ch, start, length));
                        bImage = false;
                    }

                }

            };

            saxParser.parse("src/file.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Parsing with DOM");
        DOMParser();
        System.out.println("Parsing with SAX");
        SAXParser();
    }
}
