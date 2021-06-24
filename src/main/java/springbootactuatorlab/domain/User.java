/**
 * 
 */
package springbootactuatorlab.domain;

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
@Entity//Conecta a tablea a classe
@NoArgsConstructor
@Table(name="USERS")//Usado no caso da da tabela não ter o mesmo nome da classe
public class User {
	
	@Id
	private String id;
	private String Name;
	private String Password;


	public User(String id, String Name, String Password) {
		super();
		this.id = id;
		this.Name = Name;
		this.Password = Password;
	}
	


}
