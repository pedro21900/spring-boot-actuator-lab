/**
 * 
 */
package springbootactuatorlab.core;

import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pedro.Lenonn
 *
 */
@Component
@Slf4j
public class UrlShortenerServiceHealthIndicator implements HealthIndicator, HealthContributor {

	private static final String URL = "http://www.google.com.br";

	@Override
	public Health health() {
		// check if url shortener service url is reachable
        java.net.HttpURLConnection urlConnection = null;

        try {

            java.net.URL url = new java.net.URL(URL);
            urlConnection = (java.net.HttpURLConnection) url.openConnection();

            if (urlConnection.getResponseCode() == java.net.HttpURLConnection.HTTP_OK) {
                return Health.up().build();
            } else {
                return Health.down().withDetail("error", "Failed to connect to : "+URL).build();
            }} catch (Exception e1) {
            log.warn("Failed to connect to : {}",URL);
            return Health.down().withDetail("error", e1.getMessage()).build();
        }

	}
}
