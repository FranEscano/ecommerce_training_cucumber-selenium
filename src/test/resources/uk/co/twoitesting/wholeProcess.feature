Feature: Buy a product and place the order later

  Background: an account has been already created and user is on the login page
    Given I am on the login page
    When I enter valid username "Francisco@2itesting.com" and password "Escano123!"
    Then I am logged in

  Scenario Outline: add a product to the cart and apply a coupon code
    Given I add a "<product>" to the cart
    When I add the code "<code>" to the cart
    Then A discount of <expectedDiscount>% is applied
    And I am able to log out
    Examples:
      |product  |code       |expectedDiscount |
      |cap      |edgewords  |15               |
      |belt     |xmas50     |50               |

  Scenario Outline: place the order and check a order number is generated
    Given I add a "<product>" to the cart
    And I navigate to the checkout section
    When I complete the form with
      |firstName  |lastName |address        |city       |postCode |phone      |email                  |
      |Fran       |Escano   |19, Royal Mile |Edinburgh  |SE1 1ZZ  |0123456789 |Francisco@2itesting.com|
    And Place an order
    Then I receive a confirmation order number
    And that order number is in my order history
    Examples:
      |product  |
      |cap      |
      |belt     |
