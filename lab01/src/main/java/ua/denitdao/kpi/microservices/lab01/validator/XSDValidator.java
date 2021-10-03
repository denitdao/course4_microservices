package ua.denitdao.kpi.microservices.lab01.validator;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Slf4j
public class XSDValidator {

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("lab01/src/main/resources" + xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("lab01/src/main/resources" + xmlPath)));
        } catch (IOException | SAXException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
