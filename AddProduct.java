/*AddProduct class: Creates a new AddProduct frame with its own main function to 

* create the frame and set it to visible. 

* 

*AddProduct() constructor: 

*Establishes the frame and its decorations. The Yes button has an actionPerfomed() method  

*that calls upon the ProductQueries() constructor. Extracts all the entries given by 

*the user from the text fields and establishes them as the product's values.  

*Calls upon the Product Query method, addProduct which fulfills the query with those given 

*values. The method returns 1 if the product was successfully added 

*and 0 if not. 

* 

*The No button disposes the frame. 

* 

*The product image can be found using JFileChooser after selecting the Browse button. 

* 

*/ 

  

  

package edu.pupr.store; 

  

import java.awt.EventQueue; 

  

import javax.swing.JFrame; 

import javax.swing.JPanel; 

import javax.swing.border.EmptyBorder; 

import javax.swing.GroupLayout; 

import javax.swing.ImageIcon; 

import javax.swing.GroupLayout.Alignment; 

import javax.swing.JLabel; 

import javax.swing.JOptionPane; 

import javax.swing.JTextField; 

import javax.swing.JButton; 

import javax.swing.JFileChooser; 

import javax.swing.LayoutStyle.ComponentPlacement; 

import javax.swing.SwingConstants; 

import java.awt.Component; 

import java.awt.event.ActionListener; 

import java.io.File; 

import java.util.List; 

import java.awt.event.ActionEvent; 

import java.awt.Font; 

import javax.swing.JRadioButton; 

import java.awt.Color; 

import javax.swing.border.SoftBevelBorder; 

import javax.swing.border.BevelBorder; 

import javax.swing.ButtonGroup; 

import javax.swing.border.EtchedBorder; 

  

