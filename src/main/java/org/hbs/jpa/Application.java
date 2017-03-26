package org.hbs.jpa;


import org.hbs.jpa.model.Person;
import org.hbs.jpa.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"org.hbs.jpa"})
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {


    public static void main(String[] args) {


  ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
      /*        Long id = context.getBean(PersonDao.class).addPerson(DataUtil.getPerson());
        context.getBean(PersonDao.class).listPersons();
        context.getBean(PersonDao.class).deletePerson(id);
        System.out.println(id);
        */

        PersonRepository personRepository = context.getBean(PersonRepository.class);
        List<Person> personList = personRepository.findByFirstName("Narendra");
        System.out.println(personList.get(0));

        personList = personRepository.findByContactDetailList_Mobile("165456132132");
        System.out.println(personList.get(0));

        System.out.println(personRepository.giveMeAllPersons().get(0));

        System.out.println("Count is : " + personRepository.count());

        System.out.println(personRepository.findAll(new PageRequest(0,3)));

        System.out.println(personRepository.countByAgeLessThan(18));
    }

}