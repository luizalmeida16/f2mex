package com.luizalmeida.api.data;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.luizalmeida.api.controller.DataController;
import com.luizalmeida.api.service.DataFromEndpoint;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataControllerTests {
	
	private MockMvc mockMvc;
	private DataFromEndpoint dataFromEndpoint = DataFromEndpoint.getInstance();
	
	
	@Before
	public void setData() {
		DataController data = new DataController();
		mockMvc = standaloneSetup(data).build();
		dataFromEndpoint.setCompressedData("2A");
	}
	
	//Request ok test
	@Test
	public void getIndex() throws Exception {
		System.out.println(dataFromEndpoint.getData());
		mockMvc.perform(get("/v1/data/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                	.andExpect(content().string("A"));
	}
	
	//Element not found test
	@Test
	public void getIndexNotFoundTest() throws Exception {
		System.out.println(dataFromEndpoint.getData());
		mockMvc.perform(get("/v1/data/3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
	}
	
	//Bad request test
		@Test
		public void getIndexBadRequestTest() throws Exception {
			System.out.println(dataFromEndpoint.getData());
			mockMvc.perform(get("/v1/data/-1")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isBadRequest());
		}
}
