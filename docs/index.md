---
info:
  description: "This is the recipe application API, called as recipebook. The recipebook support the following 
  operations and is backed by mongodb on localhost on 27017"
  version: "1.0.0"
  title: "Arpita's Recipebook"
  contact:
    email: "arpita.deore@outlook.com"
  license:
    name: "Apache 2.0"
    url: "http://www.apache.org/licenses/LICENSE-2.0.html"
host: "localhost:8080"
basePath: "/recipebook"
tags:
- name: "recipes"
  description: "All about the recipes"
schemes:
- "https"
- "http"
paths:
  /recipes:
    post:
      tags:
      - "recipes"
      summary: "Add a new recipe to the book"
      description: ""
      operationId: "addRecipe"
      consumes:
      - "application/json"
      produces:
      - "application/json"
      parameters:
      - in: "body"
        name: "body"
        description: "Recipe object that needs to be added to the book"
        required: true
        schema:
          $ref: "#/definitions/Recipe"
      responses:
        "405":
          description: "Invalid input"
      security:
      - petstore_auth:
        - "write:pets"
        - "read:pets"
    get:
      tags:
      - "recipes"
      summary: "Gets all the recipes from the database recipebook"
      produces:
      - "application/json"
      responses:
        "200":
          description: "successful operation"
          schema:
            type: "array"
            items:
              $ref: "#/definitions/Recipe"
  /recipes/{id}:
    get:
      tags:
      - "recipes"
      summary: "Find a recipe by id"
      description: ""
      operationId: "findARecipe"
      parameters:
      - name: "id"
        in: "path"
        description: "ID of the recipe to return"
        required: true
        type: "string"
        format: "UUID"
      produces:
      - "application/json"
      responses:
        "200":
          description: "Find successful"
          schema:
            type: "object"
            items: 
              $ref: "#/definitions/Recipe"
  
securityDefinitions:
  petstore_auth:
    type: "oauth2"
    authorizationUrl: "http://petstore.swagger.io/oauth/dialog"
    flow: "implicit"
    scopes:
      write:pets: "modify pets in your account"
      read:pets: "read your pets"
  api_key:
    type: "apiKey"
    name: "api_key"
    in: "header"


definitions:
 
  Category:
    type: "object"
    properties:
      type:
        type: "string"
        format: "string"
        enum:
        - "breakfast"
        - "lunch"
        - "dinner"
        example: "Dinner"
      apetite:
        type: "string"
        description: "Level of hunger that this recipe satisfies"
        enum:
        - "low"
        - "med"
        - "hungry"
        format: "string"
        example: "Hungry"
      
  Recipe:
    type: "object"
    required:
    - "name"
    properties:
      id:
        type: "string"
        format: "UUID"
        example: "5f9767b15ef2003ada33b180"
      category:
        $ref: "#/definitions/Category"
      name:
        type: "string"
        example: "Stir fried noodles"
      description:
        type: "string"
        example: "Delicious strie fried smoked noodles with julien cut vegetables"
      preptime:
        type: "string"
        example: "20 mins"
      cookTime: 
        type: "string"
        example: "20 mins"
      ingredients:
        type: "object"
      directions:
        type: "object"

  ApiResponse:
    type: "object"
    properties:
      code:
        type: "integer"
        format: "int32"
      type:
        type: "string"
      message:
        type: "string"
---