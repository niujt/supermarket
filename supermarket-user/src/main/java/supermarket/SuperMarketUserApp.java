package supermarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wxthxy.supermarket.dao")
public class SuperMarketUserApp {
    public static void main(String[] args) {
        SpringApplication.run(SuperMarketUserApp.class, args);
    }
}
