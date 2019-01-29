package com.soap.client.connector;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


@Component
public class SoapConnector extends WebServiceGatewaySupport {

    public Object callWevService(String url, Object request, String action) {
		return getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback(action));
	}

}
