package student.demo.pro.parcticePro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import student.demo.pro.parcticePro.service.MyThread1;
import student.demo.pro.parcticePro.service.MyThread2;
import student.demo.pro.parcticePro.service.MyThread3;


@SpringBootApplication
@EnableWebSecurity
@ComponentScan("student.demo.pro.parcticePro")

public class ParcticeProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcticeProApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}