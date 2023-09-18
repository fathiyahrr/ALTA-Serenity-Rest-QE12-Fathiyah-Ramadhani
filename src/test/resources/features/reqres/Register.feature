Feature: Post Register User
  @Tugas
    @PositifTestCase
    Scenario Outline:Post Register user with valid json
      Given Register new user with valid json "PostRegisterSuccessful.json"
      When Send request post register user
      Then Status code should be 200 OK
      And Response body id was <id> and was token "<token>"
      And Validate register successful JSON schema "PostRegisterSuccessfulSchema.json"
      Examples:
      | id | token             |
      | 4  | QpwL5tke4Pnpja7X4 |

  @Tugas
    @NegativeTestCase
      Scenario:Register with valid email and empty password
      Given Register with valid email and empty password "PostRegisterUnSuccessful.json"
      When Send request post register user
      Then Status code should be 400 Bad Request
      And Response body with error message "Missing password"
      And Validate register unsuccessful JSON schema "PostRegisterUnSuccessfulSchema.json"