public class AddProduct extends JFrame { 

  

private static final long serialVersionUID = 1L; 

private JPanel contentPane; 

private JRadioButton yesButton; 

private JRadioButton noButton; 

private final ButtonGroup buttonGroup = new ButtonGroup(); 

private String imagePath;  

private JButton browseButton; 

private JTextField numTxtField; 

private JTextField nameTxtField_1; 

private JTextField descripTxtField; 

private JTextField brandTxtField; 

private JTextField imageTxtField; 

private JTextField quantTxtField; 

private JTextField costTxtField; 

private JTextField priceTxtField; 

 

  

/** 

 * Launch the application. 

 */ 

public static void main(String[] args) { 

EventQueue.invokeLater(new Runnable() { 

public void run() { 

try { 

AddProduct frame = new AddProduct(); 

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

public AddProduct() { 

setForeground(new Color(255, 255, 255)); 

setTitle("Add Product"); 

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

setBounds(100, 100, 881, 701); 

 setLocationRelativeTo(null);   

contentPane = new JPanel(); 

contentPane.setBackground(new Color(158, 202, 250)); 

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

  

setContentPane(contentPane); 

 

JLabel lblNewLabel = new JLabel("Enter the product information you wish to add: "); 

lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); 

lblNewLabel.setBackground(new Color(242, 219, 13)); 

lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30)); 

 

 

JLabel prodNameLbl = new JLabel("Product Name:"); 

prodNameLbl.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

JLabel prodNoLbl_1 = new JLabel("Product Num:"); 

prodNoLbl_1.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

JLabel descLbl_2 = new JLabel("Description:"); 

descLbl_2.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

JLabel brandLbl_3 = new JLabel("Brand:"); 

brandLbl_3.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

numTxtField = new JTextField(); 

numTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

numTxtField.setColumns(10); 

 

nameTxtField_1 = new JTextField(); 

nameTxtField_1.setFont(new Font("Serif", Font.PLAIN, 19)); 

nameTxtField_1.setColumns(10); 

 

descripTxtField = new JTextField(); 

descripTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

descripTxtField.setColumns(10); 

 

brandTxtField = new JTextField(); 

brandTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

brandTxtField.setColumns(10); 

 

JLabel imageLbl_3_1 = new JLabel("Image Name (include .jpg) :"); 

imageLbl_3_1.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

JLabel quantityLbl_3_2 = new JLabel("Quantity:"); 

quantityLbl_3_2.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

imageTxtField = new JTextField(); 

imageTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

imageTxtField.setColumns(10); 

 

quantTxtField = new JTextField(); 

quantTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

quantTxtField.setColumns(10); 

 

JLabel costLbl_3_2_1 = new JLabel("Cost:"); 

costLbl_3_2_1.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

JLabel priceLbl_3_2_1_1 = new JLabel("Price:"); 

priceLbl_3_2_1_1.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

costTxtField = new JTextField(); 

costTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

costTxtField.setColumns(10); 

 

priceTxtField = new JTextField(); 

priceTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

priceTxtField.setColumns(10); 

 

 

yesButton = new JRadioButton("Add"); 

yesButton.setBackground(new Color(158, 202, 250)); 

buttonGroup.add(yesButton); 

yesButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 255), null)); 

yesButton.setFont(new Font("Tahoma", Font.PLAIN, 20)); 

yesButton.addActionListener(new ActionListener() { 

    public void actionPerformed(ActionEvent event) { 

        // Create an instance of ProductQueries and establish a database connection. 

        ProductQueries productQueries = new ProductQueries(); 

         

        // Attempt to add the product to the database. 

         

        //Create string,int, and double variables for text fields 

        

  

String name = nameTxtField_1.getText(); 

String number = numTxtField.getText(); 

String brand = brandTxtField.getText(); 

String image = imageTxtField.getText(); 

String description = descripTxtField.getText(); 

 

         

Integer quantity = Integer.parseInt(quantTxtField.getText()); 

Float cost = Float.parseFloat(costTxtField.getText()); 

Float price = Float.parseFloat(priceTxtField.getText()); 

 

 

         

        int result = productQueries.addProduct(number, name, description,  

           brand, image, quantity, cost, price); 

  

        // Handle the result, display a message to the user. 

        if (result == 1) { 

            JOptionPane.showMessageDialog(null, "Product was successfully added!"); 

        } else { 

            JOptionPane.showMessageDialog(null, "Unable to add the product. Please check your input."); 

        } 

  

        // Close the database connection. 

        productQueries.close(); 

        dispose(); 

    } 

}); 

  

noButton = new JRadioButton("Cancel"); 

noButton.setBackground(new Color(158, 202, 250)); 

buttonGroup.add(noButton); 

noButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 

noButton.addActionListener(new ActionListener() { 

public void actionPerformed(ActionEvent event) { 

dispose(); 

} 

}); 

noButton.setFont(new Font("Tahoma", Font.PLAIN, 20)); 

 

 

JLabel lblNewLabel_1 = new JLabel(""); 

lblNewLabel_1.setBorder(null); 

 

browseButton = new JButton("Browse"); 

browseButton.addActionListener(new ActionListener() { 

public void actionPerformed(ActionEvent e) { 

 

                JFileChooser fileChooser = new JFileChooser(); 

                int returnValue = fileChooser.showOpenDialog(null); 

  

                if (returnValue == JFileChooser.APPROVE_OPTION) { 

                    // The user has selected a file. 

                    File selectedFile = fileChooser.getSelectedFile(); 

                    imagePath = selectedFile.getAbsolutePath(); 

                    

            		lblNewLabel_1.setIcon(new ImageIcon(imagePath)); 

            		 

                } 

            } 

        }); 

 

browseButton.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 13)); 

 

  

GroupLayout gl_contentPane = new GroupLayout(contentPane); 

gl_contentPane.setHorizontalGroup( 

gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(44) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE) 

.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)) 

.addGap(60) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(101) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addComponent(prodNameLbl, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(nameTxtField_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(prodNoLbl_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(numTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(brandLbl_3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(brandTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addComponent(quantityLbl_3_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addComponent(quantTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(costLbl_3_2_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(priceLbl_3_2_1_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(costTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(priceTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))))) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addComponent(descLbl_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(imageLbl_3_1)) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(descripTxtField, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE) 

.addComponent(imageTxtField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))) 

.addGap(95)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE) 

.addGap(68) 

.addComponent(noButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE) 

.addGap(129))))) 

.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) 

); 

gl_contentPane.setVerticalGroup( 

gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addContainerGap() 

.addComponent(lblNewLabel) 

.addGap(44) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(prodNameLbl, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(nameTxtField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.UNRELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(prodNoLbl_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(numTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGap(21) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(brandTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE) 

.addComponent(brandLbl_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)) 

.addGap(18) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(quantityLbl_3_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(quantTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGap(18) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(costLbl_3_2_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(costTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addComponent(priceLbl_3_2_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(priceTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))) 

.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(26) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(imageLbl_3_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE) 

.addComponent(imageTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGap(18) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(68) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(noButton) 

.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(descLbl_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(descripTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addPreferredGap(ComponentPlacement.UNRELATED) 

.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))) 

.addGap(186)) 

); 

gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {yesButton, noButton}); 

contentPane.setLayout(gl_contentPane); 

} 

} 

 