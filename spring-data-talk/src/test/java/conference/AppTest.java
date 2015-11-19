/**
 * 
 */
package conference;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sleyzerzon
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AppTest {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);
	
	@Autowired
	private SpeakerRepository speakerRepository;
	
	
	@Before
	@Rollback(false)
	public void setUp() throws Throwable {
		
		Speaker george = new Speaker("mr George Martin");
		george.addTalk(new Talk("Game of Thrones", time("8:00")));
		
		Speaker martin = new Speaker("mr Martin Toshev");
		martin.addTalk(new Talk("Modularity of the Java Platform", time("18:30")));
		
		Speaker jeka = new Speaker("mr Evgeny Borisov");
		martin.addTalk(new Talk("Spring Puzzlers", time("10:55")));
		
		jeka.addTalk(new Talk("Spring the Ripper", time("13:05")));
		jeka.addTalk(new Talk("Spring Data", time("14:40")));
		
		
		Speaker nikolay = new Speaker("mr Nikolay Alimenkov");
		nikolay.addTalk(new Talk("Who needs JMS???", time("15:35")));
		
		Speaker tomas = new Speaker ("mr Tomasz Borek");
		tomas.addTalk(new Talk("It's not always application's fault!", time("13:05")));
		tomas.addTalk(new Talk("Java Memory Consistency Model", time("17:35")));
		
		speakerRepository.save(Arrays.asList(jeka, martin, tomas, nikolay, george));
		
	}
	
	@Test
	public void testCount() {
		LOG.info("***************** Number of speakers **********************");
		LOG.info("Speaker count: " + speakerRepository.count());
		LOG.info("*********************************************************");
	
	}

	
	@Test
	public void testFindAll(){
		LOG.info("********************* ALL SPEAKERS ************************");
		Iterable<Speaker> allSpeakers = speakerRepository.findAll(new Sort(Sort.Direction.ASC,"name"))/*getAllSpeakers()*/;
		
		for(Speaker speaker: allSpeakers) {
			LOG.info(speaker.getName());
		}
		
		LOG.info("***********************************************************");
		
	}	
	
	
	/*public void FindByName() {
		LOG.info("********************* All Talks of Borisov Evgeny ************************");
		
		Speaker speaker = speakerRepository.findByName("mr Evgeny Borisov").get(0);
		Set<Talk> talks = speaker.getTalks();
		for(Talk talk: talks) {
			LOG.info("talk = " + talk);
		}
		LOG.info("***************************************************************************");
	}*/
	
	
	@After
	public void clean() {speakerRepository.deleteAll();	}
	
	private Date time(String time) throws Throwable {
		
		/*String[] split = time.split(":");
		int hours = Integer.parseInt(split[0]);
		int minutes = Integer.parseInt(split[1]);
		return from(of(hours,minutes).atDate(now()).atZone(systemDefault()).toInstance())*/
		DateFormat format = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
		Date date = format.parse(time);
		return date;
	}
	

}
