Feature: Register Functionality

  @Happy
    Scenario Outline: Successful redirection to Enter Account Information
    Given I am on the Signup section
    When I enter an email
    And and a password
    And I click the Signup button
    Then I should land on the Enter Account Information page

    Examples:
      | email                        | password         |
      | abdallah98fc@gmail.com       | @1234567         |
      | random@gmail.com             | user12           |

Feature: User Registration

  Scenario Outline: Successful user registration with valid details
    Given I am on the registration page
    When I select the title "<Title>"
    And I enter the name "<Name>"
    And I enter the email "<Email>"
    And I enter the password "<Password>"
    And I select date of birth "<Day>" "<Month>" "<Year>"
    And I check the newsletter subscription
    And I check the special offers subscription
    And I enter address information:
      | First Name | <FirstName> |
      | Last Name  | <LastName>  |
      | Company    | <Company>   |
      | Address    | <Address>   |
      | Address 2  | <Address2>  |
      | Country    | <Country>   |
      | State      | <State>     |
      | City       | <City>      |
      | Zipcode    | <Zipcode>   |
      | Mobile     | <Mobile>    |
    Then I should see a successful registration message

    Examples:
      | Title | Name                | Email                  | Password | Day | Month | Year | FirstName | LastName  | Company | Address           | Address2 | Country | State     | City       | Zipcode | Mobile      |
      | Mr.   | Abdallah Alhajahmed | abdallah98fc@gmail.com | @1234567 | 05  | July  | 1998 | Abdallah  | Alhajahmed| OpenAI  | 123 Street Road   | Apt 4B   | India   | Maharashtra| Mumbai     | 400001  | 9876543210  |
      | Mrs.  | Rajitha             | random@gmail.com       | user12   | 10  | May   | 1995 | Rajitha   | Kumari    | Infosys | 456 Main Avenue  |          | India   | Karnataka | Bangalore  | 560001  | 9876501234  |






