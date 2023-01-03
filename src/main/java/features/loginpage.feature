Feature: NonCommerceDemo page login
  Background: common steps
    Given user should launch the browser "chrome"
    When open demo login page with page title "Your store. Login"
    And maximize the browser window
    Then user should enter Username "admin@yourstore.com" and Password "admin"
    Then user should click on login and should login succesfully with page title "Dashboard / nopCommerce administration"

  Scenario: User should successfully login the page with correct credentials

    And user should sign out, with page title "Your store. Login"

  Scenario: Add new Customer

    And user clicks on customers menu
    And user clicks on customers menu Item
    Then click on Add New button
    And customer can view Add New customer Page with title "Add a new customer / nopCommerce administration"
    Then user enters customer info
    And click on save button
    Then user should view confirmation message "The new customer has been added successfully."
    And close browser

    Scenario: search existing customer through emailID

      And user clicks on customers menu
      And user clicks on customers menu Item
      Then user should enter email id
      And click on search button
      Then user should find details on table
      And close browser

      Scenario: search existing customer through First and Last Name

        And user clicks on customers menu
        And user clicks on customers menu Item
        Then user enter First and Last Name
        And click on search button
        Then user should find details on table on second column
        And close browser