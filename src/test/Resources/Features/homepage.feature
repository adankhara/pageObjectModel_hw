Feature: All links on homepage is working

  Scenario: When user click on Shopping cart button user should navigate to Shopping cart page
    Given User is on https://demo.nopcommerce.com/
    When User click on Shopping cart button
    Then User should be navigate to Shopping cart page

  Scenario: When user click on Computers button user should navigate to Computers category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Computers button
    Then User should be navigate to Computers page

  Scenario: When user click on Electronics button user should navigate to Electronics category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Electronics button
    Then User should be navigate to Electronics page

  Scenario: When user click on Apparel button user should navigate to Apparel category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Apparel button
    Then User should be navigate to Apparel page

  Scenario: When user click on Digital downloads button user should navigate to Digital downloads category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Digital downloads button
    Then User should be navigate to Digital downloads page

  Scenario: When user click on Books button user should navigate to Books category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Books button
    Then User should be navigate to Books page

  Scenario: When user click on Jewelry button user should navigate to Jewelry category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Jewelry button
    Then User should be navigate to Jewelry page

  Scenario: When user click on Gift Cards button user should navigate to Gift Cards category page
    Given User is on https://demo.nopcommerce.com/
    When User click on Gift Cards button
    Then User should be navigate to Gift Cards page