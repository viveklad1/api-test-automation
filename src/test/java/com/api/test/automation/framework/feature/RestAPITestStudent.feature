# new feature
# Tags: optional

Feature: Test Rest API

  Scenario: Verify collection of students
    Given I perform "GET" operation for "/students"
    Then I should see the total "7" records with details below
      | firstName | lastName  | division | nationality |
      | John | Smith | 3 A | UK |
      | Vivian | Lam | 3 A | UK |
      | Raymond | Kwock | 10 A | HK |
      | Roger   | Federer | 5 A | Switzerland |
      | Sachin  | Tendulkar | 10 B | India |
      | Tiger   | Wood      | 12 A | USA   |
      | Kevin   | Martin    | 3 A  | UK    |

  Scenario:Verify students with id query parameter
    Given I perform "GET" operation for "/fetchStudents" with id query param "5"
    Then I should see the student details as below
      | firstName | lastName  | division | nationality |
      | Sachin  | Tendulkar | 10 B | India |

  Scenario:Verify students with class query parameter
    Given I perform "GET" operation for "/fetchStudents" with class query param "3 A"
    Then I should see the total "3" records with details below
      | firstName | lastName  | division | nationality |
      | John | Smith | 3 A | UK |
      | Vivian | Lam | 3 A | UK |
      | Kevin   | Martin    | 3 A  | UK |

  Scenario:Delete student by id using path param
    Given I perform "DELETE" operation using path param for "/students/{id}"
      | id |
      | 6  |
    Then I should see "204" as response status

  Scenario:Create student by providing the details
    Given I perform "POST" operation to create Student using "/students" with body
      | firstName | lastName  | division | nationality |
      | Sai | Ram | 5 A | India |
    Then I should see "200" as response status
