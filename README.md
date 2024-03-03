# Task 3

What should be done
1. Create maven project with 4 modules :

- jmp-dto - jmp-service-api - jmp-cloud-service-impl - jmp-service-rest

2. Create the fallowing classes under jmp-dto module :

- [User] Long id; String name; String surname; LocalDate birthday; - [Subscription] Long id; User user; LocalDate startDate; - [UserRequestDto] Long id; String name; String surname; String birthday; - [SubscriptionRequestDto] Long id; Long userId; - [UserResponseDto] Long id; String name; String surname; String birthday; - [SubscriptionResponseDto] Long id; Long userId; String startDate;

3. Create UserController under jmp-service-rest module with following methods:

- createUser(UserRequestDto); - updateUser(UserRequestDto); - deleteUser(Long); - getUser(Long); - getAllUser();

4. Use id filed into UserRequestDto only for updating data.

5. Must be returned UserResponseDto from the following methods :

- createUser(UserRequestDto); - updateUser(UserRequestDto); - getUser(Long); - getAllUser();

6. Create ServiceController under jmp-service-rest module with following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - deleteSubscription(Long); - getSubscription(Long); - getAllSubscription();

7. Use id filed into SubscriptionRequestDto only for updating data.

8. Must be returned SubscriptionResponseDto from the following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - getSubscription(Long); - getAllSubscription(); (as list)

9. Add necessary interfaces/methods to jmp-service-api.

10. Implement interfaces/methods under jmp-service-api into jmp-cloud-service-impl.

11. UserController and ServiceController must provide REST API interfaces according to 2nd of REST API maturity.

12. You can use memory structures to store the data (List, Map..).

13. Use jmp-cloud-service-impl to implement UserController and ServiceController.

14. Implement Application class with @SpringBootApplication annotation and main method.

15. Use lambdas and Java 8 features wherever it’s applicable.

16. Make sample requests to UserController and ServiceController, provide screenshots/responses.

(3-4 stars)

17. Use a DB to store the data (List, Map..).

18. Use spring boot data jpa module to access data.

19. Use spring converters to convert :

- UserRequestDto to User - User to UserResponseDto - SubscriptionRequestDto to Subscription - Subscription to SubscriptionResponseDto

20. Document methods in UserController and ServiceController using Swagger 2 annotations.

21. Make sample requests to UserController and ServiceController via Swagger UI, provide screenshots.

(5 stars)

22. Use Java 9 modules wherever it’s applicable.

23. Implement REST APIs according to all Richardson Maturity Level (0 - 3).

24. Make sample requests to UserController and ServiceController, provide screenshots/responses.
