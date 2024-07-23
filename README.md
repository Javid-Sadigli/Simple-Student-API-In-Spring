# Simple Student API 
This simple `student-api` is a Spring Boot application that connects to a PostgreSQL database and provides CRUD operations for managing student data. This project demonstrates the use of Spring Boot with PostgreSQL for building a RESTful API.

## Table of Contents
* [Features of the application](#features-of-the-application)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Contributing](#contributing)

## Features of the application 
- Create, Read, Update, and Delete (CRUD) operations for student data
- Integration with PostgreSQL
- RESTful API design
- UNIT Testing

## Getting Started 
Let's see how you can get started with our application. You should go through these steps : 

#### Step 1 : Clone the repository 
Firstly, you need to clone the repository by using the following commands : 
```sh
git clone https://github.com/Javid-Sadigli/Simple-Student-API-In-Spring.git
cd Simple-Student-API-In-Spring
```

#### Step 2 : Build the project
As you have cloned the repository, now you can build the project. For that, you will just need to write the following command : 
```sh
./gradlew build
```
By this command, you will build the project and also run our UNIT tests. You can see the report of test results by going to the following path from the main project directory : `./build/reports/tests/test/index.html` <br> 
You can open this HTML file to see the report. 

#### Step 3 : Run the project
After testing and building the project, you can run the project. In the main project directory you can see `docker-compose.yaml` file. Using this file, you can run our Spring Boot application, PostgreSQL database and pgadmin tool (for viewing the database), by typing the following command : 
```sh
docker-compose up --build -d 
``` 
This command will download the images from the corresponding resources, and will run container for each of the services (application, database, pgadmin tool).


## Usage 
Now let's see how we can use these services that have run. 

#### 1. Usage of Application 
You can use our application to manage students by doing CRUD operations on them. For that, you will need to send a request to following endpoints (the base URL for all endpoints is `http://localhost:8080/api/student`) : 

- `GET /{id}` - To retrieve a student by ID
- `POST /` - To create a new student
- `PUT /{id}` - To update an existing student
- `DELETE /{id}` - To delete a student

For sending requests to these endpoints, you can use an API tool like Postman, cURL or other ones. Here is an example that shows how you can get a student by id using cURL : 

```sh
curl -X GET http://localhost:8080/api/student/1
```
If the database has a student with the id 1, it should give you this student's information.

#### 2. Usage of pgAdmin
You may want to see the database itself also. For that, you can use pgAdmin tool to connect to the database directly. For that, go to `localhost:2000` in your browser. Then, authenticate yourself in pgAdmin. After that, you should click the `Add New Server` button. In the opened window, you should enter the following parameters : 

- Name : name of the server (whatever you want)
- Hostname/address : `postgres`
- Port : `5432`
- Maintenance database : `studentapi`
- Username : `testuser`
- Password : `testpassword`

By this parameters, you can connect to the database of our student API, write queries to see or change datasets manually.

## Contributing 
Contributions are welcome! Follow these steps to contribute:
* Fork the project.
* Create a new branch: `git checkout -b feature/your-feature`.
* Make your changes.
* Submit a pull request.

## Thanks for your attention! 