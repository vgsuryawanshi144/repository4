Feature: Verify Website Navigations and Functionalities

  Scenario: Verify navigation to Property Management page
    Given I navigate to the website
    When I navigate to the Property Management page
    Then the page title should be "Property Management | Entrata"

  Scenario: Verify navigation to Marketing & Leasing page
    Given I navigate to the website
    When I navigate to the Marketing & Leasing page
    Then the page title should be "Entrata Marketing & Leasing Products for your property management needs"

  Scenario: Verify navigation to Accounting page
    Given I navigate to the website
    When I navigate to the Accounting page
    Then the page title should be "Accounting Solutions for Real Estate Property Management"

  Scenario: Verify navigation to Resources page
    Given I navigate to the website
    When I navigate to the Resources page
    Then the page title should be "Helpful Resources for the Multifamily Industry"

  Scenario: Verify navigation to Watch Demo page
    Given I navigate to the website
    When I click on the "Watch Demo" button
    Then the demo video should be displayed

  Scenario: Verify navigation to Schedule Demo page
    Given I navigate to the website
    When I click on the "Schedule Demo" button
    Then I should see the Schedule Demo form

  Scenario: Verify Home page title
    Given I navigate to the homepage
    Then the page title should be "Property Management Software | Entrata"

  Scenario: Verify Entrata logo is displayed
    Given I am on the homepage
    Then the Entrata logo should be displayed

  Scenario: Verify navigation to Solutions page
    Given I am on the homepage
    When I click on the "Solutions" link
    Then the page title should be "Solutions | Entrata"

  Scenario: Verify navigation to Login page
    Given I am on the homepage
    When I click on the "Sign In" link
    Then the page title should be "Login | Entrata"

  Scenario: Verify Contact Us form submission
    Given I navigate to the Contact Us page
    When I fill in the Contact Us form with valid details
    And I submit the form
    Then I should see a success message

  Scenario: Verify Schedule Demo form submission
    Given I navigate to the Schedule Demo page
    When I fill in the Schedule Demo form with valid details
    And I submit the form
    Then I should see a success message

  Scenario: Verify footer links
    Given I am on the homepage
    When I click on each footer link
    Then the correct page should load for each footer link

  Scenario: Verify navigation of submenus under Solutions
    Given I am on the homepage
    When I hover over the "Solutions" menu
    Then I should see the submenus
    And I should be able to navigate to each submenu page
