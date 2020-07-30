package com.example.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.AddResponse;
import com.example.consumingwebservice.wsdl.DivideResponse;
import com.example.consumingwebservice.wsdl.MultiplyResponse;
import com.example.consumingwebservice.wsdl.SubtractResponse;
import com.example.service.CalculadoraClient;
import com.example.utils.OperacionesUtils;




@RestController
public class OperacionesController {
	

   /* @Autowired
    CalculadoraClient CalculadoraClient;
    
 
    private OperacionesUtils operacionesUtils = new OperacionesUtils();

	@GetMapping("/getSuma/{name}")
	public AddResponse getSuma (@PathVariable String name){
    	String Calculadora="";
    	BigDecimal operando1 = new BigDecimal(2);
    	BigDecimal operando2 = new BigDecimal(5);

    	AddResponse response = CalculadoraClient.getSuma(operando1, operando2);
    	
    	
    	
        return response;
  
 
    }
	
	
	@GetMapping("/getResta/{name}")
	public SubtractResponse getResta(@PathVariable String name){
    	String Calculadora="";
    	BigDecimal operando1 = new BigDecimal(2);
    	BigDecimal operando2 = new BigDecimal(5);

    	SubtractResponse response = CalculadoraClient.getResta(operando1, operando2);
    	
    	
    	
        return response;
  
 
    }
	
	@GetMapping("/getMultiplicacion/{name}")
	public MultiplyResponse getMultiplicar (@PathVariable String name){
    	String Calculadora="";
    	BigDecimal operando1 = new BigDecimal(2);
    	BigDecimal operando2 = new BigDecimal(5);

    	MultiplyResponse response = CalculadoraClient.getMultiplicacion(operando1, operando2);
    	
    	
    	
        return response;
  
 
    }
	
	
	@GetMapping("/getDivision/{name}")
	public DivideResponse getDivision (@PathVariable String name){
    	String Calculadora="";
    	BigDecimal operando1 = new BigDecimal(2);
    	BigDecimal operando2 = new BigDecimal(5);

    	DivideResponse response = CalculadoraClient.getDivision(operando1, operando2);
    	
    	
    	
        return response;
  
 
    }
	
	*/
	
	@Autowired
	OperacionesUtils operacionesUtils;
	
	@GetMapping("/getPendiente")
	@ResponseBody
	public BigDecimal getPendiente (@RequestParam(required=false, defaultValue="0") BigDecimal y2, @RequestParam(required=false, defaultValue="0") BigDecimal y1,
			@RequestParam(required=false, defaultValue="0") BigDecimal x2,@RequestParam(required=false, defaultValue="0") BigDecimal x1){
    	
		 BigDecimal pendiente = operacionesUtils.operacionPendiente(y2, y1, x2, x1);


        return pendiente;
  
 
    }

	@GetMapping("/getPromedio")
	@ResponseBody
	public BigDecimal getPromedio (@RequestParam(required=false, defaultValue="0") BigDecimal x1, @RequestParam(required=false, defaultValue="0") BigDecimal x2,
			@RequestParam(required=false, defaultValue="0") BigDecimal x3,@RequestParam(required=false, defaultValue="0") BigDecimal x4){
    	
		 BigDecimal pendiente = operacionesUtils.operacionPromedio(x1, x2, x3, x4);


        return pendiente;
  
 
    }
	
	@GetMapping("/getTriangulo")
	@ResponseBody
	public BigDecimal getTriangulo (@RequestParam(required=false, defaultValue="0") BigDecimal base, @RequestParam(required=false, defaultValue="0") BigDecimal altura){
    	
		 BigDecimal pendiente = operacionesUtils.operacionTriangulo(base,altura);


        return pendiente;
  
 
    }
	
	@GetMapping("/getCirculo")
	@ResponseBody
	public BigDecimal getCirculo (@RequestParam(required=false, defaultValue="0") BigDecimal radio){
    	
		 BigDecimal areaCirculo = operacionesUtils.operacionCirculo(radio);


        return areaCirculo;
  
 
    }
	
	

	
	
    
    
}
