package ua.denitdao.kpi.microservices.lab01.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Visual {

    double length;

    int width;

    String material;

    Handle handle;

    boolean hasBloodChannel;
}
