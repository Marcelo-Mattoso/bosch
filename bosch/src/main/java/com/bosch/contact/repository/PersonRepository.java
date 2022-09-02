package com.bosch.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bosch.contact.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query(value = "Select * FROM Person p JOIN Emails e where e.value like :email", nativeQuery=true)
	public Person getJoinInformation(String email);
	
	@Query(value = "Select * FROM Person p JOIN Emails e where e.value like :email", nativeQuery=true)
	public Person getJoinInformationBy(String email);
	
	@Query(value = "delete from Person p JOIN Emails e where e.value like :email", nativeQuery=true)
	public Person deleteAllByEmail(String email);

	@Query(value = "Select * FROM Person p JOIN Addresses a where a.state like :state or a.city like :city", nativeQuery=true)
	public List<Person> findAllByCityOrState(String city, String state);
	
}
