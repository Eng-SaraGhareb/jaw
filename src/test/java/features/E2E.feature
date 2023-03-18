Feature: Validate the subscription packages
  I want to check that the user can validate the subscription packages according to the country.

  Background: The user open home page
    Given the user in the home page

  Scenario: User Validation for ksa
    When the user click on country button and choose “السعودية” then click on it
    Then The subscription packages displayed successfully for ksa

  Scenario: User Validation for kuwait
    When the user click on country button and choose “الكويت” then click on it
    Then The subscription packages displayed successfully for kuwait

  Scenario: User Validation for bahrain
    When  the user click on country button and choose “البحرين” then click on it
    Then The subscription packages displayed successfully for bahrain









