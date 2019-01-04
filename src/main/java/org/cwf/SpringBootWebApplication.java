package org.cwf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "org.cwf.mapper")
public class SpringBootWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
	
}
