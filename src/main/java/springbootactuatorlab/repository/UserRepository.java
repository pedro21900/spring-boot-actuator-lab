package springbootactuatorlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootactuatorlab.domain.User;

/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@Repository//Jpa faz manipulaçoes no banco de dados

public interface UserRepository extends JpaRepository<User, String>{
	

}
