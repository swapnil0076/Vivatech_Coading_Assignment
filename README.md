Objective
The objective of this application is to provide user registration, authentication, and user profile retrieval functionalities.

Technology Stack
Java Spring Boot
Spring Security
Password Encryption (using PasswordEncoder)
RESTful API endpoints (HTTP methods: POST, PUT, GET)
Cross-Origin Resource Sharing (CORS) handled using @CrossOrigin
Endpoints
1. User Registration
Endpoint: /user/register
Method: POST
Description: Registers a new user with encrypted password storage.
2. OTP Verification
Endpoint: /user/verify-OTP
Method: PUT
Description: Verifies OTP sent to a user's email for authentication purposes.
3. OTP Regeneration
Endpoint: /user/regenOTP
Method: PUT
Description: Regenerates OTP for a user to facilitate re-authentication.
4. User LogIn
Endpoint: /user/logIn
Method: PUT
Description: Validates user credentials for login purposes.
5. Get Logged-In User Details
Endpoint: /user/signIn
Method: GET
Description: Retrieves details of the logged-in user upon successful authentication.
Security and Authentication
Passwords are securely stored using PasswordEncoder to encrypt user passwords before storing them in the database.
Spring Security is implemented for handling authentication and authorization.
Cross-Origin Resource Sharing (@CrossOrigin) is used to handle CORS issues for specific endpoints.
Key Components
UserController: Handles incoming requests, interacts with the UserService.
UserService: Manages user-related functionalities like registration, authentication, OTP handling, and user profile retrieval.
LogInDTO: Data Transfer Object for user login credentials.
UserDTO: Data Transfer Object for user registration details.
