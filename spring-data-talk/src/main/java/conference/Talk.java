package conference;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Talk {
	

	@Id
	@GeneratedValue
	private Long talkId;
	
	private Date when;
	
	
	private String title;
	
	public Talk() {}
	
	public Talk(String title, Date date) {
		this.title = title;
		this.when = date;
	}
	
	public Date getWhen() {return this.when;}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Talk [when=").append(when).append(", title=")
				.append(title).append("]");
		return builder.toString();
	}
	
	
	

}
