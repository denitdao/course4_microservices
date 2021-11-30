package ua.denitdao.kpi.microservices.lab02.records.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "record_id")
    private Record record;

    private Double temperature;

    private Double humidity;

    private String airflow;
}
