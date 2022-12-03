package com.inqoo.TavelOfficeWeb;

import com.inqoo.TavelOfficeWeb.Model.Helper.AuditorAwareProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareProvider")
public class TravelOfficeWebApplication {
	@Bean
	public AuditorAware<String> auditorAwareProvider() {
		return new AuditorAwareProvider();
	}

		public static void main(String[] args) {
		SpringApplication.run(TravelOfficeWebApplication.class, args);
	}

}
