package com.calculadora.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



import in.blogspot.loadingjava.AddRequest;
import in.blogspot.loadingjava.AddResponse;
import in.blogspot.loadingjava.DivideRequest;
import in.blogspot.loadingjava.DivideResponse;
import in.blogspot.loadingjava.MultiplyRequest;
import in.blogspot.loadingjava.MultiplyResponse;
import in.blogspot.loadingjava.SubtractRequest;
import in.blogspot.loadingjava.SubtractResponse;



@Endpoint
public class CalculadoraEndPoint {
	
	private static final String NAMESPACE_URI = "http://loadingjava.blogspot.in";
	
	private CalculadoraRepository calculadoraRepository;
	
	@Autowired
	public CalculadoraEndPoint (CalculadoraRepository calculadoraRepository) {
		this.calculadoraRepository = calculadoraRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
	@ResponsePayload
	public AddResponse getAdd(@RequestPayload AddRequest request) {
		AddResponse response = new AddResponse();
		response.setResult(
				CalculadoraRepository.findSuma(request.getOperand1(),request.getOperand2()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "subtractRequest")
	@ResponsePayload
	public SubtractResponse getSubtract(@RequestPayload SubtractRequest request) {
		SubtractResponse response = new SubtractResponse();
		response.setResult(
				CalculadoraRepository.findResta(request.getOperand1(),request.getOperand2()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "multiplyRequest")
	@ResponsePayload
	public MultiplyResponse getMultiplication(@RequestPayload MultiplyRequest request) {
		MultiplyResponse response = new MultiplyResponse();
		response.setResult(
				CalculadoraRepository.findMultiplicacion(request.getOperand1(),request.getOperand2()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "divideRequest")
	@ResponsePayload
	public DivideResponse getDivision(@RequestPayload DivideRequest request) {
		DivideResponse response = new DivideResponse();
		response.setResult(
				CalculadoraRepository.findDivision(request.getOperand1(),request.getOperand2()));

		return response;
	}

}
