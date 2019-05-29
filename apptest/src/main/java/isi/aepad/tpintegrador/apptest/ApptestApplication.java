package isi.aepad.tpintegrador.apptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("isi.aepad.tpintegrador.repository")
public class ApptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptestApplication.class, args);
	}

}
