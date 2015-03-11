Feature: Site navigation

  Scenario: Navigate to signup page
    Given I am on "https://www.easyeasyapps.net"
    When I follow "CADASTRO"
    Then I should be on "https://www.easyeasyapps.net/register.html"