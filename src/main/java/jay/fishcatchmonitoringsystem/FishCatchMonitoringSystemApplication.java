package jay.fishcatchmonitoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class FishCatchMonitoringSystemApplication {

	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
	}

	public static void main(String[] args) {
		SpringApplication.run(FishCatchMonitoringSystemApplication.class, args);
		System.out.println(TimeZone.getDefault().getDisplayName());
	}
}
