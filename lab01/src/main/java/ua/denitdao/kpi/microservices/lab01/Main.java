package ua.denitdao.kpi.microservices.lab01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ua.denitdao.kpi.microservices.lab01.entity.Knives;
import ua.denitdao.kpi.microservices.lab01.parser.DOMParser;
import ua.denitdao.kpi.microservices.lab01.parser.JAXBParser;
import ua.denitdao.kpi.microservices.lab01.parser.Parser;
import ua.denitdao.kpi.microservices.lab01.parser.XPathParser;
import ua.denitdao.kpi.microservices.lab01.validator.XSDValidator;

@Slf4j
public class Main {
    static final String XML_PATH = "/weapon.xml";
    static final String XSD_PATH = "/weapon.xsd";

    static Parser<Knives> jaxbParser = new JAXBParser();
    static Parser<Knives> domParser = new DOMParser();
    static Parser<Knives> xPathParser = new XPathParser();

    public static void main(String[] args) {
        log.info("is schema valid - {}", XSDValidator.validateXMLSchema(XSD_PATH, XML_PATH));

        Knives knives = jaxbParser.parse(XML_PATH);
        log.info("JAXB: \n{}", knives.toString());
        log.info("DOM:  \n{}", domParser.parse(XML_PATH).toString());
        log.info("XPath:\n{}", xPathParser.parse(XML_PATH).toString());

        log.info("to JSON:\n{}", mapToJson(knives));
    }

    static String mapToJson(Knives knives) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(knives);
            objectMapper.readValue(json, Knives.class);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
