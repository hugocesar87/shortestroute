# Shortest Route Exercise 
Exercise to get the shortest path on flights between airports.
> NOTE: To run the project, be sure you have Maven and Java 8 installed and configured.

### Project Execution.
- Clone the project in your local repo.
- Open console where the pom.xml is located.
- Perform command "mvn spring-boot:run" to start the application. Application will start at port 8081.
- Test application with your favorite REST client (e.g. Postman) or Browser by posting URL.

### Test App Example.
	Request: 
		> http://localhost:8081/shortestroute/route/get?origin=YYZ&destination=BJX
	Response:
		 {
			"code":"SHORTEST_ROUTE_001",
			"msg":"Operation performed successfully.",
			"response":["YYZ", "IAH", "BJX"],
			"error":false
		  }
  
### Covered User Stories.

- As a user I can make a GET request to an endpoint with an `origin` and `destination` query parameter, and receive back the shortest route between the two, as an array of connecting flights. A shortest route is defined as the route with the fewest connections. If there are mulitple routes with the same number of connections, you may choose any of them. 
- As a user I am provided meaningful feedback should no route exist between the airports.
- As a user I am provided meaningful feedback if an error occurred with my request.

Test cases considered.

| Origin | Destination | Expected Result          |
|--------|-------------|--------------------------|
| YYZ    | JFK         | YYZ -> JFK               |
| YYZ    | YVR         | YYZ -> JFK -> LAX -> YVR |
| YYZ    | ORD         | No Route                 |
| XXX    | ORD         | Invalid Origin           |
| ORD    | XXX         | Invalid Destination      |


