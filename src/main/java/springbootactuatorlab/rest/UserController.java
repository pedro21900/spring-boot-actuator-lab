/**
 * 
 */
package springbootactuatorlab.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import springbootactuatorlab.domain.User;
import springbootactuatorlab.services.UserService;

/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@RestController//Anotação informa ao Spring que este código descreve um endpoint que deve ser disponibilizado na web
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")// @diz ao Spring para usar o método getUsers para responder a solicitações enviadas para o http://localhost:8080/users
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		BodyBuilder response = ResponseEntity.status(HttpStatus.CREATED);

		return response.build();
	}
	
	@PostMapping("users/activate")
	public ResponseEntity<String> activateUser(@RequestBody User user) {
		userService.addUser(user);
		BodyBuilder response = ResponseEntity.status(HttpStatus.OK);
		return response.build();
	}



}
