/*DisplayProduct class: Creates a new DisplayProduct frame with its own main function to 

* create the frame and set it to visible. 

* 

*DisplayProduct() constructor: 

*Establishes the frame and its decorations.  

*  

* Creates an instance of a product query and calls upon the Product Query method, verifyProductNum() 

* with the product No. entered by the user. If it is entered correctly it will return 1 and the 

* DisplayProductFrame will be shown. If it returns a 0, an error message is shown, if the user 

* selects cancel, it will return null. The while cycle is used to maintain this until the user 

* decides to opt-out and return to the main menu. 

 

*  

* DisplayProductFrame : 

* -A new JPanel is created and decorated 

* -Includes Yes and No buttons. 

* -The product image is placed on a JLabel, already added onto the frame. 

* (The path to the image is re-definable, which allows it to work with multiple computers. 

* It adds to the path whichever image name the user entered, including .jpg) 

*  

* The Yes button has an actionPerformed() method to create a ProductQuery instance 

* and call upon the ProductQuery method, getProductByNo(), which searches for the product 

* with that given product number and displays all of its information. The database connection is then closed. 

*  

* Uses a string builder to place all the information and then convert it into 

* a JTextArea. 

*  

* The No button disposes the DisplayProductFrame. 

*/ 

  

  

package edu.pupr.store; 

  

import java.awt.Color; 

  

import java.awt.Component; 

import java.awt.EventQueue; 

import java.awt.Font; 

import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener; 

import java.io.File; 

import java.util.List; 

  

import javax.swing.ButtonGroup; 

import javax.swing.GroupLayout; 

import javax.swing.ImageIcon; 

import javax.swing.JButton; 

import javax.swing.JFileChooser; 

import javax.swing.JFrame; 

import javax.swing.JLabel; 

import javax.swing.JOptionPane; 

import javax.swing.JPanel; 

import javax.swing.JRadioButton; 

import javax.swing.SwingConstants; 

import javax.swing.GroupLayout.Alignment; 

import javax.swing.LayoutStyle.ComponentPlacement; 

import javax.swing.border.BevelBorder; 

import javax.swing.border.EmptyBorder; 

import javax.swing.border.EtchedBorder; 

import javax.swing.border.SoftBevelBorder; 

import javax.swing.JTextArea; 

import javax.swing.GroupLayout; 

  

public class DisplayProduct extends JFrame { 

  

private static final long serialVersionUID = 1L; 

private JPanel contentPane; 

private JLabel displayLbl; 

private JTextArea prodTxtArea; 

private JLabel imgLbl; 

 

  

 

  

/** 

 * Launch the application. 

 */ 

public static void main(String[] args) { 

EventQueue.invokeLater(new Runnable() { 

public void run() { 

try { 

 

DisplayProduct frame = new DisplayProduct(); 

frame.setVisible(true); 

} catch (Exception e) { 

e.printStackTrace(); 

} 

} 

}); 

} 

  

/** 

 * Create the frame. 

 */ 

public DisplayProduct() { 

 

 

//ASK AND VERIFY THE PRODUCT NUMBER ENTERED 

 ProductQueries productQueries = new ProductQueries(); 

 // Prompt the user to enter the product number. 

 String productNo = JOptionPane.showInputDialog("Enter the product's number:"); 

 int result = 0; 

 //verify product number 

 result = productQueries.verifyProductNum(productNo); 

  

 //While the product number is wrong and the user has not selected cancel 

 while(result==0 && productNo != null) { 

 	 

 JOptionPane.showMessageDialog(null, "Invalid product number", "Product Error", JOptionPane.ERROR_MESSAGE);  

 
 

 	  

 	 // Prompt the user to enter the product number. 

 productNo = JOptionPane.showInputDialog("Enter the product's number:"); 

 result = 0; 

 //verify product number 

 result = productQueries.verifyProductNum(productNo); 

  

 } 

 

 

                	 

    setForeground(new Color(255, 255, 255)); 

setTitle("Display Product"); 

getContentPane().setBackground(new Color(64, 128, 128)); 

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

setBounds(100, 100, 636, 391); 

 setLocationRelativeTo(null); 

  

 contentPane = new JPanel(); 

contentPane.setBackground(new Color(64, 128, 128)); 

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

setContentPane(contentPane); 

  

displayLbl = new JLabel("Display product: "); 

displayLbl.setForeground(new Color(255, 255, 255)); 

displayLbl.setFont(new Font("Serif", Font.PLAIN, 30)); 

 

 

imgLbl = new JLabel(""); 

 

 

 

        // ProductQueries aProductQuery = new ProductQueries(); 

       //Set all text fields to the information stored for that product  

     List<Products> list = productQueries.getProductByNo(productNo); 

 

Products aProduct = (Products) list.get(0); 

 

     	//Find the image name of the given product  

String anImage = aProduct.getProductImage(); 

 

//Find a general path to the picture regardless of system currently in use 

String userHomeDirectory = System.getProperty("user.home"); 

String imagePath = userHomeDirectory + File.separator + anImage; // Use File.separator for OS-specific file separator 

  

imgLbl.setIcon(new ImageIcon(imagePath)); 

       

         // Format and display the products in a dialog box. 

         StringBuilder productInfo = new StringBuilder(); 

         productInfo.append("Product Info:\n\n"); 

             productInfo.append("Product No: " + aProduct.getProductNo() + "\n"); 

             productInfo.append("Name: " + aProduct.getProductName() + "\n"); 

             productInfo.append("Description: " + aProduct.getProductDescription() + "\n"); 

             productInfo.append("Brand: " + aProduct.getProductBrand() + "\n"); 

             productInfo.append("Quantity: " + aProduct.getQuantity() + "\n"); 

  

          // Format the cost and price with two decimal places 

             String formattedCost = String.format("%.2f", aProduct.getCost()); 

             String formattedPrice = String.format("%.2f", aProduct.getPrice()); 

  

             productInfo.append("Cost: $" + formattedCost + "\n"); 

             productInfo.append("Price: $" + formattedPrice + "\n"); 

              

             productInfo.append("\n"); 

          

         productQueries.close(); 

  

         prodTxtArea = new JTextArea(productInfo.toString()); 

         prodTxtArea.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null)); 

         prodTxtArea.setBackground(new Color(238, 237, 191)); 

         prodTxtArea.setFont(new Font("Serif", Font.BOLD, 18)); 

          

        // JOptionPane.showMessageDialog(null, productInfo.toString(), "All Products", JOptionPane.INFORMATION_MESSAGE); 

       

 

GroupLayout groupLayout = new GroupLayout(getContentPane()); 

groupLayout.setHorizontalGroup( 

groupLayout.createParallelGroup(Alignment.TRAILING) 

.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup() 

.addGap(21) 

.addComponent(imgLbl, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.UNRELATED) 

.addComponent(prodTxtArea, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE) 

.addContainerGap()) 

.addGroup(groupLayout.createSequentialGroup() 

.addContainerGap(178, Short.MAX_VALUE) 

.addComponent(displayLbl, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE) 

.addGap(170)) 

); 

groupLayout.setVerticalGroup( 

groupLayout.createParallelGroup(Alignment.LEADING) 

.addGroup(groupLayout.createSequentialGroup() 

.addContainerGap() 

.addComponent(displayLbl, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE) 

.addGap(30) 

.addGroup(groupLayout.createParallelGroup(Alignment.LEADING) 

.addComponent(imgLbl) 

.addComponent(prodTxtArea, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)) 

.addContainerGap(22, Short.MAX_VALUE)) 

); 

getContentPane().setLayout(groupLayout); 

 

        } //end if 

  

} 

 