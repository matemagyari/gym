Feature: Member has induction tomorrow

  Scenario: Member has induction tomorrow

    Given members in system
    | Id | Name        | Telephone Number | Email Address  | Preferred notification mode |  
    | 17 | Kata        | 1234567          | kata@gmail.com | email, sms                  |

    When Information System read is fired and the following events occured
    | Event type     | Member | Location | Time             |
    | INDUCTION_DUE  | 17     | W12 Q34  | 17.06.2013 09:30 |
    
    Then email sent
    | Email Address  | Text Contains |
    | kata@gmail.com |               |
    
    And sms sent 
    | Telephone Number | Text Contains |
    | 1234567          |               |
    
    