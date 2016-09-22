/**
 * 
 */
package conference;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author sleyzerzon
 *
 */
@Entity
public class Speaker {
	
	@Id
	@GeneratedValue
	private Long speakerId;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Talk> talks;
	
	public Speaker() {}
	
	public Speaker(String name) {this.name = name;}
	
	public void addTalk(Talk talk) {
		if(talks == null) talks = new HashSet<Talk>();
		talks.add(talk);
		
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Talk> getTalks(){return talks;}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speaker [name=").append(name).append("]");
		return builder.toString();
	}

}
