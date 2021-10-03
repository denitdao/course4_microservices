package ua.denitdao.kpi.microservices.lab01.entity;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Handle {

    @XmlValue
    String material;

    @XmlAttribute
    String kind;
}
