Feature: Post Login User
  @Tugas
    @PositifTestCase
     Scenario Outline:Post Login user with valid json
      Given Login user with valid json "PostLoginSuccessful.json"
      When Send request post login user
      Then Status code should be 200 OK
      And Response body token was "<token>"
      And Validate login successful JSON schema "PostLoginSuccessfulSchema.json"
      Examples:
        | token             |
        | QpwL5tke4Pnpja7X4 |

  @Tugas
    @NegativeTestCase
    Scenario: Login with valid email and empty password
      Given Login with valid email and empty password "PostLoginUnSuccessful.json"
      When Send request post login user
      Then Status code should be 400 Bad Request
      And Response body with error message "Missing password"
      And Validate login unsuccessful JSON schema "PostLoginUnSuccessfulSchema.json"
