Feature: DoBuy

Scenario: DoBuy
Given that the user is authenticated in the application
  And the customer performs a product search
    |product                  |
    |Notebook Dell Inspiron   |
    And the user click search button
    And the user selects the product
    |Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10|
   And click add to cart

   And the user view product in cart
    | Product       |
    | R$ 5.139,00   |

    And user informs data from your address
   |Recipients name|CEP      |Number|type of address|reference point|
   |userTest       |31710400 |5365  | Residencial   |EPA supermarke |
   And user confirm your address

   Then user to complete the payment method
    |card banner |card number   |Cardholder Name|shelf life|security code|CPF or CNPJ    |
    |Mastercard  |3258965478521 |user Test       |22/08     |669          |403.531.220-76 |

#   And user logging out of the system


  Scenario: DoBuy2 units
    Given that the user is authenticated in the application
    And the customer performs a product search
      |product                  |
      |Notebook Dell Inspiron   |
    And the user click search button
     When the user selects the product
      |Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10|
#   And adds two units
    And click add to cart
#   Then And the user view product in cart
    | Product       |
    | R$ 10.278,00  |


  #  Scenario: DoBuy2 units
#    Given that the user is authenticated in the application
#    And the customer performs a product search
#      |product                  |
#      |Notebook Dell Inspiron   |
#    And the user click search button
#     When the user selects the product
#      |Notebook Dell Inspiron Ultrafino i14-7472-M30S 8ª Ger. Intel Core i7 16GB 1TB+SSD Placa Vídeo 14' Windows 10|
#   and adds two units
#   Then the system shows the value
#    | Product       |
#    | R$ 5.139,00   |





   

    
