package com.soap.client;

import com.soap.client.services.SoapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SoapClientApplication {



	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SoapClientApplication.class, args);
		double intCode =
         ctx.getBean(SoapService.class).getBicToIntCode("040173725").getBicToIntCodeResult();
         Object x =
         ctx.getBean(SoapService.class).getCreditInfoByIntCodeResponse(new BigDecimal(intCode).doubleValue()).getCreditInfoByIntCodeXMLResult();
	}
}