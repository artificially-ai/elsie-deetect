package nl.ekholabs.nlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ElsieDeetectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElsieDeetectApplication.class, args);
  }
}
