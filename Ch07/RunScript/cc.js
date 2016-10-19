var creditCardText =
"{ \"number\": \"1234567890123456\", \"expiry\": \"04/20\", \"type\": " +
"\"visa\" }";
var creditCard = JSON.parse(creditCardText);
print(creditCard.number);
print(creditCard.expiry);
print(creditCard.type);

var creditCardText2 = "{ 'type': 'visa' }";
var creditCard2 = JSON.parse(creditCardText2);