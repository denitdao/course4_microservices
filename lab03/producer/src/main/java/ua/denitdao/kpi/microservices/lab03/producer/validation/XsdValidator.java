package ua.denitdao.kpi.microservices.lab03.producer.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ua.denitdao.kpi.microservices.lab03.producer.exception.ValidationException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

@Slf4j
@Component
public class XsdValidator {

    @Value("${xsd.path:/weapon.xsd}")
    private String xsdPath;

    public void validateXMLSchema(String inputXml) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(inputXml)));
        } catch (IOException | SAXException e) {
            throw new ValidationException(e);
        }
    }
}
