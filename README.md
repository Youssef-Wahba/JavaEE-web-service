# JavaEE-web-service
simple calculator JAVAEE web service (dynamic web project)
EJB , EAR , Persistence

two included endpoints (if server is locally on port 8080):
1. GET : http://localhost:8080/chapter6-task/api/calculations  ==> get all calcualtions performed
2. POST : http://localhost:8080/chapter6-task/api/calc  ==> to perform only operations on two integers (+,-,*,/), any other operator is not supproted
  body :
    {
      "number1":5,
      "number2":10,
      "operator":"+"
    }
