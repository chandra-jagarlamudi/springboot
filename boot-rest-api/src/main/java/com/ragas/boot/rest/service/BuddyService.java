/**
 * 
 */
package com.ragas.boot.rest.service;

import com.ragas.boot.rest.model.Person;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface BuddyService {
	Person findBuddy(Person person);
}
