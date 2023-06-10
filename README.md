# Matrix Multiplication Application

This is a multithreaded Java application designed to multiply two matrices of size 100 x 100. The purpose of this exercise is to practice implementing multithreading concepts and to demonstrate how the main thread can wait for other threads to complete before forming the final result.

## Prerequisites

Before running this application, make sure you have the following:

- Java Development Kit (JDK) installed on your machine.
- Basic understanding of multithreading in Java.

## Getting Started

1. Clone this repository to your local machine or download the source code files.
2. Open the project in your preferred Java IDE.

## Usage

1. Open the `MatrixMultiplication.java` file in the IDE.
2. Configure the number of threads and the matrix size according to your requirements. In this exercise, we use 10 threads and two matrices of size 100 x 100.
3. The application automatically fills the matrices with random values.
4. Run the application.

    - To run the application from the IDE, click on the "Run" button.

    - To run the application using the JAR file included in the project, navigate to the project directory in the command line and run the following command:

      ```
      java -jar MultithreadedMatrixMultiplication.jar
      ```

## Implementation Details

1. The `MatrixMultiplication` class contains the main method and is responsible for coordinating the execution of the threads and forming the final result.
2. The `MatrixMultiplier` class represents a worker thread. Each thread is assigned 10 rows from the matrices to perform the multiplication operation.
3. The matrices are represented using two-dimensional arrays.
4. The application uses Java's `Thread` class and its `join()` method to ensure that the main thread waits for all the worker threads to complete before forming the final result.
5. The final result is stored in a separate matrix.
