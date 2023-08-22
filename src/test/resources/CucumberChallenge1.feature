Feature:To validate the login functionality of the amazon application
Scenario:To validate the valid username and invalid password
Given To launch the chrome browser and maximize the window
When To launch url of the amazon application
And To pass the valid username in the email field
And To click the continue button
And To pass the invalid password in the password field
And To click the signin button
And To check whether navigate to home page or not
Then To close the browser

