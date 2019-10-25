Basis project hateoas-tst gemaakt met hateoas via https://start.spring.io/

    Doing:
    - togglz https://www.togglz.org/documentation/spring-boot-starter.html
       
    Todo:
    - itest profile maken dat werkt met de jenkins job (contole of dit al werkt i.e. profile ci, dit werkt lokaal mvn -Pci clean install -Dembedded).
	- Jenkins sonar job opnieuw inrichten i.v.m. nieuwe multi-module structuur Sonar-check (jenkins configuratiefile overhevelen).- Embedded postgresq1 -> show_sql 
	- Er is een cursus op mylearning over ci/cd even snel doorheen scannen
	- Swagger 
	- Mutatietesten percentage (controle op rapport)
	- Maaak een build-profile. Misschien moet er ook een release profile gemaakt worden.
    - jenkins totaal job itest/sonar/release     
    - Todo's in code van gs_itest uitzoeken
    - Opruimen project. Rename van project gs_rest in; pdp-cicd oid. Verwijderen niet gebruikte repo's.
    - spring-boot smoketest daar is iets standaards voor
    - REST hateoas API
    - Lezen https://github.com/jenkins-x/jx/issues/788 
    - Docker (een spring-boot service in docker)
    - git-ignore
        
    Done:
    - start citrus gherkin in de jenkins build? (start test stop van de applicatie)
                    Logsnippet uit jenkins build job GS_REST        
                    [DEBUG] Waiting for spring application to start...
                    Error: Could not find or load main class nl.pdptst.rest_hateoas.RestHateoasApplication
                    Vermoedelijk classpath oid. Ok. Opgelost door officieel multi-module project te maken.
                - Sonar Citrus/Gherkin plugin. Ok
    - clonen van modules in jenksin gaat niet goed, lege directory. Google jenkins submodules workspace oid
       https://stackoverflow.com/questions/19572565/putting-a-multi-module-maven-project-into-jenkins. Ok
       Opgelost door de structuur van het project aan te passen. Officieel multi-module project.
                  
    - De onderstaande readme beschrijft hoe de cucumber test zou moeten werken. Deze werkt echter ook niet, na het opstarten van de applicatie wordt er niet verder gegaan met de integrtietest.
    /cygdrive/c/Projects/pdp/citrus-samples/samples-cucumber/sample-cucumber/java-dsl/README.md
    Het lukt wel om de sample-cucumber/java-dsl integratietest te runnen op de andere computer 
    (geprobeerd met een ander mvn versie 3.6.0 maar maakte niet uit)
    
    - Opstarten van een embedded integratietest lokaal, heeft ooit gewerkt met de rest_hateoas applicatie. 
        Waarschijnlijk via commando mvn clean verify -Dembedded. Nu niet meer (kan de main applicatie niet vinden) wellicht moet
        de itest gestart worden vanuit een andere directory. 
        Met de toevoeging <classesDirectory>../gs_rest_hateoas/target/classes</classesDirectory> lukt het wel om via mvn verify -Dembedded de IT test te draaien (zowel vanuit gs_itest als gs_rest).
     
    - Vergelijk mvn release:perform lokaal vs via jenkins. 
          Nexus: installeren van de jenkins maven release pluging (verwacht een een release icoontje, niet gezien) 
          hoe/waar zet je username/password? Ok, via de jenkins maven job.
          Het maken van de release in de workspace lukt, alleen het commiten naar nexus niet (lukt wel lokaal via mvn release:perform).
          Komt ook vaak een fout ivm git HEAD ref oid. 
        Gelukt door: 
        -in pom corrigeren naar de juiste SNAPSHOT version
        - en weghalen met tag v0.0.?. 
        - In de configuratie via add behaviour de master branch specificeren 
        - en een clean van de workspace
      
    - Release via mvn release:prepare werkt username, password in pom.xml
    - Nexus: mvn deploy a snapshot to nexus  (cmd -> nexus.exe /run)
    - In dezelfde build de embedded app opstarten en afsluiten zodat het makkelijk in jenkins te doen is. (werkt al)
    - Create citrus/gherkin gs_test (gebruik voorbeeld 
                        https://github.com/citrusframework/citrus-samples/tree/master/samples-cucumber/sample-cucumber-spring
          
    - mvn verify -Dit.test=<testname> (werkt niet) mvn verify wel (als appliatie apart is opgestart)
    	    mvn -Dit.test=todo.TodoFeatureIT verify
    - Multi module project - gs_itest
    - gs_rest in git repo gs_rest
    - Sonar feature file analysis through mvn sonar:sonar analysis on sample-cucumber-spring/java-dsl project. OK. 
    - REST simple hello world message. Ok localhost:8090/greeting/
    - Jenkins-pipeline private repo. Ok
    - pipeline via scm (in git een pipeline file plaatsen) 
    - Nexus: mvn deploy a snapshot to nexus  (cmd -> nexus.exe /run)
    - In dezelfde build de embedded app opstarten en afsluiten zodat het makkelijk in jenkins te doen is. (werkt al)
    - Create citrus/gherkin gs_test (gebruik voorbeeld 
                        https://github.com/citrusframework/citrus-samples/tree/master/samples-cucumber/sample-cucumber-spring
          
    - mvn verify -Dit.test=<testname> (werkt niet) mvn verify wel (als appliatie apart is opgestart)
    	    mvn -Dit.test=todo.TodoFeatureIT verify
    - Multi module project - gs_itest
    - gs_rest in git repo gs_rest
    - Sonar feature file analysis through mvn sonar:sonar analysis on sample-cucumber-spring/java-dsl project. OK. 
    - REST simple hello world message. Ok localhost:8090/greeting/
    - Jenkins-pipeline private repo. Ok
    - pipeline via scm (in git een pipeline file plaatsen) 
    - Create a SONAR quality gate. Fail on 1 code smell. Ok.
    - Git Ok
	- Jenkins 2.0 Ok 
	- Private repo Ok
	- Jenkins authentication op GIT Ok
	- SONAR Ok
	
	Backlog
	- SSH puttygen? Jenkins op windows?
	- Confluence (7 dollar/m ook voor jira)
    - adoc
    - Doc Tool chain
    - JIRA -> branch vanuit issue 
	
	Sonar token:
	- name: jenkins-pipeline
	- token: 7873b72b4b9310657ef7c55bb78381201e16d5f9
	- Mark build as failed if sonar checks are not met. https://www.youtube.com/watch?v=y-Oz9lBYsH8