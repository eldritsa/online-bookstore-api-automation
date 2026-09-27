# Bookstore API automation

API test suite for the [FakeRestAPI](https://fakerestapi.azurewebsites.net) bookstore endpoints.

Base URL: `https://fakerestapi.azurewebsites.net`

## What it covers

Books :

- `GET /api/v1/Books`
- `GET /api/v1/Books/{id}`
- `POST /api/v1/Books`
- `PUT /api/v1/Books/{id}`
- `DELETE /api/v1/Books/{id}`

Authors :

- `GET /api/v1/Authors`
- `GET /api/v1/Authors/{id}`
- `POST /api/v1/Authors`
- `PUT /api/v1/Authors/{id}`
- `DELETE /api/v1/Authors/{id}`

## Stack

    • Java 17

    • Maven

    • Rest assured

    • JUnit 5

    • Jackson
      
    • Maven Surefire

    • Jenkins

## Project Structure

src/main/java/

    • client/  # API Client for Base, Books and Authors
      
    • config/  # Environment configuration

    • model/   # Book and Author model

    • spec/    # Reusable response specifications

    • testdata/ # Test data for Book

src/test/java/tests/

    • authros/ # Authors API tests

    • books/   # Books API tests

 
## Set up

Clone the repository: 

git clone https://github.com/eldritsa/online-bookstore-api-automation.git

Navigate to the project:

cd online-bookstore-api-automation

## Running the Tests

Run the complete API test suite with:

     mvn clean test
    
Maven Surefire executes the JUnit tests and stores the raw test results under:

  target/surefire-reports/

## Test Coverage

The framework covers Books and Authors API scenarios, including:

    • Retrieve books
    
    • Retrieve a book by ID
    
    • Create a book
    
    • Update a book
    
    • Delete a book
    
    • Retrieve authors
    
    • Retrieve an author by ID
    
    • Retrieve authors associated with a book
    
 # Negative / Edge Cases

The framework also covers negative and edge cases. Since FakeRESTApi is a simulator, some API behaviors have limitations or gaps.

The following cases are covered:

    • Create a book with invalid data
      
    • Delete a book with an invalid ID

    • Delete a non-existing book

    • Retrieve a book with an invalid ID
      
    •  Retrieve a non-existing book
      
    •  Update a non-existing book

These tests document the actual behavior of FakeRESTApi, even when the response is different from what would normally be expected from a real API.

## Test Report

Generate the HTML Surefire report after running the tests: 

     mvn surefire-report:report
    
The report provides a summary of the executed tests and their pass/fail status.

A copy from the last local run is in `Reports/surefire.html`

          
## CI Pipeline

Base URL : 'http://localhost:8080/job/online-bookstore-api-automation/'

The project uses Jenkins to run the tests automatically.

The Jenkinsfile contains the steps for the pipeline.

The pipeline:

    1. Gets the code from GitHub.
    
    2. Runs the API tests with Maven.
    
    3. Creates the Surefire HTML test report.
    
    4. Shows the test results in Jenkins.
    
    5. Saves the HTML report as a Jenkins artifact.
    
If a test fails, Jenkins can still create the test report.
  
  
## FakeRESTApi Behavior

FakeRESTApi does not save changes made by create, update, or delete requests.

Because of this, the tests check the response from each request instead of checking if the data was saved.

Test data cleanup is not needed because the changes are not saved.
