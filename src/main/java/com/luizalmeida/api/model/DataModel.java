package com.luizalmeida.api.model;

import java.util.List;

public class DataModel {
	private List<String> data;

	public DataModel(List<String> data) {
		this.data = data;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
	
	
}
