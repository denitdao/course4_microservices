package ua.denitdao.kpi.microservices.lab01.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.denitdao.kpi.microservices.lab01.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements Parser<Knives> {

    @Override
    public Knives parse(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("lab01/src/main/resources" + path);
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("knife");
            List<Knife> knifeList = new ArrayList<>();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                knifeList.add(buildKnife((Element) node));
            }
            return new Knives(knifeList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Knife buildKnife(Element element) {
        return Knife.builder()
                .id(element.getAttribute("id"))
                .type(KnifeType.valueOf(element.getAttribute("type")))
                .origin(element.getElementsByTagName("origin").item(0).getTextContent())
                .handy(Handy.valueOf(element.getElementsByTagName("handy").item(0).getTextContent()))
                .visual(buildVisual((Element) element.getElementsByTagName("visual").item(0)))
                .price(buildPrice((Element) element.getElementsByTagName("value").item(0)))
                .build();
    }

    private Visual buildVisual(Element element) {
        Visual visual = new Visual();
        visual.setMaterial(element.getElementsByTagName("material").item(0).getTextContent());
        visual.setWidth(Integer.parseInt(element.getElementsByTagName("width").item(0).getTextContent()));
        visual.setLength(Double.parseDouble(element.getElementsByTagName("length").item(0).getTextContent()));
        return visual;
    }

    private Price buildPrice(Element element) {
        Price price = new Price();
        price.setCollectible(Boolean.parseBoolean(element.getAttribute("collectible")));
        price.setValue(Double.parseDouble(element.getTextContent()));
        return price;
    }
}
/*
*
* <knife id="kn15e" type="KNIFE">
        <origin>Ukraine</origin>
        <handy>ONE_HANDED</handy>
        <visual>
            <length>11.5</length>
            <width>24</width>
            <material>Ceramic</material>
            <handle kind="cedar">Wood</handle>
            <hasBloodChannel>false</hasBloodChannel>
        </visual>
        <value collectible="false">35.40</value>
    </knife>
*
* */