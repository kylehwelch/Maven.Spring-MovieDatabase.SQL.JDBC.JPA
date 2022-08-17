# Persistence

## Part 1: SQL

The following lab is to be completed using the H2 Console. Once you have figured out the correct queries for each step, save a copy in a file called `src/main/resources/script.sql`. This will be how you submit this assignment. If at any time you need to reset the database, you can restart your Spring Boot server.

### Mini Movie Database

Add the following movies to the `movies` table using an insert statement:

| Title | Runtime | Genre | IMDB Score | Rating |
| ----- | ------- | ----- | ----------- | ----- |
| Howard the Duck | 110 | Sci-Fi | 4.6 | PG |
| Lavalantula | 83 | Horror | 4.7 | TV-14 |
| Starship Troopers | 129 | Sci-Fi | 7.2 | PG-13 |
| Waltz With Bashir | 90 | Documentary | 8.0 | R |
| Spaceballs | 96 | Comedy | 7.1 | PG |
| Monsters Inc. | 92 | Animation | 8.1 | G |

Add a few more movies of your choosing.

Create a query to find all movies in the Sci-Fi genre.

Create a query to find all films that scored at least a 6.5 on IMDB

For parents who have young kids, but who don't want to sit through long children's movies, create a query to find all of the movies rated G or PG that are less than 100 minutes long.

Create a query to show the average runtimes of movies rated below a 7.5, grouped by their respective genres.

There's been a data entry mistake; Starship Troopers is actually rated R, not PG-13. Create a query that finds the movie by its title and changes its rating to R.

Show the ID number and rating of all of the Horror and Documentary movies in the database. Do this in only one query.

This time let's find the average, maximum, and minimum IMDB score for movies of each rating.

That last query isn't very informative for ratings that only have 1 entry. use a `HAVING COUNT(*) > 1` clause to only show ratings with multiple movies showing.

Let's make our movie list more child-friendly. Delete all entries that have a rating of R. Remember to record your query in `script.sql`.

## Part 2: JDBC

### 2A: People

Create a `PersonService` class. These will be used to manipulate the contents of the database given program requirements. Remember to use a `JdbcTemplate` to provide access to your database. All database access logic and sorting/filtering should be handled by your `PersonService` and the SQL queries it issues to the database.

You can provide your `PersonService` to any controller that needs it by marking it as a `@services` class and autowiring it into the appropriate controller. Remember that you will also need a corresponding `services` class to hold the data in transit. You do not need to use any of the JPA annotations (`@ID`, `@Entity` etc.) in your services class.

Support the following operations:

- Add a `services` to the database
- Update an existing `services` in the database
- Remove a person from the database
- remove a list of people from the database
- find all people with a particular first name, last name, or birthdate
- Find a single person by ID
- Generate a map of surnames to lists of people with that surname
- Generate a map of first names to the number of times they occur.

Create the following REST endpoints to interact with the application. You can use postman to confirm your program's behavior.

 - `POST` `/people` -- create a person
 - `PUT` `/people/{id}` -- update person with `id`. 404 error if that person doesn't exist yet
 - `GET` `/people/{id}` -- get the person with the specified ID
 - `DELETE` `/people/{id}` -- Delete the person with the specified ID
 - `GET` `/people` -- get all people in the database
 - `GET` `/people/reverselookup/{mobileNumber}` -- find all people with the specified mobile number
 - `GET` `/people/surname/{lastName}` -- Find all people with a particular last name
 - `GET` `/people/surname` -- Get the result of the surname report above
 - `GET` `/people/firstname/stats` -- Get the report of first name frequencies
 
#### Homes and People 
There is another table in the data base named home that consist of the following
fields:

| ID | ADDRESS | HOMENUMBER |
|----|---------|------------|

People in the 'services' table are able to have a home from the 'Home' table associated with them.
People are mapped to homes through their 'HOME_ID' value which is a foreign key that references the id column in the 'HOME' table

Add the following homes to the 'HOME' table

|       Address         |    Home Number    |
|-----------------------|-------------------|
| 36 E. Bayberry Rd.Savannah, GA 31404 | 565-6895 |
| 11 Essex Dr.Farmingdale, NY 11735 | 454-4544 |
| 920 Arlington Street Clifton, NJ 07011 | 985-4515 |
| 234 High Street, PA 19159 | 267-3940 |


_You may use the query in the 'data-h2.sql' file to populate the 'PERSON' and 'HOME' table_


Support the following operations:

- Add a "Home" to the database
- Add a person to a home 
- Update an existing 'Home' in the database
- Remove a home from the database
- Remove a list of homes from the database
- Find a home by id
- Find a home by home number
- Find a home by address
- Find a home by person id
- Generate a list of people that live in a home



List all of the homes that have more that one person that live there. Group people by the home that they 
live in 

List all of the people that live a the address _11 Essex Dr.Farmingdale, NY 11735_
 
Create a query to update a person's home

Create a query to update a person's 'HOMENUMBER"

Find the home number of John Smith


## Part 3: JPA
 
In this section we're going to re-create our service class using JPA. 

Start by breaking your `PersonService` class into an interface and implementation eg: `interface PersonService` and `class JdbcPersonServiceImpl`. Place the `@services` annotation on the implementation class.

Now create a new class that implements the PersonService, this time with JPA. Once you annotate this class with @services you will get an error when you start spring -- you can fix this by annotation the service you want to use with `@Primary` -- This tells Spring that if there are multiple beans competing for autowiring, the one marked with `@Primary` should be used (this won't work if multiple competing beans are marked `@Primary`

In your `JdbcPersonServiceImpl` you used a `JdbcTemplate` or `NamedParameterJdbcTemplate` to access the database. In your `JpaPersonServiceImpl` you will use a `PersonRepository` instead. You will have to define the interface for this repository, but the Spring Framework will provide the implementation automatically.

Implement all of the methods found in your `PersonService` interface in this new JPA-based service. You won't have to change your controller at all if you are autowiring a reference to a `PersonService` - Spring will automatically inject the `@Primary`-annotated implementation of `PersonService`

Remember that you won't be using the Jdbc service or any `JdbcTemplate` objects in this part of the lab.
