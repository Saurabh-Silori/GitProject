
Feature: Sign up
  
  #Scenario Outline: Fill In details of Volunteer Sign up
  #
  #Given I launch application 
  #When I write details as FirstName <FirstName> and LastName as <LastName> 
  #Then verify signup is successful
#
 #Examples:
 #|FirstName|LastName|
 #|saurabh|silori|
 @volunteer
Scenario: Fill In details of Volunteer Sign up using DataTable
  
  Given I launch application 
  When I write details as FirstName,LastName,phone,country
  |saurabh|silori|8130852815|India|
  Then verify signup is successful

 