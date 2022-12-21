# API Sales

### Sales repository

Sales API project consists a couple of the endpoints to manager customers and address like GET /customers, and GET /address and for a technical evaluation using Java Technology with Spring Boot, RESTFUL, build in Maven archetype and persistence with H2 in-memory database.

## Requirements

1. Having Java 8 or higher installed on your computer or laptop:
   - https://www.java.com/pt-BR/download/manual.jsp

2. Clone the project by running the command in a folder of your choice:
```bash
   git clone https://github.com/jamilsolutions/sales.git
```

3. Enter the directory where the project was cloned and open a command prompt with Git Bash:
   >Note: 1. If you do not have git installed use this link to install:
   > - https://git-scm.com/downloads
   > - Git Tutorial at https://git-scm.com/book/pt-br/v2

4. Download Maria DB from server:
   https://mariadb.com/products/community-server/

5. Unpack MariaDB from bin folder to:
```bash 
   C:\Programas\Database\h2
```

6. Start MariaDB from bin folder:
```bash 
   C:\Programas\Database\h2\bin\h2.bat
```

8. Run the command in the project <PROJECT PATH>/sales with the command:
```bash   
   mvn run
```
>Note: 1. Alternative run
> Run the application with jar command line:
> - Enter in the project <project path>/bin forder at 
> - Run the command:
> ```bash
>   java -jar sales-0.0.1-SNAPSHOT.jar
> ```
> - MAVEN_HOME=C:/Programas/Apache/apache-maven-3.8.6
> - PATH=%MAVEN_HOME%/bin

>Note: 2. If you do not have Maven installed use this link to install:
> - https://maven.apache.org/download.cgi
> - Unpack at C:/Programas/Java/apache-maven-3.8.6-bin.zip
> - Create a Variable of Environment to Maven
> - MAVEN_HOME=C:/Programas/Apache/apache-maven-3.8.6
> - PATH=%MAVEN_HOME%/bin

9. Open Postman and import the Secure collection "API Sales REST.postman_collection.json" file:
```bash
Postman -> File -> Import -> Select folder or Upload the file -> Confirm import.
```

10. Run the collection Sales:
```bash
Run Collection Runner -> Run the "API Sales REST".
```


11. Completed. Great job!


## Environment

### JDK

1. Download JDK 11 from Oracle.com -> Java SE 11 Archive Downloads:
   Windows x64 Compressed Archive:
   https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html

2. Unpack the jdk-11.0.16.1_windows-x64_bin at Java folder:
   C:/Programas/jdk-11.0.16.1

3. Create a Variable of Environment to JDK:
   JAVA_HOME=C:/Programas/jdk-11.0.16.1
   PATH=%JAVA_HOME%/bin

### Git

1. Install the 64-bit Git for Windows Setup from:
   https://git-scm.com/download/win

2. CLone the project with:
   git clone https://github.com/jamilsolutions/sales.git

### IntelliJ IDEA

1. Open the IntelliJ IDEA from:
   C:/Programas/ideaIU-2022.3.win/bin/IDEA64.exe

2. Open the project with IntelliJ IDEA from:
   <project folder>/sales
  
   