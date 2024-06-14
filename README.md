**Car Rental Application**

To run this code, the complete source code needs to be downloaded, and while running the application, the MainApplication class needs to be selected and run. 

The backend runs on Java JDK 21 which will be required for starting the spring-boot application.

On starting the application a connection request will be sent to the database stored on the cloud, the connection might fail as a firewall request needs to be sent to the Microsoft Mysql database. Please get in touch with us in this situation.


**END-TO-END SOLUTION INTEGRATION AND DATA-DRIVEN / DATABASE PROGRAMMING**

**INTRODUCTION**
The Car Rental industry, a pivotal segment of global travel, has seen tremendous growth over the years. This rise began due to an increase in economic growth and increased mobility. As the travel needs expanded so did the demand for car rentals. With the advent of the internet in the early 2000’s, online booking platforms became the norm providing customers the convenience of booking and comparing prices and services instantaneously. The integration of digital technologies like data analytics, artificial intelligence, and machine learning has redefined the rental experience and helped drive business decisions to excellence.

**DESIGN AND IMPLEMENTATION**
Our project is focused on predicting the daily rental price of a car. This price depends on various factors like the type of fuel the car uses, its rating, how often it has been rented before, the number of reviews it has, and its location (city and exact geographical coordinates). Other factors include the brand, model, and year of the vehicle.
The project initially encompassed two components: ride and rental. Due to resource and time constraints, we have currently implemented only the rental segment.

**How It Works**
- User Input: Customers can choose the car's brand and model, where they'll pick it up and drop it off, and the dates for pickup and drop-off.
  
- Price Prediction: Based on these choices and the factors mentioned earlier, our system will calculate and show the daily rental price for the selected car.
This business use case seeks to provide clients with a clear, tailored price for their car rental, making the rental process simpler and more transparent. From a commercial standpoint, firms that have purchased automobiles and have an in-house system for supplying consumers with car rental services can benefit from this implementation, which will provide a recommendation for setting daily car rental rates in dollars based on the parameters listed below.
Below is the overview of the implementation architecture with the technologies used to create the Car Rental Website.
 
The dataset used for Car Rental has been deployed in the Azure database for MySql via the Azure Data Studio. 

CarRental Table
The Rental dataset contains data about the rental booking with details like fuel type, rating, renter trip taken, review count, owner ID, vehicle make, vehicle model, vehicle type, vehicle year, and rate daily.
 
I have bulk-imported the data used for CarRental using the BCP command via the local host terminal.
 
**Customers Table**
The customer table stores the data of the customers who are registered users of the RideShare website with details like Username, Password, Email, First Name, Last name, Phone Number, Age, Address, and ZipCode.

 <img width="512" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/6621f460-5b46-459f-b7fd-91c577e77e16">




Reservation Table
The Reservation table stores the details of the booking made by the customer. It consists of details like Booking ID, Pickup Location, Dropoff Location, Pickup Date, Dropoff Date, Vehicle make, Vehicle model, and Username.

<img width="502" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/6891038f-a60c-4021-b4ef-5c3eec90f7fd">

 
MODELING
The application utilizes Azure Automated ML to streamline the development of our machine learning model. This service automates the repetitive steps of model creation by testing various algorithms and settings simultaneously. Our model employs Linear Regression to estimate daily car rental prices. Azure Automated ML evaluates different combinations of features and algorithms, each time generating a model with its performance score. The most effective model determined by this process was the Voting Ensemble, which produced the most accurate results for our dataset.

<img width="508" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/fbeef6d0-2fc0-4a18-a0df-03f36fb52a23">

 
**MACHINE LEARNING**
Machine learning (ML) is a type of artificial intelligence (AI) focused on building computer systems that learn from data. The broad range of techniques ML encompasses enables software applications to improve their performance over time.
Machine learning algorithms are trained to find relationships and patterns in data. They use historical data as input to make predictions, classify information, cluster data points, reduce dimensionality, and even help generate new content.

Types of Machine Learning
- Supervised Learning: The system learns from data that is already labeled. It's like a student learning with the help of a teacher.

- Unsupervised Learning: The system tries to find patterns and relationships in data that are not labeled. It's like a student learning without any guidance.

- Reinforcement Learning: The system learns by trial and error, understanding what actions lead to rewards.

