Basis project hateoas-tst gemaakt met hateoas via https://start.spring.io/

    Doing:
    
    - Vergelijk mvn release:perform lokaal vs via jenkins. 
    Nexus: installeren van de jenkins maven release pluging (verwacht een een release icoontje, niet gezien) 
    hoe/waar zet je username/password? Ok, via de jenkins maven job.
    Het maken van de release in de workspace lukt, alleen het commiten naar nexus niet (lukt wel lokaal via mvn release:perform).
    Komt ook vaak een fout ivm git HEAD ref oid. 
    
    
    - jenkins job should use the repo. Upload artifact.
    
       
    Todo:
    - start citrus gherkin in de jenkins build? (start test stop van de applicatie)
            Logsnippet uit jenkins build job GS_REST        
            [DEBUG] Waiting for spring application to start...
            Error: Could not find or load main class nl.pdptst.rest_hateoas.RestHateoasApplication
            Vermoedelijk classpath oid
        - Sonar Citrus/Gherkin plugin
    - lokaal installeren van de todo-?.jar met volgende plugin https://www.baeldung.com/install-local-jar-with-maven/.
    zo kun je ook jars in een dependency toevoegen.
    - Lezen https://github.com/jenkins-x/jx/issues/788 
    - in gs_itest --> todo zonder citrus-sample-todo dependency krijg je een error (Could not figure out if the application has started:)
    - logging bij ontvangst van bericht in de gs_rest_hateoas application
    - todo's in code van gs_itest uitzoeken
    - package name van gs_itest veranderen
    - iets van api interactie met de gs_rest_hateoas (2de url oid)
    - Docker (een spring-boot service in docker)
    - Controleer percentage oid
    - Mutatietesten percentage (controle op rapport)
    - REST hateoas API
    - Embedded postgresq1
    - JFrog Artifactory?
    - git-ignore
    - spring-boot smoketest daar is iets standaards voor
        
    Done:
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
	
	
	
	
