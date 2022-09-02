package com.bosch.contact.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.contact.model.Emails;
import com.bosch.contact.model.Person;
import com.bosch.contact.model.Phones;
import com.bosch.contact.repository.PersonRepository;

import io.swagger.models.Contact;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(path = "/user", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Person PostUser(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(path = "/user/{user_email}/contact", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Person PostUserContact(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(path = "/user",method = RequestMethod.GET, produces = "application/json")
	public List<Person> Get() {
		return personRepository.findAll();
	}

	@RequestMapping(path = "/user/{user_email}/contact", method = RequestMethod.GET, produces = "application/json")
	public Person GetUserContact(@PathVariable(value = "user_email") String user_email,
			@RequestParam(value = "phone", required=false) String phone, @RequestParam(value = "email", required=false) String email) {

		Person personFinded = personRepository.getJoinInformation(user_email);

		if (phone != null && email == null) {
			for (Emails emails : personFinded.getEmail()) {
				if (emails.getValue().equals(email)) {
					return personFinded;
				}
			}
		} else if (phone == null && email != null) {
			for (Phones phones : personFinded.getPhoneNumber()) {
				if (phones.getValue().equals(phone)) {
					return personFinded;
				}
			}
		} else {
			boolean findPhone = false;
			boolean findEmail = false;
			for (Phones phones : personFinded.getPhoneNumber()) {
				if (phones.getValue().equals(phone)) {
					findPhone = true;
				}
			}
			for (Emails emails : personFinded.getEmail()) {
				if (emails.getValue().equals(email)) {
					findEmail = true;
				}
			}
			if (findEmail || findPhone) {
				return personFinded;
			}
		}
		return null;
	}

	@RequestMapping(path = "/user/{user_email}", method = RequestMethod.GET, produces = "application/json")
	public Person GetByEmail(@PathVariable(value = "user_email") String email) {
		return personRepository.getJoinInformation(email);
	}
	
	@RequestMapping(path = "/contact/address", method = RequestMethod.GET, produces = "application/json")
	public List<Person> GetAllByCityOrState(
			@RequestParam(value = "city", required=false) String city, 
			@RequestParam(value = "state", required=false) String state) {
		
		return personRepository.findAllByCityOrState(city, state);
	}
	
	@RequestMapping(path = "/user/{user_email}/contact/{contact_id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Person PutUser(@Valid @RequestBody Person person,@PathVariable(value = "user_email") String user_email, @PathVariable(value = "contact_id") String contact_id) {
		Person personFinded = personRepository.getJoinInformation(user_email);
		
		for (Phones phones : personFinded.getPhoneNumber()) {
			if (String.valueOf(phones.getPhones_id()) == contact_id) {
				return personRepository.save(person);
			}
		}
		return null;
	}

	@RequestMapping(path = "/user/{user_email}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Person> DeleteByEmail(@PathVariable(value = "user_email") String email) {
		try {
			personRepository.deleteAllByEmail(email);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
