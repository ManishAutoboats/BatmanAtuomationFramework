Feature: Validate goolge place

@AddPlace
Scenario: Validate success new address on server
Given create payload with request
When  user send "addPlaceAPI" requet with "Post" method
Then validate status code is 200
And  "status" value in body is "OK"
And "scope" value in body is "APP"







