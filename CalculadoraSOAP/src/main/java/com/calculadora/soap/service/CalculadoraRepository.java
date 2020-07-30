package com.calculadora.soap.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class CalculadoraRepository {
	
	private static final Logger log = LoggerFactory.getLogger(CalculadoraRepository.class);

	@PostConstruct
	public void initData() {
	
	}

	public static BigDecimal findSuma(BigDecimal operand1, BigDecimal operand2) {
		// TODO Auto-generated method stub
		log.debug("findSuma ");
		BigDecimal result = operand1.add(operand2); 
		
		return result;
	}
	
	public static BigDecimal findResta(BigDecimal operand1, BigDecimal operand2) {
		// TODO Auto-generated method stub
		
		log.debug("findResta ");
		BigDecimal result = operand1.subtract(operand2); 
		
		return result;
	}
	
	public static BigDecimal findMultiplicacion(BigDecimal operand1, BigDecimal operand2) {
		// TODO Auto-generated method stub
		log.debug("findMultiplicacion ");
		BigDecimal result = operand1.multiply(operand2); 
		
		return result;
	}
	
	public static BigDecimal findDivision(BigDecimal operand1, BigDecimal operand2) {
		// TODO Auto-generated method stub
		log.debug("findDivision ");
		BigDecimal result = operand1.divide(operand2,RoundingMode.HALF_UP); 
		
		return result;
	}
	
	
	
}
