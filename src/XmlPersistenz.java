import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/**
 * Speichern und Laden von einem xml-File
 *
 * @version 18.10.2023
 * @author Nicole Benin
 */
public class XmlPersistenz implements Persistenz{
    private String pfad = "";
    public XmlPersistenz(String pfad){
        this.pfad = pfad;
    }

    @Override
    public void speichern(WordBildPaar wbp) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            File xmlFile = new File(pfad);
            Document doc = db.parse(xmlFile);
            Element rootElement = doc.getDocumentElement();

            Element teilElement = doc.createElement("teil");
            Element idElement = doc.createElement("id");
            idElement.appendChild(doc.createTextNode(String.valueOf("5")));
            Element wortElement = doc.createElement("wort");
            wortElement.appendChild(doc.createTextNode(wbp.getWort()));
            Element urlElement = doc.createElement("url");
            urlElement.appendChild(doc.createTextNode(wbp.getUrl()));

            teilElement.appendChild(idElement);
            teilElement.appendChild(wortElement);
            teilElement.appendChild(urlElement);

            rootElement.appendChild(teilElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Integer, WordBildPaar> laden() {
        Map<Integer, WordBildPaar> map = new HashMap<>();
        try {
            if(pfad == null){
                map.put(0, new WordBildPaar("Banane","https://www.kochschule.de/sites/default/files/images/kochwissen/440/banane.jpg"));
                map.put(1, new WordBildPaar("Apfel","https://media.happycolorz.de/zeichnen-vorlagen/apfel-zeichnen-6.jpg"));
            }else {

                File f = new File(pfad);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document document = db.parse(f);
                document.getDocumentElement().normalize();
                NodeList nList = document.getElementsByTagName("teil");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) nNode;
                        String id = e.getElementsByTagName("id").item(0).getTextContent();
                        int i = Integer.parseInt(id);
                        String wort = e.getElementsByTagName("wort").item(0).getTextContent();
                        String url= e.getElementsByTagName("url").item(0).getTextContent();
                        map.put(i, new WordBildPaar(wort,url));
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
