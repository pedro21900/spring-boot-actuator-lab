/**
 * 
 */
package springbootactuatorlab;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name="USERS")
public class User {
	
	@Id
	private int id;
	private String Name;
	private String Password;


	public User(int id, String Name, String Password) {
		super();
		this.id = id;
		this.Name = Name;
		this.Password = Password;
	}
	


}
