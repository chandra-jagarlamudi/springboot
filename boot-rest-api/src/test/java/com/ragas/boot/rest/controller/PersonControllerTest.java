/**
 * 
 */
package com.ragas.boot.rest.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ragas.boot.rest.model.Person;
import com.ragas.boot.rest.model.PersonRepository;

/**
 * Testing without Spring context is fast and useful but it cannot be done that
 * way in all situations. Sometimes, we need to have a SpringContext to test
 * some parts of our application.
 * 
 * With Spring Boot, we can make use of slicing feature, which launches only the
 * part of Spring context that we need. You can, of course, still launch the
 * whole Spring context using @SpringBootTest annotation when performing
 * integration testing.
 * 
 * @author Chandra Jagarlamudi
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
	/**
	 * To test controllers, we need to launch the WebMvc context slice. Ideally, we
	 * should only load the single controller we are going to test instead of the
	 * whole web layer. This can be done easily with @WebMvcTest annotation:
	 */
	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonRepository personRepo;

	@Test
	public void getPersonTest() throws Exception {
		Person person = new Person();
		person.setId(1l);
		person.setName("John");
		person.setAge(25);

		given(personRepo.findOne(1l)).willReturn(person);
		mvc.perform(get("/people/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.name", is("John")))
				.andExpect(jsonPath("$.age", is(25)));
	}

	@Test
	public void personNotFoundTest() throws Exception {
		mvc.perform(get("/people/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
	}
}
