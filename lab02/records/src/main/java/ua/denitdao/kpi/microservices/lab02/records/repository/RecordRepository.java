package ua.denitdao.kpi.microservices.lab02.records.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.denitdao.kpi.microservices.lab02.records.entity.Record;

@RepositoryRestResource(path = "record")
public interface RecordRepository extends CrudRepository<Record, Long> {
}
