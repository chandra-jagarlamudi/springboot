/**
 * 
 */
package com.ragas.boot.rest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ragas.boot.rest.model.Person;
import com.ragas.boot.rest.model.PersonRepository;

/**
 * One important concept to keep in mind when writing unit tests is that we want
 * to isolate the tested class and test only one layer of the application at a
 * time.
 * 
 * That’s why we mock the repository and prepare a predefined response for
 * findAll() to be returned when it gets called.
 * 
 * @author Chandra Jagarlamudi
 *
 */
public class DrinkingBuddyServiceTest {

	/**
	 * It is considered a good practice to structure your code in a way that enables
	 * you to test individual components of your system separately. Not only that -
	 * ideally also without any Spring context. This can be achieved e.g. by
	 * constructor injection. Constructor injection allows initializing the
	 * components using the new keyword rather than having to @Autowire them in our
	 * unit tests.
	 */

	private PersonRepository repository;
	
	private DrinkingBuddyService service;

	@Before
	public void prepare() {
		repository = mock(PersonRepository.class);
		service = new DrinkingBuddyService(repository);
	}

	@Test
	public void findBuddyTest() {
		List<Person> people = new ArrayList<Person>();

		Person p1 = new Person();
		p1.setId(1l);
		p1.setName("John");
		p1.setAge(25);
		people.add(p1);

		Person p2 = new Person();
		p2.setId(2l);
		p2.setName("Marry");
		p2.setAge(22);
		people.add(p2);

		Person p3 = new Person();
		p3.setId(1l);
		p3.setName("Peter");
		p3.setAge(35);
		people.add(p3);

		when(repository.findAll()).thenReturn(people);

		assertEquals(service.findBuddy(p1), p2);
	}

	@Test
	public void findBuddyNullTest() {
		List<Person> people = new ArrayList<Person>();

		Person p1 = new Person();
		p1.setId(1l);
		p1.setName("John");
		p1.setAge(25);
		people.add(p1);

		when(repository.findAll()).thenReturn(people);
		assertNull(service.findBuddy(null));
		assertNotEquals(service.findBuddy(null), p1);
	}
}
