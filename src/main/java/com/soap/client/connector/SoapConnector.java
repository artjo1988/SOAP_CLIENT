package com.soap.client.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SoapConnector extends WebServiceGatewaySupport {

	@Autowired
	@Qualifier("generate")
	Jaxb2Marshaller marshallerGenerate;

	@Autowired
	@Qualifier("model")
	Jaxb2Marshaller marshallerModel;

	public Object callWevServiceGenerate(String url, Object request, String action) {
		WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
		getWebServiceTemplate().setMarshaller(marshallerGenerate);
		getWebServiceTemplate().setUnmarshaller(marshallerGenerate);
		return webServiceTemplate.marshalSendAndReceive(url, request, new SoapActionCallback(action));
	}

	public Object callWevServiceModel(String url, Object request, String action) {
		WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
		getWebServiceTemplate().setMarshaller(marshallerModel);
		getWebServiceTemplate().setUnmarshaller(marshallerModel);
		return webServiceTemplate.marshalSendAndReceive(url, request, new SoapActionCallback(action));
	}
}
