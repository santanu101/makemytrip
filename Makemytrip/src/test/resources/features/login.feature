Feature: Login to zoho

  Scenario: Navigate to Zoho.com in Firefox and perform login
    Given launch browser 'chrome'
    When user navigates to the URL 'http://zoho.com'
    Then user click on login

  Scenario: Navigate to Zoho.com in Chrome and perform login
    Given launch browser 'chrome'
    When user navigates to the URL 'http://zoho.com'
    Then user click on login
