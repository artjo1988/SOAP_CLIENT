package com.soap.client;

import com.soap.client.connector.SoapConnector;
import com.soap.client.services.SoapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SoapClientApplication {

    public static void main(String[] args){
        ApplicationContext ctx =  SpringApplication.run(SoapClientApplication.class, args);
        double intCode = ctx.getBean(SoapService.class).getBicToIntCode("040173725").getBicToIntCodeResult();
        System.out.println(ctx.getBean(SoapService.class).getCreditInfoByIntCodeResponse(intCode).getCreditInfoByIntCodeResult());
	}
}