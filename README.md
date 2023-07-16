# QuestionPro

This project is an implementation of the assignment given by QuestionPro.

## Pre-requisites:
* [Docker](https://docs.docker.com/engine/install/) should be install in your system.

## System Compatibility
This assignment can run on:
* Linux
* MacOs
* Windows

## Usage

```
git clone https://github.com/ravinamotwani11/QuestionPro
cd questionPro/hackernewspi
gradle build
cd ..
docker build -t questionpro . 
docker run -p 8080:8080 questionpro
```  
* NOTE: Wait until docker image is up and running
 
# CRUD
open postman=> select GET method => type the below URLs => hit send button => You will get success response 

To get top 10 stories ranked by the score in the last 15 minutes, hit the following url.  
method: GET  
URL: ``` 
http://localhost:8080/top-stories
```  
  
To fetch all the stories that were served previously from the above /top-stories endpoint, hit the following URL.  
method: GET  
URL: ```
http://localhost:8080/past-stories
```  
  
To get 10 comments (max) on a given story sorted by a total number of child comments, hit the following URL.  
method: GET  
URL: ```
http://localhost:8080/comments/{storyId}
```
Example: http://localhost:8080/comments/36681814


