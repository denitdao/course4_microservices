package ua.denitdao.kpi.microservices.lab01.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Price {

    @XmlValue
    double value;

    @XmlAttribute(name = "collectible", required = true)
    boolean isCollectible;
}
