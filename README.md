# Fundamental-Project
<p align="center">
<b><u>My fundamental project</b></u>
</p>
<br> </br>
<b><u>Contents:</b></u>
<br> </br>

1.Project Architecture/documentation
<br> </br>

2.Risk Assessment
<br> </br>
3.Jira
<br> </br>

4.ERD- Entity Relationship Diagram
<br></br>

5.Testing
<br></br>


<p><br><b><u>Project Architecture/documentation</b></u></br> <br></br>This section of the readme will outline the goal of the project and the architecture that is planned to be used.<br></br>This project intends to create a CRUD application where a list of campsites and their locations, winter availability and prices can be stored by a user in a database. CRUD stands for: <br></br>

<ul><li><b>C</b>reate</li>

<li><b>R</b>ead</li>

<li><b>U</b>pdate</li>

<li><b>D</b>elete</li></ul>
<br></br></p>

<p>This means creating a database where information can be written, read, updated and deleted. This project aims to create a database where users can store information about campsites they have visited. Users will be able to store: <br></br> <ol>
<li>Campsite Name</li>
<li>Price</li>
<li>Open during winter</li></ol></p>
<br></br>
The main objective will be hitting the MVP (<b><i>Minimum Viable Product</b></i>) standard for the project and keeping things as simple as they need to be to meet that goal. If the MVP requirements are met before the deadline then time will be invested in making everything as tidy, bug free and presentable as possible before further expanding on the design. 



<br> </br>

<p>This project will be managed through Github using Git as version control. Version control systems like Git work by being able push and pull your work to a remote repository - in this case Github will be used to store the project repository. This is useful as it allows multiple users to collaborate on projects, manage seperate branches to prevent conflicts of data and to keep a service live with minimal disruption. </p>
<br> </br>

<p>Jira will be used as a platform to signpost and update development progress. Jira allows for agile software development - meaning that it can be used to help teams collaborite, organize and manage priorization to effiectively complete a project. In <b><i>Section 3</b></i> of the README.md there will be further details of how Jira will be implimented and used to organise the project along with some screenshots to illustrate how it worked for the project.</p>
<br> </br>

<p>The application will run on a GCP VM in combination with a GCP Managed SQL Server as a database. A GCP VM is a (<b><i>Google Cloud Platform Virtual Machine</b></i>). This is essentially an independant virtual computer that will host and run the application. A managed SQL (<b><i>Structured Query Language</b></i>) is a programming language that is used to manage data in a database. A database is essentially a box where information is stored on a computer system. The information stored on a database can be saved and accessed later.</p>
<br> </br>

<p>Programming will be Java and Front-end presentation managed with HTML, CSS and JavaScript. Java is a class based, object oriented programming language designed to have very few dependencies. It is designed to be simple, robust, dynamic and able to be easily used. <b>Springboot, Swagger, Lombok</b>



 HTML (<b><i>Hypertext Markup Language</b></i>) is a markup language used to format documents displayed in a web browser. CSS (<b><i>Cascading Style Sheets</b></i>) is a language used in conjunction with HTML and Javascript to style and format web pages. Javascript is a text based programing language. Unlike the first two languages HTML and CSS which help format the layout of webpages, Javascript is used on both the server and client side to make webpages interactive for the user. </p>
<br> </br>

<p>Testing will be carried out in the form of unit tests, JUnit and Mockito. JUnit is a unit testing framework for Java programming language. Mockito is an open source testing framework for Java designed to enable a test driven enviroment. A test driven enviroment is essentially a development process where the software is thoroughly tested before being fully developed.</p>
<br> </br>



<b><u>Risk Assessment</b></u>
<br></br>
The Risk Assessment aims to identify and examine the impact of events that may negatively effect the project. Considered are risk probability, impact of the risk, tolerability, measures for mitigation and the response if the risk should happen. It is also important to note that risks have different degrees of toleration - meaning some can be expected to happen and have low impact so they are tolerated. Other risks that have a high negative impact on the project would be unacceptable in terms of toleration.
<br></br>
<ul><li>Impact measured by: Low - Medium -High</li>
<li>Tolerability measured risk matrix by: Acceptable - Neutral - Unacceptable</li></ul>
<br></br>

