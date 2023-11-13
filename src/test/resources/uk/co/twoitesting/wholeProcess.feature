Feature: Buy a product and place the order later

  Background: an account has been already created and user is on the login page
    Given I am on the login page
    When I enter valid username "Francisco@2itesting.com" and password "Escano123!"
    Then I am logged in

  Scenario: add a product to the cart and apply a coupon code
    Given I add a product to the cart
    When I add a coupon code
    Then A discount is applied
    And I am able to log out

  Scenario: place the order and check a order number is generated
    Given I add a product to the cart
    And I navigate to the checkout section
    When I complete the form with "Fran", "Escano", "19, Royal Mile", "Edinburgh", "SE1 1ZZ", "0123456789", "Francisco@2itesting.com"
    And Place an order
    Then I can see my order
