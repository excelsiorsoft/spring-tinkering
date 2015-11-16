/**
 * 
 */
package conference;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author sleyzerzon
 *
 */
@Repository
public class SpeakerRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Speaker> findByName(String name){
		Query query = em.createQuery("select s from Speaker as s where s.name=:name");
		return query.setParameter("name", name).getResultList();
	}
	
	public Iterable<Speaker> getAllSpeakers(){
		return em.createQuery("from Speaker").getResultList();
	}
	
	public void save(List<Speaker> speakers) {
		for (Speaker speaker: speakers) {
			em.persist(speaker);
		}
	}
	
	public long count() {return (Long) em.createQuery("select count(s.name) from Speaker s").getSingleResult();}
	
	public void deleteAll() {em.createQuery("delete from Speaker").executeUpdate();}

}
