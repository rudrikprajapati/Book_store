# Book_store
Develop a console-based application for a bookstore.

Part I: User Login/ Register
● Application should start by showing two options: (1) Sign In (2) Register

● In the case of Sign In, ask the user to provide his “username” and “password”. If they
match, let her in, not otherwise.

● In the case of Register, ask the user to provide his “full name”, “username”, and
“password”. In case of password, echo asterisk symbol (*) in place of the typed character.
E.g., a user types “1@4”, you should display “***”, but you will store the actual
password to match when she logs in again.
Hint: You can use java.io.Console.readPassword() method. Carefully read
its description from the Java 8 docs online.

● In case of Sign In, provide an option of “Forgot Password”. Ask the user for her name, if
it matches then, let her set a new password and redirect her to login again with the new
password.


Part II: Display Catalog
● As the user successfully logs in, the application should display a list of available books,
their points (equivalent to book price), and their status of availability (e.g., In-store,
Out-of-Stock, 5 copies available).

● At the end of above list, it should also show two options: (1) Show Profile, (2) Purchase,
(2) Logout

● In the case of the “Show Profile”, it should show a list of books that she has already
purchased and the balance points that she can use to purchase new books. Of course, at
the end, there should be two options: (1) Back to the Catalog, (2) Logout.


Part III: Make Transaction
● On selecting the “Purchase” option, show the catalog to the user and ask her to type the
Book ID she wants to purchase.

● In case of sufficient balance, send her the message of successful transaction. Direct her to
her profile, show the book details on top of her purchased books lists, and update her
balance points.
