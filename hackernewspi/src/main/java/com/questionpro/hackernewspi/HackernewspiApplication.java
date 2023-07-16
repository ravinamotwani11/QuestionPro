/**
* HackernewspiApplication
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HackernewspiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackernewspiApplication.class, args);
	}

}
