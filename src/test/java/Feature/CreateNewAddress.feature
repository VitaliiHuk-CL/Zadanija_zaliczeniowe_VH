Feature: Test, when user add new address to his profile

  Scenario Outline: User add new address

    Given User open page with "https://mystore-testlab.coderslab.pl"
    When User click Sign in and then log in to system and click Create new address
    And User feel form  New address with "<alias>""<address>""<postcode>""<city>""<phone>" and click SAVE
    Then Success alert appears, comparing input and output data "<alias>" "<address>" "<postcode>" "<city>" "<phone>">
    And User close page

    Examples:
      | alias          | address        | postcode  | city     | phone      |
      | My Address 345 | Kowaluskego 3a | 11-333    | Wroclaw  | 345678987  |
