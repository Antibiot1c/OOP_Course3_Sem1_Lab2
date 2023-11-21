public class GemApp {
    public static void main(String[] args) {
        String xmlFilePath = "D:\\JavaProjects\\JavaOOPLab2\\resources\\gem.xml";
        String xsdFilePath = "D:\\JavaProjects\\JavaOOPLab2\\resources\\gem.xsd";

        if (XMLValidator.validateXML(xmlFilePath, xsdFilePath)) {
            System.out.println("XML відповідає XSD схемі.");
        } else {
            System.out.println("XML не відповідає XSD схемі.");
        }
    }
}
