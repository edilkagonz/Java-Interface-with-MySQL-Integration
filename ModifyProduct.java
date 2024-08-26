/*ModifyProduct class: Creates a new ModifyProduct frame with its own main function to 

* create the frame and set it to visible. 

* 

*ModifyProduct() constructor: 

*Establishes the frame and its decorations.  

*  

* Creates an instance of a product query and calls upon the Product Query method, verifyProductNum() 

* with the product No entered by the user. If it is entered correctly it will return 1 and the 

* ModifyProductFrame will be shown. If it returns a 0, an error message is shown, if the user 

* selects cancel, it will return null. The while cycle is used to maintain this until the user 

* decides to opt-out and return to the main menu. 

 

*  

* ModifyProductFrame : 

* -A new JPanel is created and decorated 

* -Includes Yes and No buttons. 

* -The product image can be found using JFileChooser after selecting the Browse button. 

*  

* Once the frame is opened, the text fields  

* have all of the information saved under that product number within them. The user 

* can then freely change any of the given values. 

* The Yes button has an actionPerformed() method to create a ProductQuery instance 

* and call upon the ProductQuery method, modifyProduct(), which receives all of  

* the values given by the user. The database connection is then closed. 

*  

*  

* The No button disposes the ModifyProductFrame. 

* 

*/ 

  

  

package edu.pupr.store; 

  

import java.awt.Color; 

import java.awt.Component; 

import java.awt.EventQueue; 

import java.awt.Font; 

import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener; 

import java.io.File; 

import java.sql.PreparedStatement; 

import java.sql.ResultSet; 

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

  

import edu.pupr.authors.Authors; 

  

import javax.swing.JTextField; 

  

