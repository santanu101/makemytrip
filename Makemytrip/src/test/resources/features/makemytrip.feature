Feature: Searching Makemytrip 

Scenario Outline: Search for a  flight Scenario
 Given launch browser 'chrome'
 When user navigates to the URL 'https://www.makemytrip.com/'
 Then user enter 'BBI' and 'BOM'
 Then user click on the search
 Then user click on the Evening Flight
 Then user will get all the prices from the table
 Then user will get non-stop flight
 Then user will click on Book
Examples: 
| From | Destination | 
| BBI  | BOM         |




