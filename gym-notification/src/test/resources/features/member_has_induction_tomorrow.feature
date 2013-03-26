Feature: Member has induction tomorrow

  Scenario: Member has induction tomorrow

    Given members in system
    | Id | Name        | Telephone Number | Email Address  | Preferred notification mode |  
    | 17 | Kata        | 1234567          | kata@gmail.com | email, sms                  |
    
    And notification message templates are
    | Event Notification Type     | Text                                                              |
    | INDUCTION_DUE  			  | Dear {firstName}, your induction is due {datetime} at {location}. |
    
	And the following event notifications are needed
    | Event Notification Type     | Member | Location | Time             |
    | INDUCTION_DUE  			  | 17     | W12 Q34  | 17.06.2013 09:30 |
	
    When monitoring is scheduled
    
    Then email sent
    | Email Address  | Subject      | Text Contains                                                 |
    | kata@gmail.com | some subject | Dear Kata, your induction is due 17.06.2013 09:30 at W12 Q34. |
    
    And sms sent 
    | Telephone Number | Text Contains                                              |
    | 1234567          | Dear Kata, your induction is due 17.06.2013 09:30 at W12 Q34. |
    
    