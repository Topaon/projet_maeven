package sg.corporation.bank;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Classe de configuration pour la sécurité des API rest
@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain prout(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(prout -> prout
					.anyRequest().permitAll())
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
		User.UserBuilder users = User.builder();
		UserDetails sarah = users
				.username("sarah1")
				.password(passwordEncoder.encode("abc123"))
				.roles("user") // No roles for now
				.build();
		return new InMemoryUserDetailsManager(sarah);
	 }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}