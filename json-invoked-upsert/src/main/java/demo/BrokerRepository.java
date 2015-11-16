package demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends CrudRepository<Broker, Long> {
	
	Broker findBySaleforceId (String saleforceId);
	Broker findBySaleforceIdAndDeleted (String saleforceId, Boolean deleted);
	
} 


