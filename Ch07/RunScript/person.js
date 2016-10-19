var person = 
{
   "firstName": "John",
   "lastName": "Smith",
   "isAlive": true,
   "age": 25,
   "address": 
   {
      "streetAddress": "21 2nd Street",
      "city": "New York",
      "state": "NY",
      "postalCode": "10021-3100"
   },
   "phoneNumbers": 
   [
      {
         "type": "home",
         "number": "212 555-1234"
      },
      {
         "type": "office",
         "number": "646 555-4567"
      }
   ],
   "children": [],
   "spouse": null
};
print(person.firstName);
print(person.lastName);
print(person.address.city);
print(person.phoneNumbers[1].number);