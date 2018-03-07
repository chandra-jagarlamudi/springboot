/**
 * 
 */
package com.ragas.springboot.gitissuesdashboard.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;

import com.ragas.springboot.gitissuesdashboard.github.GithubClient;
import com.ragas.springboot.gitissuesdashboard.github.RepositoryEvent;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class GithubHealthIndicator implements HealthIndicator {

	private final GithubClient githubClient;

	public GithubHealthIndicator(GithubClient githubClient) {
		this.githubClient = githubClient;
	}

	@Override
	public Health health() {
		try {
			ResponseEntity<RepositoryEvent[]> events = githubClient.fetchEvents("chandra-jagarlamudi", "microservices");
			if (null != events && events.getStatusCode().is2xxSuccessful()) {
				return Health.up().build();
			}
		} catch (Exception e) {
			return Health.down().build();
		}
		return null;
	}

}