LINEAR REGRESSION
Linear regression is a type of supervised machine learning algorithm that computes the linear relationship between a dependent variable and one or more independent features. The model’s equation provides clear coefficients that elucidate the impact of each independent variable on the dependent variable, facilitating a deeper understanding of the underlying dynamics.

Our primary objective while using linear regression is to locate the best-fit line, which implies that the error between the predicted and actual values should be kept to a minimum. There will be the least error in the best-fit line.

The best Fit Line equation provides a straight line that represents the relationship between the dependent and independent variables. The slope of the line indicates how much the dependent variable changes for a unit change in the independent variable(s).

VOTING ENSEMBLE ALGORITHM
The Voting Ensemble algorithm is a machine learning technique that combines predictions from multiple models to make a final prediction. It's like a team of experts, each giving their opinion, and then taking a vote to decide the outcome. This method is used to improve the accuracy of predictions by leveraging the strengths of various individual models.

**How It Works**
-Multiple Models: In a voting ensemble, different machine-learning models are trained. These could include algorithms like decision trees, logistic regression, support vector machines, etc.

-Prediction and Voting: Majority Voting (for Classification): Each model makes a prediction (like a vote) for a given input. The final prediction is based on the majority vote. For example, if three models predict 'A', two predict 'B', and one predicts 'C', the ensemble would predict 'A'.

-Average Voting (for Regression): Each model predicts a numerical value. The final prediction is the average of all these predictions.

Types of Voting
- Hard Voting: In classification problems, hard voting counts the vote of each classifier in the ensemble and picks the prediction that gets the most votes.

- Soft Voting: In soft voting, the probabilities of each class prediction are averaged, and the class with the highest probability is chosen. It's a more flexible approach compared to hard voting.

Benefits of Voting Ensemble
- Improved Accuracy: By combining predictions, the ensemble often achieves higher accuracy than individual models.

- Reduced Overfitting: Different models will make different errors, so combining them can reduce the chance of overfitting the training data.

- Leveraging Strengths: Each model might be good at capturing certain patterns in the data. By using an ensemble, you can take advantage of these strengths.

Use Cases
Voting ensembles are used in various fields where predictive accuracy is crucial, like in financial forecasting, medical diagnosis, or customer behavior prediction.


**Metrics for regression models**
The metrics returned for regression models are designed to estimate the amount of error. A model is considered to fit the data well if the difference between observed and predicted values is small. 
The following metrics are reported for evaluating regression models.
1. explained_variance: This metric measures the proportion of the variance in the dependent variable that is predictable from the independent variables. A higher value closer to 1 indicates a better model.
2.	mean_absolute_error (MAE): This is the average of the absolute errors between the predicted values and the actual values. It measures the average magnitude of errors in a set of predictions, without considering their direction.
3.	mean_absolute_percentage_error (MAPE): This is similar to MAE but it expresses the error as a percentage. It's the average of the absolute percentage errors between the predicted and actual values.
4.	median_absolute_error: This is the median of all absolute differences between the predicted values and actual values. The median is less sensitive to outliers than the mean.
5.	normalized_mean_absolute_error: This is the MAE normalized by the range or standard deviation of the data. It gives a sense of the error relative to the scale of the data.
6.	normalized_median_absolute_error: This is the median absolute error after normalization. Like the normalized MAE, it provides a relative measure of the typical error in the middle of the error distribution.
7.	normalized_root_mean_square_error (NRMSE): This is the RMSE normalized by the range or standard deviation of the data. It's used to compare the performance of models on different scales. The value of 0.01645998 suggests that the model's predictions are fairly accurate relative to the variability of the data.
8.	r2_score: Also known as the coefficient of determination, this metric provides a measure of how well future samples are likely to be predicted by the model. An R² of 0.9211270 suggests that approximately 92% of the variance in the dependent variable is predictable from the independent variables.
9.	root_mean_squared_error (RMSE): This is the square root of the average of squared differences between predictions and actual values. The value of 24.36077 indicates the typical size of the errors in the same units as the predicted values.
10.	spearman_correlation: This measures the monotonicity of the relationship between predicted and actual values. A value close to 1 or -1 indicates a strong monotonic relationship, while a value close to 0 indicates a weak monotonic relationship. The given value of 0.9208078 suggests a strong positive relationship.
11.	Second NRMSE: There's another normalized root mean square error value of 0.05523841. This could be calculated on a different test set or using a different normalization method. It's also a relative measure of model error.
These metrics collectively provide a comprehensive view of the model's performance. High values for explained variance and R², along with low values for the various error metrics, generally suggest a good predictive model.

