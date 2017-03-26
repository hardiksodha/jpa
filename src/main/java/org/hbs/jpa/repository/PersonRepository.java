package org.hbs.jpa.repository;

import org.hbs.jpa.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {


    List<Person> findByFirstName(@Param("firstName") String name);

    List<Person> findByFirstNameAndLastName(String firstName, String LastName);

    List<Person> findByFirstNameIgnoreCase(String name);

    List<Person> findByLastNameOrderByFirstNameAsc(String lastname);

    List<Person> findByContactDetailList_Mobile(String mobile);

    Page<Person> queryFirst10ByLastName(String lastName, Pageable pageable);

    Slice<Person> findTop3ByLastName(String lastName, Pageable pageable);

    @Query("Select  p from Person p")
    List<Person> giveMeAllPersons();

    Integer countByAgeLessThan(Integer age);
}
    //http://localhost:8080/person/search/findByFirstName?firstName=Narendra


