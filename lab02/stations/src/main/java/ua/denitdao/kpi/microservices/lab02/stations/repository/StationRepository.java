package ua.denitdao.kpi.microservices.lab02.stations.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.denitdao.kpi.microservices.lab02.stations.entity.Station;

@RepositoryRestResource(path = "station")
public interface StationRepository extends CrudRepository<Station, Long> {
}
