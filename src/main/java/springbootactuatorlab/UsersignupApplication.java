package springbootactuatorlab;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */

@SpringBootApplication
public class UsersignupApplication {

	@Autowired
	private UserRepository userRepository;
	private UserController userController;

	
	public static void main(String[] args) {
		SpringApplication.run(UsersignupApplication.class, args);

	}
	@Bean
	InitializingBean populateUsers() {
		return () -> {
			userRepository.deleteAll();
			userRepository.save(User.builder().id(0).Name("User").Password("123456").build());
			userRepository.save(User.builder().id(1).Name("User").Password("123456").build());
			userRepository.save(User.builder().id(2).Name("User").Password("123456").build());
			userRepository.save(User.builder().id(3).Name("User").Password("123456").build());
			userRepository.save(User.builder().id(4).Name("User").Password("123456").build());
			//userController.addUser(User.builder().id(0));
		};
	}
}
