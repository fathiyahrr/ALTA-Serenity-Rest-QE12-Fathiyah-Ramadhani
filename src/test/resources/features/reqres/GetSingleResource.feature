Feature: ALTA QE BATCH 12
  @Tugas
    @PositifTestCase
  Scenario Outline: Get single resource with valid parameter
    Given Get single resource with valid parameter id <id>
    When Send request get single resource
    Then Status code should be 200 OK
    And Response body data should be id <id>
    And Validate get single resource JSON schema "GetSingleResourceSchema.json"
    Examples:
      | id |
      | 1 |


  @Tugas
    @NegativeTestCase
  Scenario Outline:Get single resource not found
    Given Get single resource not found with invalid parameter id <id>
    When Send request get single resource with invalid parameter
    Then Status code should be 404 Not Found
    And Validate get single resource not found with invalid parameter JSON schema "GetSingleResourceNotFoundSchema.json"
    Examples:
      | id |
      | 23 |

