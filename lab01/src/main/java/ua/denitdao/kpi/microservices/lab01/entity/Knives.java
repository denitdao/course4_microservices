package ua.denitdao.kpi.microservices.lab01.entity;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "knives")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Knives {

    @XmlElement(name = "knife")
    List<Knife> knifeList;
}
