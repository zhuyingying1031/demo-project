package net.xdclass.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class DemoProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoProjectApplication.class, args);
	}

}
