package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	@RequestMapping("sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value="numberOne")String numberOne,
@PathVariable(value="numberTwo")String numberTwo){
	return Double.valueOf(numberOne)+ Double.valueOf(numberTwo);
}

}
