
/**
 * Note: 
 * This application follows the MVC + DAO Architecture (Model-View-Controller + Data Access Objects).
 * The View serves as the UI for presenting our data while the 
 * Controller dictates and adds the behavior (ex. response to an event) 
 * of the View. The Model serves as the structure of our data/components.
 * 
 * 
 * FUTURE IMPROVEMENTS/IMPLEMENTATION???:
 * - Connection pooling 
 * - Error handling
 * - Nullify references for garbage collection??
 */

/* MAIN ENTRY POINT OF THE APP */

/**
 * ACCOUNTS:
 * jamesreid@clinic.com
 * danielpadilla@clinic.com
 * enriquegil@clinic.com
 * admin@clinic.com
 * 
 * PASSWORD: password
 */

/**
 * INSTRUCTIONS FOR DATABASE:
 * Make sure mysql.exe is globally accessible
 * Enclose file path of schema in double quotes
 * Open command prompt, then type this below:
 * mysql -u root -p < "change/this/to/path/to/clinic_appointment_db.sql"
 */

package main.java;

import main.java.controllers.LoginController;
import main.java.views.LoginView;

public class App {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        new LoginController(view);
    }
}