/*Main class: Creates a new SplashScreen frame  and 

* calls the LoginButton ActionListener. When pressing the login button, it calls 

* a LoginFrame, while maintaining the SplashScreen as visible in the background. It also 

* sets the LoginFrame to be visible. 

*/ 

 
 

 
 

package edu.pupr.store; 

 
//import javax.swing.*;  

 
 

 
 

//Main.java  

 
 

//Main.java  

 
 

public class Main {  

 
 

public static void main(String[] args) {  

 
 

SplashScreen splashScreen = new SplashScreen();  

 
 

splashScreen.setLoginButtonActionListener(e -> {  

 
 

splashScreen.setVisible(false);  

 
 

LoginFrame loginFrame = new LoginFrame(splashScreen);  

 
 

loginFrame.setVisible(true);  

 
 

});  

 
 

splashScreen.setVisible(true);  

 
 

} 

} 

 

 