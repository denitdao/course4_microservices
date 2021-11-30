package ua.denitdao.kpi.microservices.lab02.records.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stationId;

    private String description;

    @OneToOne(mappedBy = "record")
    private AdditionalInfo additionalInfo;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
