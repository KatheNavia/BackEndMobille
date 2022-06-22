package co.edu.uniajc.vacunacion;

import co.edu.uniajc.vacunacion.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class VacunacionApplication {

	public static void main(String[] args) { SpringApplication.run(VacunacionApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		private final String[] AUTH_WHITELIST = {
				// -- Login
				"/login/**",
				// -- Create
				"/users/save",
				// -- Swagger UI v3 (OpenAPI)
				"/v3/api-docs/**",
				"/swagger-ui/**"

		};

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(AUTH_WHITELIST).permitAll()
					.anyRequest().authenticated();

		}
	}
}
