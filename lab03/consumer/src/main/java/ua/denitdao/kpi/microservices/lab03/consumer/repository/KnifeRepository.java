package ua.denitdao.kpi.microservices.lab03.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.denitdao.kpi.microservices.lab03.consumer.entity.Knife;

@Repository
public interface KnifeRepository extends CrudRepository<Knife, String> {
}
