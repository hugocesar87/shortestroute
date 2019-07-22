# Shortest Route Excercise 
Exercise to get the shortest path on flights between airports.

### What is the test?

You will be building an endpoint that allows users to search a data set. Included in this repository is a set of Airport, Airline, and Route data. Your task is to create models to represent, relate and ultimately expose the data to a GET endpoint. Users of the API will be able to search for routes given an origin and destination.

### User Stories (Requirements)

- As a user I can make a GET request to an endpoint with an `origin` and `destination` query parameter, and receive back the shortest route between the two, as an array of connecting flights. A shortest route is defined as the route with the fewest connections. If there are mulitple routes with the same number of connections, you may choose any of them. 
- As a user I am provided meaningful feedback should no route exist between the airports.
- As a user I am provided meaningful feedback if an error occurred with my request.

> NOTE: THE SHORTEST PATH FUNCTIONALITY MAY NOT RELY ON AN EXTERNAL LIBRARY. YOU MUST DEVELOP THIS ON YOUR OWN.

### Testing

Two data sets will be provided a test set and fullset please use the test set for development purposes, but understand that your solution should be perfromant with the full data set. 


Some test cases to consider on the `test` data set.

| Origin | Destination | Expected Result          |
|--------|-------------|--------------------------|
| YYZ    | JFK         | YYZ -> JFK               |
| YYZ    | YVR         | YYZ -> JFK -> LAX -> YVR |
| YYZ    | ORD         | No Route                 |
| XXX    | ORD         | Invalid Origin           |
| ORD    | XXX         | Invalid Destination      |

### Getting Started

Please build your solution using Java Spring and Maven. 

### Submitting

1. upload your solution to a github repository, and send us a link so we can clone it. 
2. Run through it one last time to make sure it works!
3. Provide a README file that explains how to build, test(hint - tests are good), and run the application. 
### Questions

If you have any questions during the challenge feel free to open an issue on this repo and ask it.

