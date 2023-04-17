
Execution Steps:
1. Unzip the Application and import it as a dynamic web project.
2. Add the dependent libraries on path ‘src/main/webapp/WEB-INF/lib’
1.1 jsp-api-2.2.jar
1.2 jstl-1.2.jar
1.3 mysql-connector-java-8.0.13.jar
1.4 servlet-api-2.5.jar
3. Configure the server and add a project to the server.
4. Create a database and run a script to create tables and insert data.
5. Clean the entire project.
6. Run the application on a server, home Page will open.
http://localhost:8080/yourprojectname/homePageController


7. Setup the PostgreSQL and create a database for sonar.
8. Install and configure the SonarQube server and set the path variable for SonarQube: Run the sonar.sh script.
9. Once all the setup is done SonarQube will open on:
http://localhost:9000/
10. Install and configure the sonar Scanner and set the path variables for the sonar scanner.
11. Create New Project on the Sonar Console
  project key: RealEstate
  Token: '-----'
12. Import the project manually CI and run the below command on the project path.

  export SONAR_SCANNER_VERSION=4.7.0.2747
  export SONAR_SCANNER_HOME=$HOME/.sonar/sonar-scanner- $SONAR_SCANNER_VERSION-macosx
  curl --create-dirs -sSLo $HOME/.sonar/sonar-scanner.zip https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-        
  $SONAR_SCANNER_VERSION-macosx.zip
  unzip -o $HOME/.sonar/sonar-scanner.zip -d $HOME/.sonar/
  export PATH=$SONAR_SCANNER_HOME/bin:$PATH
  export SONAR_SCANNER_OPTS="-server"
  sonar-scanner \
  -Dsonar.projectKey=RealEstate \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://localhost:9000
  
13. SonarQube server will display the code quality metrics on the:
http://localhost:9000
