# Personal Blogging Platform API

A robust RESTful API built with Spring Boot to power the backend of a personal blogging platform. This API provides all the necessary endpoints to manage blog articles, including creating, retrieving, updating, and deleting posts.

## Technologies Used

  * **Java**
  * **Spring Boot**
  * **Maven**

-----

## API Reference

**Base URL:** `/api/v1/articles`
*(The application will start by default on `http://localhost:8080`)*

### 1\. Get All Articles

Retrieves a list of all published articles.

  * **URL:** `/`
  * **Method:** `GET`
  * **Success Response:**
      * **Code:** `200 OK`
      * **Content:** `List<ArticleResponse>` (JSON)

### 2\. Get a Single Article

Retrieves a specific article by its unique ID.

  * **URL:** `/{id}`
  * **Method:** `GET`
  * **URL Parameters:** `id=[Long]` (Required)
  * **Success Response:**
      * **Code:** `200 OK`
      * **Content:** `ArticleResponse` (JSON)
  * **Error Response:**
      * **Code:** `404 Not Found` (If the article does not exist)

### 3\. Create a New Article

Creates and publishes a new article.

  * **URL:** `/`
  * **Method:** `POST`
  * **Request Body:**
    ```json
    {
      "title": "My New Article",
      "content": "Writing something awesome here.",
      "tags": ["java", "spring-boot"]
    }
    ```
  * **Success Response:**
      * **Code:** `201 CREATED`
      * **Content:** `ArticleResponse` (JSON)

### 4\. Update an Article

Updates an existing article specified by its ID.

  * **URL:** `/{id}`
  * **Method:** `PUT`
  * **URL Parameters:** `id=[Long]` (Required)
  * **Request Body:**
    ```json
    {
      "title": "Updated Article Title",
      "content": "Updated content goes here.",
      "tags": ["java", "spring-boot", "update"]
    }
    ```
  * **Success Response:**
      * **Code:** `200 OK`
      * **Content:** The updated `ArticleResponse` object.
  * **Error Response:**
      * **Code:** `404 Not Found` (If the article does not exist)

### 5\. Delete an Article

Deletes a specific article by its ID.

  * **URL:** `/{id}`
  * **Method:** `DELETE`
  * **URL Parameters:** `id=[Long]` (Required)
  * **Success Response:**
      * **Code:** `204 NO CONTENT`
  * **Error Response:**
      * **Code:** `404 Not Found` (If the article does not exist)

-----

## Data Models

### ArticleRequest / ArticleUpdateRequest

Payload used for creating and updating articles.
| Field | Type | Description |
| :--- | :--- | :--- |
| `title` | String | The title of the article |
| `content` | String | The main body/content of the article |
| `tags` | List\<String\> | An array of tags categorizing the article |

### ArticleResponse

The standard response object representing an article.
| Field | Type | Description |
| :--- | :--- | :--- |
| `id` | Long | Unique identifier for the article |
| `version` | Integer | Version number |
| `title` | String | The title of the article |
| `content` | String | The main body/content of the article |
| `tags` | List\<String\> | An array of associated tags |
| `publishedDate` | ZonedDateTime | The exact timestamp when the article was created |
| `updatedDate` | ZonedDateTime | The exact timestamp of the last update |
