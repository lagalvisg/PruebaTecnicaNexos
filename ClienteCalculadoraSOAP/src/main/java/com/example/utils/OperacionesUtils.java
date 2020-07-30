package com.example.utils;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consumingwebservice.wsdl.SubtractResponse;
import com.example.service.CalculadoraClient;

@Service
public class OperacionesUtils {
	
    @Autowired
	CalculadoraClient calculadoraClient;
	
    
    private static final Logger LOGGER = LogManager.getLogger(OperacionesUtils.class);

    
	
	
	public OperacionesUtils() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BigDecimal operacionPendiente(BigDecimal y2, BigDecimal y1, BigDecimal x2, BigDecimal x1) {
		
		LOGGER.debug("operacionPendiente");
    
	        
    BigDecimal pendiente = null;

	
   	SubtractResponse numeradorR = calculadoraClient.getResta(y2, y1);
   	BigDecimal numerador = numeradorR.getResult();
   	
   	SubtractResponse denominadorR = calculadoraClient.getResta(x2, x1);
   	BigDecimal denominador = denominadorR.getResult();
   	

      pendiente = calculadoraClient.getDivision(numerador, denominador).getResult();
	
       return pendiente;	
	}
	
	
	public BigDecimal operacionPromedio(BigDecimal x1, BigDecimal x2, BigDecimal x3, BigDecimal x4) {
		
		LOGGER.debug("operacionPromedio");

		 BigDecimal promedio = null;

  	BigDecimal suma1 = calculadoraClient.getSuma(x1, x2).getResult();
  	
  	BigDecimal suma2 = calculadoraClient.getSuma(x3, x4).getResult();
  	
  	BigDecimal total = calculadoraClient.getSuma(suma1, suma2).getResult();
  	
  	BigDecimal N = new BigDecimal(4);
  	
  	promedio = calculadoraClient.getDivision(total, N).getResult();

      return promedio;
		
		
	}
	
	
	public BigDecimal operacionTriangulo(BigDecimal base, BigDecimal altura) {
		

		LOGGER.debug("operacionTriangulo");
		
		 BigDecimal areaTriangulo = null;

		 BigDecimal numerador = calculadoraClient.getMultiplicacion(base, altura).getResult();
  	
		 areaTriangulo = calculadoraClient.getDivision(numerador, new BigDecimal(2)).getResult();

      return areaTriangulo;
		
		
	}
	
	
	public BigDecimal operacionCirculo(BigDecimal radio) {
		

		LOGGER.debug("operacionCirculo");
		
		 BigDecimal areaCirculo = null;


  	     BigDecimal radio2 = calculadoraClient.getMultiplicacion(radio, radio).getResult();
		 areaCirculo = calculadoraClient.getMultiplicacion(new BigDecimal(3.1416),radio2 ).getResult();

      return areaCirculo;
		
		
	}

}
