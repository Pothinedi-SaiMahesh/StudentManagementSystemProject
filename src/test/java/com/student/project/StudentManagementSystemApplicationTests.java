package com.student.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class StudentManagementSystemApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	//Testing find By Year
	
	@Test
	public void testFindByYear() throws Exception{
	
	//1)create Request By Using Mocking
	MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
			"/students/year/{year}",2000);			
	//2)Execute Request By Using Mocking
	
	MvcResult result = mockMvc.perform(request).andReturn();
	
	//3)Read Response from the result
	MockHttpServletResponse response = result.getResponse();
	
	//4)Assert Results Using JUnit
	assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	
	//Testing find By name and email
	@Test
	public void testFindByNameAndEmail() throws Exception{
		
		//1)create Request By Using Mocking
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
				"/students/name/{name}/email/{email}","Rahul","rahul101@example.com");
		//2)Execute Request By Using Mocking
		MvcResult result = mockMvc.perform(request).andReturn();
		//3)Read Response from the result
		MockHttpServletResponse response = result.getResponse();
		//4)Assert Results Using JUnit
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	//Testing find By Course and year
	@Test
	@Order(2)
	public void testFindByCourseAndYear() throws Exception{
		
		//1)create Request By Using Mocking
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
				"/students/course/{course}/year/{year}","Spring Boot",2000);
		//2)Execute Request By Using Mocking
		MvcResult result = mockMvc.perform(request).andReturn();
		//3)Read Response from the result
		MockHttpServletResponse response = result.getResponse();
		//4)Assert Results Using JUnit
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
	}
	
}
