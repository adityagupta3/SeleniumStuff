
Feature: Validating Place API's
@AddPLace
  Scenario Outline: Verify if place is being added by AddPlace
    Given Add place payload "<name>" "<language>" "<address>"
    When When user calls "AddPlaceAPI" with "POST"
    Then Response is success with code 200
    And "status" in response is "OK"
    And "scope" in response is "APP"
    And verify "place_id" is added using "GetPlaceAPI" with "<name>"
  

Examples:
	| name  	| language 	| address 	 |
	| house 	| English 	| blah blah  |
	| aditya 	| hindi 		| adiya home |
@DeletePlace
Scenario: Verify if DeletePlaceAPI is working
	Given Delete Place payload
	When When user calls "DeletePlaceAPI" with "POST"
	Then Response is success with code 200
	And "status" in response is "OK"


	



