package ua.denitdao.kpi.microservices.lab01.entity;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Knife {

    @XmlAttribute
    String id;

    @XmlAttribute
    KnifeType type;

    String origin;

    Handy handy;

    Visual visual;

    @XmlElement(name = "value")
    Price price;
}
