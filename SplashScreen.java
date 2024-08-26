/*SplashScreen class: Creates a SplashScreen JWindow with background music.  

* Calls the initComponents() function to integrate all the components (background image,  

* music, and login/exit buttons). Also calls the playBackgroundMusic() method to loop the inserted 

* song until the project is closed.  

  

*/ 

  

 package edu.pupr.store;  

  

import javax.sound.sampled.AudioSystem;  

  

import javax.sound.sampled.Clip;  

  

import javax.swing.*;   

  

   

  

import java.awt.*;   

  

   

  

import java.awt.event.ActionEvent;   

  

   

  

import java.awt.event.ActionListener;  

  

import java.io.File; 

import javax.swing.border.SoftBevelBorder; 

import javax.swing.border.BevelBorder;   

  

   

public class SplashScreen extends JFrame {   

  

   

  

private static final long serialVersionUID = 1L;   

  

   

private ActionListener loginButtonActionListener;   

  

   

public SplashScreen() {   

  

   

  

     initComponents();   

  

  // Call the method to play background music  

  

     playBackgroundMusic("Harry's Wondrous World.wav"); // Replace with your music file path  

  

   

  

       

  

   

  

}   

  

   

  

   

  

   

//Method to integrate the actions of the Login Button (to present the LoginFrame) 

public void setLoginButtonActionListener(ActionListener listener) {   

  

   

  

     this.loginButtonActionListener = listener;   

  

       

  

   

  

}   

  

   

  

//Method to play background music for JWindow  

  

public void playBackgroundMusic(String musicFile) {  

  

    try {  

  

        File file = new File(musicFile);  

  

        Clip clip = AudioSystem.getClip();  

  

        clip.open(AudioSystem.getAudioInputStream(file));  

  

        clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously  

  

        clip.start();  

  

    } catch (Exception e) {  

  

        e.printStackTrace();  

  

    }  

  

}  

  

   

  

   

  

//Method to play sound when pressing a button  

  

public void playSound(String soundFile) {  

  

    try {  

  

        File file = new File(soundFile);  

  

        Clip clip = AudioSystem.getClip();  

  

        clip.open(AudioSystem.getAudioInputStream(file));  

  

        clip.start();  

  

    } catch (Exception e) {  

  

        e.printStackTrace();  

  

    }  

  

}  

  

   

  

/*  Method that integrates all components of the JWindow. Login Button and Exit buttons are created,  

* their bounds are formatted, added to the content Pane, and are later set visible. Adds an actionPerformed so the buttons play the inserted audio clip 

* when pressing them. Sets the buttons to be visible at all times. Login button calls the LoginFrame, 

* Exit button closes the project.  

* Establishes an icon to be the image 

* size of the entire screen. Creates an image Panel and establishes its background to be that image. 

* It then sets the layout of the panel to be of the icon's size. Later, it formats the bounds 

* of the image Panel. Adds that image Panel to the content Pane and sets the frame as 

* undecorated and visible. 

*   

*/ 

  

private void initComponents() {   

  

 

//BUTTONS 

    

    // Create a custom close button 

    JButton closeButton = new JButton("X"); 

    closeButton.setBackground(new Color(255, 0, 0)); 

    closeButton.setForeground(new Color(255, 255, 255)); 

    closeButton.setFont(new Font("Arial Black", Font.PLAIN, 16)); 

    closeButton.setFocusPainted(false); 

    closeButton.setBorderPainted(false); 

  

    // Add an ActionListener to handle the close functionality 

    closeButton.addActionListener(new ActionListener() { 

        @Override 

        public void actionPerformed(ActionEvent e) { 

        	 //play sound when pressing button 

          	 playSound("Minecraft.wav_V1.wav"); 

            // Handle close action (e.g., exit the application) 

            System.exit(0); 

        } 

    }); 

     

     

    // Get the size of the screen 

    int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 

  

    // Position the close button on the right side of the frame 

    int buttonWidth = 80; 

    int buttonHeight = 30; 

    int buttonX = screenWidth - buttonWidth - 10; 

    int buttonY = 10; 

  

    // Set the bounds of the close button 

    closeButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight); 

  

    // Add the close button to the frame 

    getContentPane().add(closeButton); 

    closeButton.setVisible(true); 

 

//------------------------ 

     

     

     

    JButton loginButton = new JButton("Login");   

    loginButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(64, 0, 0), null)); 

    loginButton.setForeground(new Color(255, 255, 255)); 

  

  

  

    loginButton.setBackground(new Color(64, 128, 128));   

  

  

  

    loginButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));   

  

//LEFT, UP/DOWN, RIGHT 

  

    loginButton.setBounds(555, 440, 204, 70);   

  

  

    loginButton.addActionListener(new ActionListener() {  

   	  

    

        @Override  

  

        public void actionPerformed(ActionEvent e) {  

  

       	 //play sound when pressing button 

       	 playSound("Minecraft.wav_V1.wav"); // 

       	  

            SwingUtilities.invokeLater(() -> {  

  

                LoginFrame loginFrame = new LoginFrame(SplashScreen.this);  

  

                loginFrame.setVisible(true);  

  

            });  

  

        }  

  

    });  

  

  

  

    getContentPane().add(loginButton);   

  

  

    loginButton.setVisible(true); 

       

  

    //------------------------------------------------ 

     

    //FRAME 

     

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

  

    setExtendedState(JFrame.MAXIMIZED_BOTH); 

  

     getContentPane().setLayout(null);   

  

   

     ImageIcon backgroundImage = new ImageIcon(getClass().getResource("HogwartsLegacy.jpg"));   

  

   

     setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());   

     

     // Create a JLabel with an ImageIcon 

     

     JLabel imageLabel = new JLabel(backgroundImage); 

  

     // Set the layout manager to null to manually position the label 

     getContentPane().setLayout(null); 

  

    

     // Calculate the position to center the label 

     int x = -160; 

     int y = -150; 

     // Set the bounds of the label 

     imageLabel.setBounds(x, y, backgroundImage.getIconWidth(), backgroundImage.getIconHeight()); 

  

     // Add the label to the frame 

     getContentPane().add(imageLabel); 

   

     // Make the frame undecorated (no title bar, borders, etc.) 

     setUndecorated(true); 

  

     

     setVisible(true);  

  

}  

  

} 