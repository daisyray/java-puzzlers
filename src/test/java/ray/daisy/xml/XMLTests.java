package ray.daisy.xml;

import org.testng.annotations.Test;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import java.io.File;

import static org.testng.Assert.*;

public class XMLTests {

    private Node catalogNameNode;

    @Test
    public void parseXml() throws Exception {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File("src/test/resources/books.xml"));
            Element root = document.getDocumentElement();
            assertEquals(root.getTagName(), "catalog");
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/catalog/name";
            XPathExpression xPathExpression = xPath.compile(expression);
            NodeList nodeList = (NodeList) xPathExpression.evaluate(root, XPathConstants.NODESET);
            assertEquals(nodeList.getLength(), 1);
            NodeList bookList = (NodeList) xPath.compile("/catalog/book").evaluate(root, XPathConstants.NODESET);
            assertEquals(bookList.getLength(), 12);

            NodeList book103List = (NodeList) xPath.compile("/catalog/book[@id='bk103']").evaluate(root, XPathConstants.NODESET);
            assertEquals(book103List.getLength(), 1);
            Node book103 = book103List.item(0);
            assertNotNull(book103);

            NodeList authorList = (NodeList) xPath.compile("author").evaluate(book103, XPathConstants.NODESET);
            assertEquals(authorList.getLength(), 1);
            Node authorNode = authorList.item(0);
            assertNotNull(authorNode);
            assertEquals(authorNode.getTextContent(), "Corets, Eva");

            NodeList book103ListAuthor = (NodeList) xPath.compile("/catalog/book[@id='bk103']/author").evaluate(root, XPathConstants.NODESET);
            assertEquals(book103ListAuthor.item(0).getTextContent(), "Corets, Eva");

            NodeList book106DescriptionList = (NodeList) xPath.compile("/catalog/book[@id='bk106']/description").evaluate(root, XPathConstants.NODESET);
            assertNotNull(book106DescriptionList);
            assertEquals(book106DescriptionList.getLength(), 1);
            Node book106DescriptionNode = book106DescriptionList.item(0);
            assertNotNull(book106DescriptionNode);
            NamedNodeMap namedNodeMap = book106DescriptionNode.getAttributes();
            assertEquals(namedNodeMap.getLength(), 2);
            Node colorNode = namedNodeMap.getNamedItem("color");
            assertEquals(colorNode.getTextContent(), "red");

            NodeList book106DescriptionList1 = (NodeList) xPath.compile("/catalog/book[@id='bk106']/description/@color").evaluate(root, XPathConstants.NODESET);
            assertEquals(book106DescriptionList1.getLength(), 1);
            Node colorAttr = book106DescriptionList1.item(0);
            assertEquals(colorAttr.getTextContent(), "red");

            Node book106Color = (Node) xPath.compile("/catalog/book[@id='bk106']/description/@color").evaluate(root, XPathConstants.NODE);
            assertEquals(book106Color.getTextContent(), "red");

            Node book103Author3 = (Node) xPath.compile("/catalog/book/description[@color='yellow' and @author='praveen']").evaluate(root, XPathConstants.NODE);
            assertNotNull(book103Author3);
            assertTrue(book103Author3.getTextContent().startsWith("After the collapse of a nanotechnology"));

            Node book5 = (Node) xPath.compile("/catalog/book[position()=5]").evaluate(root, XPathConstants.NODE);
            assertEquals(book5.getAttributes().getNamedItem("id").getTextContent(), "bk105");

    }
}
