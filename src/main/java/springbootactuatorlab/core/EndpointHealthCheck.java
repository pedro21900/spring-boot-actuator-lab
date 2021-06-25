package springbootactuatorlab.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import springbootactuatorlab.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Pratik Das
 * @ca-autor Pedro Lenonn
 */
@Component
public class EndpointHealthCheck implements HealthIndicator, HealthContributor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Health health() {
        if(userRepository.existsById("3")){
            ResponseEntity.BodyBuilder response = ResponseEntity.status(HttpStatus.OK);

            return Health.up().build();
            }
        else {
        return  Health.down().withDetail("Endpoint_users","pagina com falha").build();
             }

}}
