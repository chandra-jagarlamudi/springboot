package com.ragas.springboot.gitissuesdashboard;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
@EnableCaching
public class GitIssuesDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitIssuesDashboardApplication.class, args);
	}

	// Uncomment the below annotations if you want your application to have
	// both HTTP and HTTPS enabled and forward HTTP requests to HTTPS port for
	// certain resources or URL's

	// @Value("${http.server.port}")
	private int serverPortHttp;

	// @Value("${server.port}")
	private int serverPortHttps;

	// @Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(redirectConnector());
		return tomcat;
	}

	private Connector redirectConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(serverPortHttp);
		connector.setSecure(false);
		connector.setRedirectPort(serverPortHttps);
		return connector;
	}

}
