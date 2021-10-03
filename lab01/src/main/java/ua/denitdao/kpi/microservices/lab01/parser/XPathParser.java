package ua.denitdao.kpi.microservices.lab01.parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ua.denitdao.kpi.microservices.lab01.entity.Knife;
import ua.denitdao.kpi.microservices.lab01.entity.KnifeType;
import ua.denitdao.kpi.microservices.lab01.entity.Knives;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XPathParser implements Parser<Knives> {

    @Override
    public Knives parse(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("lab01/src/main/resources" + path);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            Number nOfElements = (Number) xpath.compile("count(/knives/knife)")
                    .evaluate(document, XPathConstants.NUMBER);

            List<Knife> knifeList = new ArrayList<>();
            for (int i = 1; i <= nOfElements.intValue(); i++) {
                XPathExpression id = xpath.compile("/knives/knife[" + i + "]/attribute::id");
                XPathExpression type = xpath.compile("/knives/knife[" + i + "]/attribute::type");
                XPathExpression origin = xpath.compile("/knives/knife[" + i + "]/origin");

                Knife knife = Knife.builder()
                        .id((String) id.evaluate(document, XPathConstants.STRING))
                        .type(KnifeType.valueOf((String) type.evaluate(document, XPathConstants.STRING)))
                        .origin((String) origin.evaluate(document, XPathConstants.STRING))
                        .build();
                knifeList.add(knife);
            }
            return new Knives(knifeList);
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }
}
