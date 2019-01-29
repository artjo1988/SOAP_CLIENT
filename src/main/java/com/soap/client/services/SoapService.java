package com.soap.client.services;

import com.soap.client.connector.SoapConnector;
import com.soap.client.generate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapService {

    @Autowired
    private SoapConnector soapConnector;

	public BicToIntCodeResponse getBicToIntCode(final String bic) {
		BicToIntCode request = new BicToIntCode();
		request.setBicCode(bic);
		return (BicToIntCodeResponse) soapConnector.callWevService(
				"http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx", request, "http://web.cbr.ru/BicToIntCode");
	}

	public CreditInfoByIntCodeResponse getCreditInfoByIntCodeResponse(final double intCode){
        CreditInfoByIntCode request = new CreditInfoByIntCode();
        request.setInternalCode(intCode);
        return (CreditInfoByIntCodeResponse) soapConnector.callWevService("http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx", request, "http://web.cbr.ru/CreditInfoByIntCode");
    }

	public GetDatesForF101Response getDatesForF101Response(final int regNumber) {
		GetDatesForF101 request = new GetDatesForF101();
		request.setCredprgNumber(regNumber);
		return (GetDatesForF101Response) soapConnector.callWevService(
				"http://www.cbr.ru/CreditInfoWebServ/CreditOrgInfo.asmx", request, "http://web.cbr.ru/GetDatesForF101");
	}

}
