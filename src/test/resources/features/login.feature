Feature: Login

  @regression
  Scenario: Login
    When [UI] User login with username
    Then [UI] User should be on main page

  Scenario Outline: Login with parameters
    When [UI] User login with username <username> and <password>
    Then [UI] User should be on main page
    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |
