# jpa

Steps to run person JPA application in intellij idea.

1)Create a new project from existing source (File -> New -> Project from existing sources)
2)Path to pom.xml file in next step.
3)After project is successfully loaded into intellij idea, Run application from Application.java (Right click, run as Java application)

4) For GET request  GET Localhost:8080/person
For POST request  POST Localhost:8080/person  (Content-type needs to be set to application/json)
For post request test.json can be used from project.

5)For connecting to H2 database,
Can go to browser and type http://localhost:8080/console
As database url provide jdbc:h2:~/jpa, as user name provide sa, password is <BLANK>

please go through jpa_faq.docx file for set up screenshots, available in same folder.
