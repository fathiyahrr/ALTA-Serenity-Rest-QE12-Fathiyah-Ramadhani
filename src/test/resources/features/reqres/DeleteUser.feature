Feature: Delete User
  @Tugas
   @PositifTestCase
  Scenario Outline: Delete a user with valid user id
    Given Delete user with valid user id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
   @NegativeTestCase
    Scenario: Delete a user with invalid user id
      Given Delete user with invalid user id <id>
      When Send request delete user
      Then Status code should be 400 Bad Request
      Examples:
        | id |
        | 10 |
        | 20 |
