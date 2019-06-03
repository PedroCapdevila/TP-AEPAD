package isi.aepad.tpintegrador.apptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("isi.aepad.tpintegrador.repository")
@ComponentScan("isi.aepad.tpintegrador.*")
@EntityScan("isi.aepad.tpintegrador.*")
public class ApptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptestApplication.class, args);
	}

}
