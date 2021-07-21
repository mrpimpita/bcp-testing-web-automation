Feature: Register Travel

  @Regression
  Scenario Outline: client makes a trip 2 person to Puno - Cusco
    Given Carla is on the Peru Rail Page
    When select "<Distination>" "<Route>" "<Train>" "<Date Trip>" for trip
    Then the One Way should be selected
    And select search to train ticket
    And select "<Number of Cabins>" in "SUITE CABINS"
      Examples:
      | Distination |            Route                 |            Train         |       Date Trip     | Number of Cabins |
      |    Cusco    |         Puno > Cusco             |  Belmond Andean Explorer |   17-November-2021  |         2        |


  @Regression
  Scenario Outline: client makes a trip 2 person to Arequipa - Puno  - Cusco without train
    Given Carla is on the Peru Rail Page
    When select "<Distination>" "<Route>" "<Date Trip>" for trip
    Then the One Way should be selected
    And select search to train ticket
    And select "<Number of Cabins>" in "SUITE CABINS"
    Examples:
      | Distination |            Route                 |       Date Trip     |   Number of Cabins  |
      |    Cusco    |       Arequipa > Puno > Cusco    |   11-September-2021 |          4          |

  @Regression
  Scenario Outline: client makes a successful trip 2 person to Cusco - Machu Picchu
    Given Carla is on the Peru Rail Page
    When select "<Distination>" "<Route>" "<Date Trip>" "<Date Return>" for round trip
    Then the Round trip should be selected
    And select search to train ticket
    And Select schedules "<Train Onbound>" "<Train Inbound>"
    And fill first passenger "<Name>" "<SurName>" "<Date Of Birth>" "<Nationality>" "<Type Of Document>" "<Number Document>" "<Sex>" "<Telephone>" "<Email>" "<Email Confirmation>"
    And fill second passenger "<Name 2>" "<SurName 2>" "<Date Of Birth 2>" "<Nationality 2>" "<Type Of Document 2>" "<Number Document 2>" "<Sex 2>" "<Telephone 2>" "<Email 2>" "<Email Confirmation 2>"
    When fill method payment "<Number Card>" "<Expirantion Date>" "<Security Code>" "<Name Complete>"
    Then verify in summary purchase Outbound "Monday 18 October 2021" "Vistadome 31" "2 Adults:" "USD 172.00"
    And verify in summary purchase Inbound "Wednesday 20 October 2021" "Vistadome 32" "2 Adults:" "USD 190.00"
    Examples:
        | Distination  |        Route       |    Date Trip  |   Date Return  |     Train Onbound      |    Train Inbound     |    Train Onbound      |    Train Inbound     | Name  |    SurName     |  Date Of Birth | Nationality |     Type Of Document  | Number Document |  Sex  | Telephone |       Email           | Email Confirmation  |   Name 2  |    SurName 2     |  Date Of Birth 2 | Nationality 2 |     Type Of Document 2 | Number Document 2 |  Sex 2 | Telephone 2 |       Email 2         |      Email Confirmation 2         |         Number Card       |        Expirantion Date   |    Security Code   |        Name Complete      |
        | Machu Picchu |Cusco > Machu Picchu|18-October-2021|20-October-2021 |  Vistadome 31 (Poroy)  | Vistadome 32 (Poroy) |  Vistadome 31 (Poroy) | Vistadome 32 (Poroy) |Gerardo| Suarez Sanchez |  12-JUNE-1991  |    Peru     |  Identification Card  |     58200858    |  Male | 966583502 |   macugame@gmail.com  | macugame@gmail.com  |   Mario   | Portilla Sanchez |    18-JUNE-1991  |      Peru     |  Identification Card   |      58200288     |  Male  |  966583502  |   cugamema@gmail.com  |       cugamema@gmail.com          |    4200 1111 2222 3333    |           06-23           |         755        |    Gerardo Suarez Sanchez |