package com.luizalmeida.api.compression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luizalmeida.api.component.RLECompression;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompressionDataTests {
	
	@Autowired
	private RLECompression compression;
	
	@Test
	public void compressionTest() {
		String data = "AAAAAAAAAAAAAABBBBBBBBFFFCCKKJTTTTT";
		String compressedData = this.compression.encode(data);
		String expectedCompressedData = "14A8B3F2C2K1J5T";
		
		assertEquals(compressedData, expectedCompressedData);
	}
	
	@Test
	public void uncompressionTest() {
		String compressedData = "14A8B3F2C2K1J5T";
		String uncompressedData = this.compression.decode(compressedData);
		String expectedUncompressedData = "AAAAAAAAAAAAAABBBBBBBBFFFCCKKJTTTTT";
		
		assertEquals(uncompressedData, expectedUncompressedData);
	}

}
