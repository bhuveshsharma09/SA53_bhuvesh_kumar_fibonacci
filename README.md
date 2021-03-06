# SA53_bhuvesh_kumar_fibonacci http://168.138.176.208/

1. [ Dropwizard Web service. ](#drop)
2. [ React UI. ](#react)
3. [ Python Flask Rest web service. ](#python)
4. [ Python Flask Docker Instrcutions ](#docker)
5. [ Access Deployed REST web service ](#oci)



<a name="drop"></a>
# REST web service using Dropwizard along with UI interface in React
![image](https://user-images.githubusercontent.com/62707309/143731209-32ffcbce-e848-400c-87c9-85a4bf736bb6.png)
1. [ Functionality ](#func)
2. [ Example ](#ex)
3. [ Dependencies ](#dep_drop)
4. [ Port configuration ](#config_drop)
5. [ Testing ](#testing_drop)

<a name="func"></a>
### Functionality
The web service takes in a numerical value between 1 to 100, and returns the Fibonacci sequence, as well as a sequence that is sorted using the following conditions:
* Even numbers first, in descending order
* Odd numbers, in descending order

<a name="ex"></a>
### Example: 
If user does a http get to http://myserver:8000/fibonacci with the following json payload:
```json

{
 "elements": 10
} 
```

it will return me the following JSON:
```json
{
 "fibonacci": [0,1,1,2,3,5,8,13,21,34],
 "sorted": [34,8,2,0,21,13,5,3,1,1]
}
```


<a name="dep_drop"></a>
# Dependencies

* Maven dropwizard-core
* Maven Jersey-moxy

```
    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.dropwizard/dropwizard-core -->
        <dependency>
            <groupId>io.dropwizard</groupId>
            <artifactId>dropwizard-core</artifactId>
            <version>2.0.25</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.glassfish.jersey.media/jersey-media-moxy -->
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-moxy</artifactId>
            <version>2.34</version>
        </dependency>
    </dependencies>
</
```

<a name="config_drop"></a>
# Port configuration

The application port is set at 9090 and admin port is at 9091

```
String applicationPort = "9090";
String adminPort = "9091";
```

Please change the port numbers in ~/Program file if needed


# CORS headers has been handled

Configuration
```
cors.setInitParameter("allowedOrigins", "*");
cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

```

<a name="testing_drop"></a>
# Testing

## Using Postman 
![image](https://user-images.githubusercontent.com/62707309/143731067-efed4905-de65-421f-9073-3a44ff7b041b.png)


API side message:
![image](https://user-images.githubusercontent.com/62707309/143731165-a0c76b41-932a-4676-aa19-d5e407ae484d.png)



## Using React Web app
![image](https://user-images.githubusercontent.com/62707309/143731297-dcf29417-fcd4-4177-a90d-e3cc7e4a8f5a.png)

API side message:
![image](https://user-images.githubusercontent.com/62707309/143731153-c703752f-9587-4024-a360-bac1403308b9.png)






<a name="python"></a>
# Python and Flask REST web service  http://168.138.176.208/ 
![image](https://user-images.githubusercontent.com/62707309/143732407-59487492-d04c-4a55-9c9a-aeadf2cd00cf.png)
1. [ Functionality ](#func_p)
2. [ Example ](#ex_p)
3. [ Dependencies ](#dep_p)
4. [ Port configuration ](#config_p)
5. [ Testing ](#testing_p)
6. [ Docker build ](#docker_p)




<a name="func_p"></a>
### Functionality
The web service takes in a numerical value between 1 to 100, and returns the Fibonacci sequence, as well as a sequence that is sorted using the following conditions:
* Even numbers first, in descending order
* Odd numbers, in descending order

<a name="ex_p"></a>
### Example: 
If user does a http get to http://myserver:8000/fibonacci with the following json payload:
```json

{
 "elements": 10
} 
```

it will return me the following JSON:
```json
{
 "fibonacci": [0,1,1,2,3,5,8,13,21,34],
 "sorted": [34,8,2,0,21,13,5,3,1,1]
}
```

<a name="oci"></a>
# Deployed on OCI (Oracle Cloud Infrastructure)
The web service has been deployed on OCI and can we accessed using 

Link of the global API (hosted on OCI): http://168.138.176.208/ ;

Link to call API in your program: http://168.138.176.208/fibonacci
<a name="docker_p"></a>
<a name="docker"></a>
# Build and Run Docker image using Dockerfile
the docker file helps to build an image of program which can later be run in a container.
To do so, please follow the commands
```
$ git clone https://github.com/bhuveshsharma09/my-flask-app.git

### build docker image

$ docker image build -t my-flask-app .

### check if the image has been build successfully

$ docker image ls

### run the image in a container

$ docker run -d -p 80:80 my-flask-app

```

<a name="dep_p"></a>
# How to use 
### clone the repo
```
$ git clone https://github.com/bhuveshsharma09/my-flask-app.git
```
### change the working directory to my-flask-app
```
$ cd my-flask-app
```
### install the requirements
```
$ python3 -m pip install -r requirements.txt
```
### run
```
python3 app.py
```
<a name="config_p"></a>
# Configuration
Current configuration for host is '0.0.0.0' and port is 80

# Functional prototype deployed at OCI
Link: http://168.138.176.208/

<a name="testing_p"></a>
# Testing
* **Step 1:** Go to  http://168.138.176.208/ and enter a number in input field and hit 'compute' button
![image](https://user-images.githubusercontent.com/62707309/143731935-b338e16d-d7cb-416c-8ddb-c1740eeef6c0.png)


* **Step 2:** The web app will send request to http://168.138.176.208/fibonacci/ 
![image](https://user-images.githubusercontent.com/62707309/143731996-d7643ab6-0fca-4389-a480-a54cf71d77a8.png)

![image](https://user-images.githubusercontent.com/62707309/143732009-153fa761-82d9-481e-b8c6-7fd7dbb11ca9.png)

* **Step 3:** The web app will show the reponse in the page


# Note
The API request url is http://168.138.176.208/fibonacci/ . Only for the demo purpose I developed the page where user can easily enter value and computer fib sequence (using API).
Although the API and webpage resides in the same program, the function calls API link to fullfil the requirment.


<br />
<br />

<a name="react"></a>
# React web app to call API to computer fibonacci sequence
![image](https://user-images.githubusercontent.com/62707309/143734946-118373db-a29a-40d5-b5b9-d1da23c45a00.png)

1. [ Dependencies ](#dep_r)
2. [ Testing ](#testing_r)




Simple react web app which takes number value from user and calls an API to compute the fibonacci sequence.

**Link of the dropwizard API:** https://github.com/bhuveshsharma09/my-dropwiz-app

**Link of the global API (hosted on OCI):** http://168.138.176.208/ ; http://168.138.176.208/fibonacci

![image](https://user-images.githubusercontent.com/62707309/143731307-de65232a-4b15-4c48-9148-ff0b33e3af02.png)



<a name="dep_r"></a>
# Dependencies
* Formik
```
 npm install formik --save
```
<a name="testing_r"></a>
# Testing
* Loading the webpage in web browser

![image](https://user-images.githubusercontent.com/62707309/143731423-e7538dda-8d4f-4fee-b937-c66442ddd544.png)

* submitting value and receieving the response

![image](https://user-images.githubusercontent.com/62707309/143731506-e3069053-7479-418a-b0c2-55c32eb3e4fc.png)


