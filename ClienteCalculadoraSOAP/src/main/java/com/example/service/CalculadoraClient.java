package com.example.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.AddRequest;
import com.example.consumingwebservice.wsdl.AddResponse;
import com.example.consumingwebservice.wsdl.DivideRequest;
import com.example.consumingwebservice.wsdl.DivideResponse;
import com.example.consumingwebservice.wsdl.MultiplyRequest;
import com.example.consumingwebservice.wsdl.MultiplyResponse;
import com.example.consumingwebservice.wsdl.SubtractRequest;
import com.example.consumingwebservice.wsdl.SubtractResponse;

//curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
//http://localhost:8080/ws/countries.wsdl
public class CalculadoraClient extends WebServiceGatewaySupport {

private static final Logger log = LoggerFactory.getLogger(CalculadoraClient.class);

public AddResponse getSuma(BigDecimal operando1, BigDecimal operando2) {

  AddRequest request = new AddRequest();
  request.setOperand1(operando1);
  request.setOperand2(operando2);
  
  log.info("Requesting location for " + operando1 +"+"+operando2);

  AddResponse response = (AddResponse) getWebServiceTemplate()
      .marshalSendAndReceive("http://localhost:8080/ws/calculadora", request,
          new SoapActionCallback(
              "http://loadingjava.blogspot.in/AddRequest"));

  return response;
}


public SubtractResponse getResta(BigDecimal operando1, BigDecimal operando2) {

	SubtractRequest request = new SubtractRequest();
	  request.setOperand1(operando1);
	  request.setOperand2(operando2);
	  
	  log.info("Requesting location for " + operando1 +"+"+operando2);

	  SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
	      .marshalSendAndReceive("http://localhost:8080/ws/calculadora", request,
	          new SoapActionCallback(
	              "http://loadingjava.blogspot.in/SubtractRequest"));

	  return response;
	}

public MultiplyResponse getMultiplicacion(BigDecimal operando1, BigDecimal operando2) {

	MultiplyRequest request = new MultiplyRequest();
	  request.setOperand1(operando1);
	  request.setOperand2(operando2);
	  
	  log.info("Requesting location for " + operando1 +"+"+operando2);

	  MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
	      .marshalSendAndReceive("http://localhost:8080/ws/calculadora", request,
	          new SoapActionCallback(
	              "http://loadingjava.blogspot.in/MultiplyRequest"));

	  return response;
	}



public DivideResponse getDivision(BigDecimal operando1, BigDecimal operando2) {

	DivideRequest request = new DivideRequest();
	  request.setOperand1(operando1);
	  request.setOperand2(operando2);
	  
	  log.info("Requesting location for " + operando1 +"+"+operando2);

	  DivideResponse response = (DivideResponse) getWebServiceTemplate()
	      .marshalSendAndReceive("http://localhost:8080/ws/calculadora", request,
	          new SoapActionCallback(
	              "http://loadingjava.blogspot.in/DivideRequest"));

	  return response;
	}








}