**Screenshots of the Final predicted price output:**

<img width="490" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/571971b2-ca67-408f-b956-185dbf8e3796">

Below is the graphical representation of the result of the tested model.

<img width="494" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/e49696ba-0ba7-436c-81f3-432c3c7aa221">

 
**Predicted vs. True**
The graph below represents the predicted value vs the true value of our tested model. The solid line shows the average prediction for each actual value, and the dotted line represents the ideal match between predictions and actual values—the "best fit" line.  The closer the solid line is to the dotted line, the more accurate the predictions are.
 
The provided screenshots illustrate the deployment process of our model. The deployed endpoint is named “rental-automl.”  Below, you can find the REST endpoint URL.
URL: http://dee23129-0171-4a56-a110-93b2bfd58ee7.eastus2.azurecontainer.io/score
 
The conducted a test for our URL in Postman, inputting specific values. This process successfully displayed the daily rental price as output.

<img width="486" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/861ed971-2693-4802-9317-9f0e3277fe1a">

 
**PROGRAMMING TECHNIQUES/ LANGUAGES**
The project consists of three parts: frontend, backend, and database. I have used the Azure database for MySql to store our dataset.  
MySql
MySQL is the world’s most popular open-source database. Azure Database for MySQL is a fully managed database as a service offering that can handle mission-critical workloads with predictable performance and dynamic scalability. I have set up a database called "RideRental" on Azure. It has tables for managing car rentals, customer information, and reservations.
 
JAVA SPRINGBOOT 
Java Spring Framework (Spring Framework) is a popular, open-source, enterprise-level framework for creating standalone, production-grade applications that run on the Java Virtual Machine (JVM). Java Spring Boot (Spring Boot) is a tool that makes developing web applications and microservices with Spring Framework faster and easier through three core capabilities:
- Autoconfiguration
- An opinionated approach to configuration
- The ability to create standalone applications.
I developed our backend using Spring Boot. This allowed us to create, read, update, and delete data in our application, covering all the basic actions needed for managing our data.
As the name suggests, 
- CREATE Operation: Performs the INSERT statement to create a new record.

- READ Operation: Reads table records based on the input parameter.

- UPDATE Operation: Executes an update statement on the table. It is based on the input parameter.

- DELETE Operation: Deletes a specified row in the table. It is also based on the input parameter.

**REACT**
I used React, a popular JavaScript library for building user interfaces, to create our project's front end. React has been widely used since its debut in May 2013. Our website's homepage has options for users to sign in or register. Customers can pick a car's brand and model, choose pickup and drop-off locations, and select dates. The website then shows the daily price for the chosen cars. After seeing the prices, users can pick a car and confirm their booking.

**Final Working Project Screenshots:**

<img width="1152" alt="Screenshot 2023-12-22 at 12 13 42 PM" src="https://github.com/pc3457/rental-app-backend/assets/146313699/5011b55e-5807-4c76-b5bd-ef53b006255d">

<img width="1152" alt="Screenshot 2023-12-22 at 10 08 50 PM" src="https://github.com/pc3457/rental-app-backend/assets/146313699/e30f0cd6-d42e-4497-85d1-464dbd75f19a">

<img width="1152" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/65b2f5b0-572c-45c6-b790-3f582408955d">

<img width="483" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/8d8c82df-a256-4346-9280-92dd9f6d8c33">

<img width="483" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/e7951228-85c8-4d23-87c8-390f892e4735">

<img width="507" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/a7796949-18e8-454b-ade0-98102aed3e1d">

<img width="512" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/9832f254-3790-4843-a7c3-51449d91ffb0">

<img width="501" alt="image" src="https://github.com/pc3457/rental-app-backend/assets/146313699/55edd7e1-b5fd-455d-8447-098c640d951c">



GitHub Reference Links:

- Frontend: https://github.com/pc3457/rental-ui

-Backend: https://github.com/pc3457/rental-app-backend







