package demo;

import static demo.Action.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("brokerService")
public class BrokerService {

	private final Logger logger = LoggerFactory.getLogger(BrokerService.class);

	@Autowired
	private BrokerRepository brokerDao;

	@SuppressWarnings("unused")
	@Transactional
	public Broker upsert(final Broker broker, final String action) {

		logger.info("Handling {} for broker with sfid={}", translate(action),
				broker.getSaleforceId());

		Broker latest = brokerDao.findBySaleforceIdAndDeleted(
				broker.getSaleforceId(), false);

		Broker result = null;

		switch (action) {

		case "i":

			if (latest == null) {
				broker.setDeleted(false);
				brokerDao.save(broker);
			}

			break;

		case "u":
			if (latest != null) {
				latest.setDeleted(true);
				result = brokerDao.save(latest);

				broker.setDeleted(false);
				brokerDao.save(broker);
			}
			logger.info("Nothing to update, the record was in a deleted state.");
			break;

		case "d":
			if (latest != null) {
				latest.setDeleted(true);
				brokerDao.save(latest);
			}

			break;
		}

		return result;

	}

}
