package springbootactuatorlab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import springbootactuatorlab.domain.User;
import springbootactuatorlab.repository.UserRepository;

/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private MeterRegistry meterRegistry;
	public void addUser(User user) {
	    log.info("adding users {}",user);
	   // meterRegistry.counter("users", 1);
		userRepository.save(user);
		
	}
	
	public void activateUser(User user) {
		userRepository.save(user);
		
	}
	
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}
	
	

}
