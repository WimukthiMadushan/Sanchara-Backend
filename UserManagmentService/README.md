# User Management System and Authentication Service

## Description
This is a user management system and authentication service that allows users to sign up, sign in, sign out, and update their profile. The service is built using Springboot and PostgresSql. The service is secured using JWT tokens and bcrypt for password hashing.

## Features
- Host sign up
- Host sign in
- Host sign out
- Guest Sign Up
- Guest Sign In
- Guest Sign Out
- Update Profile
- Get Profile

## API Endpoints
- POST /api/auth/host/signup
````json
{
    "ID": "",
    "Status": "Host",
    "OrganizationName": "",
    "Owner":"",
    "Email": "",
    "Password": "",
    "Mobile": "",
    "Country":"",
    "City": ""
}
````

- POST /api/auth/host/signin
````json
{
    "Email": "",
    "Password": ""
}
````
- POST /api/auth/host/update
````json
{
    "ID": "",
    "OrganizationName": "",
    "Owner":"",
    "Email": "",
    "Password": "",
    "Mobile": "",
    "Country":"",
    "City": ""
}
````

- POST /api/auth/guest/signup
````json
{
    "ID": "",
    "Status": "Guest",
    "FirstName": "",
    "LastName":"",
    "Email": "",
    "Password": "",
    "Mobile": ""
}
````
- POST /api/auth/guest/signin
````json
{
    "Email": "",
    "Password": ""
}
````
- POST /api/auth/guest/update
````json
{
    "ID": "",
    "FirstName": "",
    "LastName":"",
    "Email": "",
    "Password": "",
    "Mobile": ""
}
````
- GET /api/auth/guest/profile/{id}
- GET /api/auth/host/profile/{id}

### Connection with Notification service. 
#### When a user register in the system a Email Notification should send to the user email address with the following message. use kafka for async communication
````json
{
    "Subject": "Welcome to the Sanchaara Events Management System",
    "Body": "You have successfully registered in the Sanchaara Events Management System."
}
````


