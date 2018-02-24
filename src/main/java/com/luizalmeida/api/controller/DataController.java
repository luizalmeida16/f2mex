package com.luizalmeida.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luizalmeida.api.exception.NegativeValueException;
import com.luizalmeida.api.exception.ValueNotFoundException;
import com.luizalmeida.api.model.DataModel;
import com.luizalmeida.api.service.DataFromEndpoint;

@RestController
@RequestMapping(DataController.DATA_BASE_URI)
public class DataController {
	
	public static final String DATA_BASE_URI = "/v1/data";
	private DataFromEndpoint dataFromEndpoint = DataFromEndpoint.getInstance();
	
	@RequestMapping( value = "{dataIndex}")
	@GetMapping(produces = "application/json")
	public @ResponseBody String getDataItem(@PathVariable final int dataIndex) throws NegativeValueException, ValueNotFoundException {
		if(dataIndex < 0) {
			throw new NegativeValueException("Negative index");
		}
		String fetch = dataFromEndpoint.getData();
		if(dataIndex > fetch.length()) {
			throw new ValueNotFoundException("Value not found");
		}
		String dataString = "" + dataFromEndpoint.getData();
		List<String> dataList = new ArrayList<String>();
		for(int i = 0; i < dataString.length(); i++)
			dataList.add("" + dataString.charAt(i));
		DataModel data = new DataModel(dataList);
		
		return data.getData().get(dataIndex);
	}
	
	//Extra bonus
	@GetMapping(produces = "application/json")
	public @ResponseBody DataModel getData() {
		String dataString = "" + dataFromEndpoint.getData();
		List<String> dataList = new ArrayList<String>();
		for(int i = 0; i < dataString.length(); i++)
			dataList.add("" + dataString.charAt(i));
		DataModel data = new DataModel(dataList);
		
		return data;
	}

}
