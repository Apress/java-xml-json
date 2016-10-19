{
   "$schema": "http://json-schema.org/draft-04/schema#",
   "title": "Product",
   "description": "A product",
   "type": "object",
   "properties": 
   {
      "name": 
      {
         "description": "A product name",
         "type": "string"
      },
      "price":
      {
         "description": "A product price",
         "type": "number",
         "minimum": 1
      }
   },
   "required": ["name", "price"]    
}