package com.luizalmeida.api.model;

public class Data {
	private String uncompressedData;
	private String compressedData;
	public Data(String compressedData, String uncompressedData) {
		this.compressedData = compressedData;
		this.uncompressedData = uncompressedData;
	}
	public String getCompressedData() {
		return compressedData;
	}
	public void setCompressedData(String compressedData) {
		this.compressedData = compressedData;
	}
	public String getUncompressedData() {
		return uncompressedData;
	}
	public void setUncompressedData(String uncompressedData) {
		this.uncompressedData = uncompressedData;
	}
	
	
	
}
