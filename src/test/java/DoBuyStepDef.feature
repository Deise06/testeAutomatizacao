Feature: DoBuy

  Scenario: DoBuy

    Given the customer performs a product search
      | product                |
      | Notebook Dell Inspiron |
    And the user click search button
    When the user select the product
      | Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10 |
    And click add to cart

    Then the user view product in cart
      | Product     |
      | R$ 5.139,00 |
    And the user ends the buy
    And user fills data from your address
      | Recipients name | CEP      | Number | type of address | reference point |
      | userTest        | 31710400 | 5365   | Residencial     | EPA supermarke  |
    And user confirm your address
    Then user to complete the payment method
      | card banner | card number   | Cardholder Name | shelf life | security code | CPF or CNPJ    | Parcel                      |
      | Mastercard  | 3258965478521 | user Test       | 22/08      | 669           | 403.531.220-76 | 1x de R$ 5.139,00 sem juros |


#     And user logging out of the system
#

  Scenario: DoBuy2 units

    Given the customer performs a product search
      |product                  |
      |Notebook Dell Inspiron   |
    And the user click search button
     When the user select the product
      |Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10|
    And adds two units
    And click add to cart
   Then the user view product in cart
    | Product       |
    | R$ 10.278,00  |


  Scenario: DoBuy2 units

     Given the customer performs a product search
      | product                |
      | Notebook Dell Inspiron |
    And the user click search button
    When the user select the product
      | Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10 |
    And adds two units
    And click add to cart
    Then the user view product in cart
      | Product      |
      | R$ 10.278,00 |
    But remove units
    Then the user view product in cart
      | Product     |
      | R$ 5.139,00 |





   

    
