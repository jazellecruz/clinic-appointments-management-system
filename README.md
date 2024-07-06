# Clinic Appointments Management System

A Java-based appplication that manages appointments in a clinic. It provides a user-friendly Swing UI that is easy to navigate and use. The application follows the MVC + DAO (Model-View-Controller + Data Access Object) design pattern. 

*This was developed as a project for CC103 (Intermediate Programming).*

### Features
- **Authentication and Authorization**. Authenticate user with an email and password and provide functionalities based on user role (Doctor/Admin).
- **Create, Read, Update, Delete Appointments**. Add appoinments both for old and new patients, delete one or more appointments at once, read full details of an appoinment by double-clicking a row, update status of an appointment.
- **Sort Appoinments by Status**. Appointments can be sorted based on status (Pending, Confirmed, Canceled, Completed).
- **Dynamic Population of Data in Components**. Data of components (from the Appointment Form) are populated based on user's input.
- **Associate Old Patient to a new Appoinment**. Automatically link record of an old patient to a new appoinment only with patient's ID.

### Project Directory Structure

```
main
├───java
│       App.java                    # Main entry point of the app
│   ├───controllers                 # Adds behavior to the View
│   ├───dao                         # Contains DB queries
│   ├───database                    # Establishes connection to DB
│   ├───models                      # Structure of the DB entities
│   ├───resources                   # Static files used in the UI
│   │   └───images
│   ├───utils                       # Contains helper methods used throughout the app
│   └───views                       # Contains the GUI of the app
└───resources                       # ANOTHER folder with static files???
```

### Installation and Set Up

1. Clone the repository or just download it from here (whatever works).
2. Run the sql file to set up the database. Schema is located [here]("./src/main/java/database/clinic_appointments_db"). Modify the database connection parameters with your own.
3. Make sure MySQL JDBC Driver is added in the lib directory. 
4. Locate the App.java file then run. 

### References
- [MVC Architecture in Java](https://www.javatpoint.com/mvc-architecture-in-java)
- [MVC in a Java/Swing Application](https://www.developer.com/design/mvc-in-a-java-swing-application/)
- [Core J2EE Patterns - Data Access Object](https://www.oracle.com/java/technologies/dataaccessobject.html)
- [What is Data access object (DAO) in Java - Stack Overflow](https://stackoverflow.com/questions/19154202/what-is-data-access-object-dao-in-java)


### Contribution
Kindly make a pull request for contribution. For major changes, please open an issue first to discuss what you would like to change.



