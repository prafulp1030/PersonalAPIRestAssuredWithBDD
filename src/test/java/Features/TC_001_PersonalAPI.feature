Feature: Test End to End all Personal API Flow

  Scenario: Create personal user using HTTP POST Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    And user add request "Content-Type" and "application/json" header
    And user create request body using json Node as "createUser"
    And user add request body to HTTP Request
    When user select HTTP "POST" Request
    Then user get the validatable Response interface object
    And user validate status code as 201
    And user validate status line as "201 Created"
    And user validate response time should below 2000 ms
    And user validate fullname from response body
    And user validate date key from response body
    And user validate gender from response body
    And user validate country key from response body
    And user validate country key-value from response body
    And user validate json schema
    And user capture id from response body
    And user print response log in console

  Scenario: retrieve personal user using HTTP GET Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    When user select HTTP "GET" Request
    Then user get the validatable Response interface object
    And user validate status code as 200
    And user validate status line as "200 OK"
    And user validate response time should below 2000 ms
    And user validate fullname from response body
    And user validate date key from response body
    And user validate gender from response body
    And user validate country key from response body
    And user validate country key-value from response body
    And user validate json schema
    And user print response log in console
    
    
      Scenario: update personal user using HTTP PUT Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    And user add request "Content-Type" and "application/json" header
    And user create request body using json Node as "updateUser"
    And user add request body to HTTP Request
    When user select HTTP "PUT" Request
    Then user get the validatable Response interface object
    And user validate status code as 200
    And user validate status line as "200 OK"
    And user validate response time should below 2000 ms
    And user validate fullname from response body
    And user validate date key from response body
    And user validate gender from response body
    And user validate country key from response body
    And user validate country key-value from response body
    And user validate json schema
    And user capture id from response body
    And user print response log in console
    
      Scenario: retrieve personal user using HTTP GET Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    When user select HTTP "GET" Request
    Then user get the validatable Response interface object
    And user validate status code as 200
    And user validate status line as "200 OK"
    And user validate response time should below 2000 ms
    And user validate fullname from response body
    And user validate date key from response body
    And user validate gender from response body
    And user validate country key from response body
    And user validate country key-value from response body
    And user validate json schema
    And user print response log in console
    
         Scenario: delete personal user using HTTP DELETE Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    When user select HTTP "DELETE" Request
    Then user get the validatable Response interface object
    And user validate status code as 200
    And user validate status line as "200 OK"
    And user validate response time should below 2000 ms
    And user print response log in console
    
        Scenario: Retrieve personal user using HTTP GET Request
    Given user configure Base URI in Rest Assured
    And user get the Request Specification interface object
    When user select HTTP "GET" Request
    Then user get the validatable Response interface object
    And user validate status code as 404
    And user validate status line as "404 Not Found"
    And user validate response time should below 2000 ms
    And user print response log in console
    
    
    
    
    
    
    
    
    
    
