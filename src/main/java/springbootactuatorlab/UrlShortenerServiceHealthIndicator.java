/**
 * 
 */
package springbootactuatorlab;

import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@Component
@Slf4j
public class UrlShortenerServiceHealthIndicator implements HealthIndicator, HealthContributor {

	private static final String URL = "http://localhost:8080/users";

	@Override
	public Health health() {
		// check if url shortener service url is reachable
		try (Socket socket = new Socket(new java.net.URL(URL).getHost(),8080)) {
        } catch (Exception e1) {
            log.warn("Failed to connect to : {}",URL);
            return Health.down().withDetail("error", e1.getMessage()).build();
        }
        return Health.up().build();
	}
}