public class ModifyProduct extends JFrame { 

  

private static final long serialVersionUID = 1L; 

private JPanel contentPane; 

private JRadioButton yesButton; 

private JRadioButton noButton; 

private final ButtonGroup buttonGroup = new ButtonGroup(); 

private String imagePath;  

private JButton browseButton; 

private JLabel prodNameLbl; 

private JLabel lblProductNum; 

private JLabel lblBrand; 

private JLabel lblQuantity; 

private JLabel lblCost; 

private JLabel lblPrice; 

private JTextField nameTxtField; 

private JTextField numTxtField; 

private JTextField brandTxtField; 

private JTextField quantTxtField; 

private JTextField costTxtField; 

private JTextField priceTxtField; 

private JLabel lblImageName; 

private JLabel lblDescription; 

private JTextField imageTxtField; 

private JTextField descripTxtField; 

 

  

 

 

 

/** 

 * Launch the application. 

 */ 

public static void main(String[] args) { 

EventQueue.invokeLater(new Runnable() { 

public void run() { 

try { 

ModifyProduct frame = new ModifyProduct(); 

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

public ModifyProduct() { 

 

      

 

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

    		setTitle("Modify Product"); 

    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

    		setBounds(100, 100, 840, 719); 

    		 setLocationRelativeTo(null);   

    		contentPane = new JPanel(); 

    		contentPane.setBackground(new Color(128, 0, 0)); 

    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

  

    		setContentPane(contentPane); 

         

JLabel lblNewLabel = new JLabel("Enter the product information: "); 

lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); 

lblNewLabel.setForeground(new Color(255, 255, 255)); 

lblNewLabel.setBackground(new Color(242, 219, 13)); 

lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30)); 

 

prodNameLbl = new JLabel("Product Name:"); 

prodNameLbl.setForeground(new Color(255, 255, 255)); 

prodNameLbl.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblProductNum = new JLabel("Product Num:"); 

lblProductNum.setForeground(Color.WHITE); 

lblProductNum.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblBrand = new JLabel("Brand:"); 

lblBrand.setForeground(Color.WHITE); 

lblBrand.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblQuantity = new JLabel("Quantity:"); 

lblQuantity.setForeground(Color.WHITE); 

lblQuantity.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblCost = new JLabel("Cost:"); 

lblCost.setForeground(Color.WHITE); 

lblCost.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblPrice = new JLabel("Price:"); 

lblPrice.setForeground(Color.WHITE); 

lblPrice.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

nameTxtField = new JTextField(); 

nameTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

nameTxtField.setColumns(10); 

 

numTxtField = new JTextField(); 

numTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

numTxtField.setColumns(10); 

 

brandTxtField = new JTextField(); 

brandTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

brandTxtField.setColumns(10); 

 

quantTxtField = new JTextField(); 

quantTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

quantTxtField.setColumns(10); 

 

costTxtField = new JTextField(); 

costTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

costTxtField.setColumns(10); 

 

priceTxtField = new JTextField(); 

priceTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

priceTxtField.setColumns(10); 

 

lblImageName = new JLabel("Image Name:"); 

lblImageName.setForeground(Color.WHITE); 

lblImageName.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

lblDescription = new JLabel("Description:"); 

lblDescription.setForeground(Color.WHITE); 

lblDescription.setFont(new Font("Serif", Font.PLAIN, 19)); 

 

imageTxtField = new JTextField(); 

imageTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

imageTxtField.setColumns(10); 

 

descripTxtField = new JTextField(); 

descripTxtField.setFont(new Font("Serif", Font.PLAIN, 19)); 

descripTxtField.setColumns(10); 

 

 

//Set all text fields to the information stored for that product  

     List<Products> list = productQueries.getProductByNo(productNo); 

 

Products aProduct = (Products) list.get(0); 

 

nameTxtField.setText(aProduct.getProductName()); 

numTxtField.setText(aProduct.getProductNo()); 

brandTxtField.setText(aProduct.getProductBrand()); 

quantTxtField.setText(aProduct.getQuantity().toString()); 

imageTxtField.setText(aProduct.getProductImage()); 

costTxtField.setText(aProduct.getCost().toString()); 

priceTxtField.setText(aProduct.getPrice().toString()); 

descripTxtField.setText(aProduct.getProductDescription()); 

 

 

 

 

yesButton = new JRadioButton("Modify"); 

yesButton.setBackground(new Color(239, 209, 67)); 

buttonGroup.add(yesButton); 

yesButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 255), null)); 

yesButton.setFont(new Font("Tahoma", Font.PLAIN, 20)); 

yesButton.addActionListener(new ActionListener() { 

    public void actionPerformed(ActionEvent event) { 

        // Create an instance of ProductQueries and establish a database connection. 

        ProductQueries productQueries = new ProductQueries(); 

      

         

        //Create string,int, and double variables for text fields 

         

  

String name = nameTxtField.getText(); 

String number = numTxtField.getText(); 

String brand = brandTxtField.getText(); 

String image = imageTxtField.getText(); 

String description = descripTxtField.getText(); 

 

         

int quantity = Integer.parseInt(quantTxtField.getText()); 

double cost = Double.parseDouble(costTxtField.getText()); 

double price = Double.parseDouble(priceTxtField.getText()); 

 

 

         

         productQueries.modifyProduct(number, name, description,  

           brand, image, quantity, cost, price); 

    

  

        // Close the database connection. 

        productQueries.close(); 

        dispose(); 

    } 

}); 

  

noButton = new JRadioButton("Cancel"); 

noButton.setBackground(new Color(239, 209, 67)); 

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

.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup() 

.addContainerGap(315, Short.MAX_VALUE) 

.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE) 

.addGap(83) 

.addComponent(noButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE) 

.addGap(130)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(120) 

.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE) 

.addContainerGap(130, Short.MAX_VALUE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false) 

.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup() 

.addGap(75) 

.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE) 

.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) 

.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)) 

.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup() 

.addGap(28) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addComponent(lblImageName, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(prodNameLbl, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE) 

.addGap(66) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addComponent(lblProductNum, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblCost, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))))) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addComponent(nameTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(numTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(quantTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(costTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(priceTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(brandTxtField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE) 

.addComponent(imageTxtField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE) 

.addComponent(descripTxtField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)) 

.addContainerGap(102, Short.MAX_VALUE)) 

); 

gl_contentPane.setVerticalGroup( 

gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addContainerGap() 

.addComponent(lblNewLabel) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE) 

.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE) 

.addGap(65) 

.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE) 

.addGap(120)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(52) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(prodNameLbl, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(nameTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.UNRELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(lblProductNum, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(numTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGap(14) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(brandTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(18) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(quantTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)) 

.addGap(18) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(costTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE) 

.addComponent(lblCost, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)) 

.addGap(18) 

.addComponent(priceTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addGroup(gl_contentPane.createSequentialGroup() 

.addGap(132) 

.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(lblImageName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(imageTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.RELATED) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE) 

.addComponent(descripTxtField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)) 

.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE) 

.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE) 

.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE) 

.addComponent(noButton)) 

.addGap(28)))) 

); 

gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {yesButton, noButton}); 

gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {yesButton, noButton}); 

contentPane.setLayout(gl_contentPane); 

        }//end if 

} 

 