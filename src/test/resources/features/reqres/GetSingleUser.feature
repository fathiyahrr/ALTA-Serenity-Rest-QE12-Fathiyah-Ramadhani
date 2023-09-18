Feature: Get Single User
  @Tugas
    @PositifTestCase
  Scenario Outline: Get single user with valid parameter
    Given Get single user with valid parameter id <id>
    When Send request get single users
    Then Status code should be 200 OK
    And Response body data should be id <id>
    And Validate get single user JSON schema "GetSingleUserSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  @NegativeTestCase
  Scenario Outline:Get single user not found
    Given Get single user not found with invalid parameter id <id>
    When Send request get single users with invalid parameter
    Then Status code should be 404 Not Found
    And Validate get single user with invalid parameter JSON schema "GetSingleUserNotFoundSchema.json"
    Examples:
      | id |
      | 23 |