| Risk     | Probability    | Impact | Tolerability |Risk Mitigation | Risk Response |
| -------- | -------------- | --------------- | ------| ------------- | ------|
| GCP Server goes down      | Low       | High | Acceptable |Backup Database | Ensure using backup in place |
| Git init in home directory   | Low    |  High | Unacceptable|  Careful attention to not make this mistake | Revert Commit Changes


<br></br>
<p><br><b><u>Jira - Project Progression</p></br></b></u>
<br></br>
<u><b>Week 1, Week 2 and Week 3 progression</b></u>
<br></br>
<p>Jira is being used to plan and organise the project. Initially the first two epic goals I made were to create a README.md and a working CRUD application. I then created stories to simplify the epics into core components. I did this by creating 5 main stories:</p>
<br></br>

<li>As a user, I want to read about the architechture and what it does, to understand what the project uses</li>
<li>As a user, I want to view the risk assessement, so I can understand the risks</li>
<li>As a user, I want to view how Jira was used, to understand project organisation</li>
<li>As a user, I want to be able to read about testing, to understand how the project was tested</li>
<li>As a user, I want to store campgrounds, So I can CRUD details</li>
<br></br>

<p>Where I did not fully know what would be needed I flexibly added tasks to be completed as they were taught. For example the need to create an ERD (Enity Relationship Diagram), risk assessment and functioning tables in mySQL. As an extention of that process risks where updated into the risk assessement as I became aware of them. The goal was to keep jira as simple as possible while being informative of key objectives I needed to accomplish. During the course of the first three weeks of the project I created Sprints to help keep on track with achiveing sets of important goals. The first sprint was focused on creating the ERD and README.md template with archetechture documentation (Week 1 and Week 2). The second sprint (Week 3) was more substantial and focused on creating the mySQL database with functioning tables along with a Java Maven template for CRUD and updates to the README.md. Commits to github using git were made between these steps.</p>


<br></br>

<u><b>Week 3 Progression</b></u>
<br></br>

<p>The initial scope of the design was a Maven project in Java where I had three tables interacting with each other. A user for logging in with password and email, a camping table which would store the camp name, if it was open winter and the price and a connector table (to connect the two other tables). However after completing the first two sprints and being made aware of the workload required to get the tables functional and tested I decided to cut back the scale of the project. Also with introduction of teaching on Springboot I changed plans to simplify the project and created a new Spring Instead of three tables there would just be a singular camping table. This would make setting up a working CRUD application a lot less workload and more managable.</p>
<br></br>
Below is an example image of my first SQL Database layout with three tables interacting.
<br></br>

![MySqlWorkbench Database with 3 Tables](3tablesSQLex.png)
<br></br>

<u><b>ERD- Entity Relationship Diagram</u></b>
<br></br>
<p>Below is the initial ERD(<b><i>Entity Relationship Diagram</b></i>)of how my SQL database would be designed and constructed.</p>
<br></br>


![Camp Database ERD](CampingERD.png)





<br></br>
<u><b>Week 4 Progression</b></u>
<p>
Spring and HTML/Javascript

Front end user story for jira</p>

<br></br>
<p>Below is my current ERD as of week 3 taking into account the scope changes of my project.</p>

![Simplified Camp ERD](simpleERD.png)


<p>During week 4 with introduction of springboot and being made aware of the complexity of adding in two or three tables I decided to scale back the project scope. This was to allow my first project to be as simple as possible. The main goal was meeting the MVP of making a working CRUD Database (only needing one table) and presenting it at the front end with HTML/CSS/JS. If there is time left after creating the MVP functionality I would spend that on building on the project. </p>
<br></br>

<u><b>Testing<u><b>
Progress as of week 5 is a completed spring database with one functioning table and CRUD tried out with postman and swagger. Now all that remains is to hook up the database to the front end and to test. 