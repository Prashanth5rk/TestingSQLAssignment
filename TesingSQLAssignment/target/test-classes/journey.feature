Feature: Automate the Flipkart sale

  Scenario: Buy a Hp Laptop in Flipkart
    Given Launch Flipkart application.
    And Search for "Hp Laptop" book.
    And Click on search button.
    When Find 3rd result of Hp Laptop.
    Then Display Hp Laptop Details.

