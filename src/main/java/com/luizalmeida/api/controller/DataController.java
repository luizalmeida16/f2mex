package com.luizalmeida.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luizalmeida.api.exception.NegativeValueException;
import com.luizalmeida.api.exception.ValueNotFoundException;
import com.luizalmeida.api.model.Data;
import com.luizalmeida.api.service.DataFromEndpoint;

@RestController
@RequestMapping(DataController.DATA_BASE_URI)
public class DataController {
	
	public static final String DATA_BASE_URI = "/v1/data";
	
	@RequestMapping( value = "{dataIndex}")
	@GetMapping(produces = "application/json")
	public @ResponseBody String getDataItem(@PathVariable final int dataIndex) throws NegativeValueException, ValueNotFoundException {
		if(dataIndex < 0) {
			throw new NegativeValueException("Negative index");
		}
		DataFromEndpoint data = DataFromEndpoint.getInstance();
		String fetch = data.getData();
		if(dataIndex > fetch.length()) {
			throw new ValueNotFoundException("Value not found");
		}
		String fetchStr = "" + fetch.charAt(dataIndex);
		return fetchStr;
	}
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Data getData() {
		DataFromEndpoint dataFromEndpoint = DataFromEndpoint.getInstance();
		Data data = new Data(dataFromEndpoint.getCompressedData(), dataFromEndpoint.getData());
		
		return data;
	}

}
