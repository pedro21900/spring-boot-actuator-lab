package springbootactuatorlab;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
	

}
