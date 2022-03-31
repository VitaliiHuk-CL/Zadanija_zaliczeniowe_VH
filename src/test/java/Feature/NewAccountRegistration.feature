Feature: Add account on page - https://mystore-testlab.coderslab.pl/index.php

  Scenario: Adding account on page https://mystore-testlab.coderslab.pl/index.php

    Given User open browser with "https://mystore-testlab.coderslab.pl/index.php"
    When User click Sign in and then - No account? Create one here and feeling registration form  and click Save
    Then User account are added
    And user close page