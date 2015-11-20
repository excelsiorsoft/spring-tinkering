/**
 * 
 */
package conference;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author sleyzerzon
 *
 */
@RepositoryDefinition(domainClass = Talk.class, idClass = Long.class)
public interface TalkRepository {

	List<Talk> findByTitleLikeIgnoreCase(String title);
}
