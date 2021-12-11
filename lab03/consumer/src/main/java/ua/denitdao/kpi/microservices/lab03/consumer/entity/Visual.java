package ua.denitdao.kpi.microservices.lab03.consumer.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Visual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    Long id;

    double length;

    int width;

    String material;

    @OneToOne(cascade = CascadeType.ALL)
    Handle handle;

    boolean hasBloodChannel;
}
