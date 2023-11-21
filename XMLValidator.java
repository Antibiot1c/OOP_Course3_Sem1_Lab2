import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

import org.w3c.dom.Document;

public class XMLValidator {

    public static boolean validateXML(String xmlPath, String xsdPath) {
        try {
            // Створюємо фабрику схеми
            SchemaFactory factory = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Завантажуємо схему з файлу XSD
            Schema schema = factory.newSchema(new File(xsdPath));

            // Створюємо об'єкт DocumentBuilder для обробки XML
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setSchema(schema);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Парсимо XML-файл
            Document document = documentBuilder.parse(new File(xmlPath));

            // Якщо парсинг пройшов успішно, то XML є валідним
            return true;

        } catch (Exception e) {
            // Виводимо інформацію про помилку, якщо вона виникла
            e.printStackTrace();
            // Повертаємо false, оскільки валідація не пройшла успішно
            return false;
        }
    }
}
