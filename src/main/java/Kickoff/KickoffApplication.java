package Kickoff;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class KickoffApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickoffApplication.class, args);
	}
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(List.of("http://localhost:4214"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("origin","Access-Control-Allow-Origin","Content-type",
				"Accept","Jwt-Token","Authorization","Origin,Accept","X-Request-With",
					"Access-Control-Request-method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-type","Accept","Jwt-Token","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Credentials","File-Name"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	

}
