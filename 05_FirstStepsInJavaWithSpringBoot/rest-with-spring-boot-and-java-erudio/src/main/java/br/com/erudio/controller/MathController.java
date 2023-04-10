package br.com.erudio.controller;

import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.erudio.util.NumberConverter.convertToDouble;
import static br.com.erudio.util.NumberConverter.isNumeric;

@RestController
public class MathController {
	private SimpleMath math= new SimpleMath();
	@RequestMapping("sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value="numberOne")String numberOne, @PathVariable(value="numberTwo")String numberTwo)throws Exception{
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
	return math.sum(convertToDouble(numberOne),convertToDouble(numberTwo));
}


	@RequestMapping("sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable(value="numberOne")String numberOne, @PathVariable(value="numberTwo")String numberTwo)throws Exception{
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		return math.sub(convertToDouble(numberOne),convertToDouble(numberTwo));
	}
	@RequestMapping("div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable(value="numberOne")String numberOne, @PathVariable(value="numberTwo")String numberTwo)throws Exception{
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		return math.div(convertToDouble(numberOne),convertToDouble(numberTwo));
	}
	@RequestMapping("mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable(value="numberOne")String numberOne, @PathVariable(value="numberTwo")String numberTwo)throws Exception{
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		return math.mult(convertToDouble(numberOne),convertToDouble(numberTwo));
	}
	@RequestMapping("average/{numberOne}/{numberTwo}")
	public Double average(@PathVariable(value="numberOne")String numberOne, @PathVariable(value="numberTwo")String numberTwo)throws Exception{
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		return  math.average(convertToDouble(numberOne),convertToDouble(numberTwo));
	}
	@RequestMapping("squareRoot/{numberOne}")
	public Double squareRoot(@PathVariable(value="numberOne")String number)throws Exception{

		if(!isNumeric(number)) {
			throw new UnsupportedOperationException("Please set a numeric value");
		}
		return  math.squareRoot(convertToDouble(number));
	}
}
