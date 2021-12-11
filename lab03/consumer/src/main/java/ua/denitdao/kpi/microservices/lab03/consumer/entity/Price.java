package ua.denitdao.kpi.microservices.lab03.consumer.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    Long id;

    @XmlValue
    double value;

    @XmlAttribute(name = "collectible", required = true)
    boolean isCollectible;
}
