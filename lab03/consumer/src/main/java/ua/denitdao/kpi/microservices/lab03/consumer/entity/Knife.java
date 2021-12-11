package ua.denitdao.kpi.microservices.lab03.consumer.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Knife {

    @Id
    @XmlAttribute
    String id;

    @XmlAttribute
    @Enumerated(EnumType.STRING)
    KnifeType type;

    String origin;

    @Enumerated(EnumType.STRING)
    Handy handy;

    @OneToOne(cascade = CascadeType.ALL)
    Visual visual;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(name = "value")
    Price price;
}
