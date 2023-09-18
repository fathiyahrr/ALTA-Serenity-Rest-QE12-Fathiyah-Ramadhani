Feature: Patch Update User
  @Tugas
    @PositifTestCase
   Scenario Outline: Patch update user with valid json and user id
    Given Patch Update user with valid json "<jsonFile>" and user id "<id>"
    When Send request patch update user
    Then Status code should be 200 OK
    And Response body name was "<name>" and job was "<job>"
    And Validate patch update user JSON schema "PatchUpdateUserSchema.json"
    Examples:
      | id | jsonFile         | name       | job |
      | 1  | UpdateUser.json  | Fathiyahr1 | QE1 |
      | 2  | UpdateUser2.json | Fathiyahr2 | QE2 |
      | 3  | UpdateUser3.json | Fathiyahr3 | QE3 |

  @Tugas
   @NegativeTestCase
   Scenario: Update user with invalid json and valid id
    Given Patch Update user with invalid json "<jsonFile>" and valid user id <id>
    When Send request patch update invalid user
    Then Status code should be 400 Bad Request
    And Response body with error message "Missing password"
    And Validate patch update invalid user JSON schema "PatchUpdateUserSchema.json"
    Examples:
      | id | jsonFile         | name     | job |
      | 1  | UpdateUser.json  | thiyahr1 | QE1 |
      | 2  | UpdateUser2.json | thiyahr2 | QE2 |
      | 3  | UpdateUser3.json | thiyahr3 | QE3 |




