/*Menu class: Establishes the background, size and closing operations of the MenuFrame 

*that is created in LoginFrame.java. Creates two JMenus, File and Help.  

* 

*Adds a MenuBar to the JMenu named File with options for AddProduct, 

*ModifyProduct, DisplayProduct, ProductReport, and Exit. Adds a MenuBar to the JMenu named 

*Help with the options for Help Contents and About.  

* 

*Each addition to the File Menu 

* has its own actionListener function that calls the private methods written near the end.  

* Those functions call upon the constructors of each Frame class and sets them to be visible. 

*  

* Each addition to the Help Menu has its own actionListener function that calls upon the 

* private methods stated near the end. 

* 

* 

*/ 

  

  

  

package edu.pupr.store;   

  

import javax.swing.*;  

  

import java.awt.*;  

  

import java.awt.BorderLayout;   

  

  

  

import java.awt.EventQueue;  

  

  

  

import javax.swing.border.EmptyBorder;  

  

  

  

import java.awt.Color;   

  

  

  

import java.awt.event.ActionListener; 

import java.sql.PreparedStatement; 

import java.sql.ResultSet; 

import java.util.HashMap;  

  

import java.awt.event.ActionEvent;   

  

  

  

public class Menu extends JFrame{   

  

    private static final long serialVersionUID = 1L;   

    private JPanel contentPane;   

  

    public Menu() {   

  

        setBackground(new Color(0xAE0001));   

  

        setTitle("Menu");   

  

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

  

        setBounds(100, 100, 599, 542);   

  

        setLocationRelativeTo(null);   

  

        JMenuBar menuBar = new JMenuBar();   

  

        menuBar.setBackground(new Color(0x2A623D));   

  

  

        setJMenuBar(menuBar);   

  

  

  

   

        JMenu mnNewMenu = new JMenu("File");   

  

        mnNewMenu.setBackground(new Color(128, 128, 0));  

  

  

  

        menuBar.add(mnNewMenu);   

  

  

        JMenuItem mntmNewMenuItem = new JMenuItem("Add Product");   

        mntmNewMenuItem.addActionListener(new ActionListener() { 

        	public void actionPerformed(ActionEvent event) { 

        		 

        		showAddProduct(); 

  

        	} 

        }); 

  

  

  

        mnNewMenu.add(mntmNewMenuItem);   

  

  

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modify Product");   

        mntmNewMenuItem_1.addActionListener(new ActionListener() { 

        	public void actionPerformed(ActionEvent e) { 

        		 

        		showModifyProduct(); 

        		 

        		 

        	} 

        }); 

  

  

  

        mnNewMenu.add(mntmNewMenuItem_1);   

  

  

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Display Product");   

        mntmNewMenuItem_2.addActionListener(new ActionListener() { 

        	public void actionPerformed(ActionEvent e) { 

        		 

        		showDisplayProduct(); 

        	} 

        }); 

  

  

  

        mnNewMenu.add(mntmNewMenuItem_2);   

  

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Products Report");   

        mntmNewMenuItem_3.addActionListener(new ActionListener() { 

        	public void actionPerformed(ActionEvent e) { 

        		 

        		showProductReport(); 

        	} 

        }); 

  

  

  

        mnNewMenu.add(mntmNewMenuItem_3);   

  

  

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");   

  

  

  

        mntmNewMenuItem_4.addActionListener(new ActionListener() {   

  

  

  

            public void actionPerformed(ActionEvent e) {   

  

  

  

                System.exit(0);   

  

  

  

            }   

  

  

  

        });   

  

  

  

        mnNewMenu.add(mntmNewMenuItem_4);   

  

        JMenu mnNewMenu_1 = new JMenu("Help");   

  

        mnNewMenu_1.setBackground(new Color(128, 128, 0));  

  

  

  

        menuBar.add(mnNewMenu_1);   

  

  

  

   

  

  

  

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Help Contents");  

  

        mntmNewMenuItem_5.addActionListener(new ActionListener() {  

  

            public void actionPerformed(ActionEvent e) {  

  

                showHelpContents();  

  

            }  

  

        });  

  

        mnNewMenu_1.add(mntmNewMenuItem_5);  

  

  

  

  

  

   

  

  

  

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("About");   

  

        mntmNewMenuItem_6.addActionListener(new ActionListener() {  

  

        	public void actionPerformed(ActionEvent e) {  

  

        		showAbout();  

  

        	}  

  

        });  

  

  

  

        mnNewMenu_1.add(mntmNewMenuItem_6);   

  

  

  

        contentPane = new JPanel();   

  

  

  

        contentPane.setBackground(new Color(0xD3A625));   

  

  

  

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));   

  

  

  

   

  

  

  

        setContentPane(contentPane);   

  

  

  

    }  

    //--------------------------METHODS--------------------------- 

     

    //ADD PRODUCT 

  

    private void showAddProduct() {  

  

    new AddProduct().setVisible(true);    

  

    } 

     

    //MODIFY PRODUCT 

     

    private void showModifyProduct() {  

    	 

    new ModifyProduct().setVisible(true); 

  

    

    } 

     

     

    //DISPLAY PRODUCT 

     

    private void showDisplayProduct() {  

  

new DisplayProduct().setVisible(true); 

  

    } 

     

    //PRODUCTS REPORT 

     

    private void showProductReport() {  

  

  

        new ProductReport().setVisible(true);    

  

  

    } 

     

    //HELP 

     

    /* Function that removes all content from the MenuFrame content panel 

     * and adds a new one to display the questions and answers 

     *  

     */ 

    private void showHelpContents() {  

  

        contentPane.removeAll();  

  

        contentPane.setLayout(new BorderLayout());  

  

  

  

        // Sample FAQ categories and questions  

  

        String[] categories = {"Product Management", "General"};  

  

        String[][] questions = {  

  

        		{"How do I add a new product?", "How do I modify an existing product?"},  

  

                {"What is the purpose of this application?", "How do I exit the application?", "For more information:"}  

  

                  

  

                  

  

        };  

  

  

  

        JPanel faqPanel = new JPanel();  

  

        faqPanel.setLayout(new BoxLayout(faqPanel, BoxLayout.Y_AXIS));  

  

  

  

        // Add categories and questions to the faqPanel  

  

        for (int i = 0; i < categories.length; i++) {  

  

            JLabel categoryLabel = new JLabel(categories[i]);  

  

            categoryLabel.setFont(new Font("Arial", Font.BOLD, 14));  

  

            faqPanel.add(categoryLabel);  

  

  

  

            for (String question : questions[i]) {  

  

                JLabel questionLabel = new JLabel(question);  

  

                faqPanel.add(questionLabel);  

  

  

  

                JTextArea answerTextArea = new JTextArea(getAnswerForQuestion(question));  

  

                answerTextArea.setEditable(false);  

  

                answerTextArea.setLineWrap(true);  

  

                answerTextArea.setWrapStyleWord(true);  

  

                faqPanel.add(answerTextArea);  

  

            }  

  

        }  

  

  

  

        JScrollPane faqScrollPane = new JScrollPane(faqPanel);  

  

        contentPane.add(faqScrollPane, BorderLayout.CENTER);  

  

  

  

        contentPane.revalidate();  

  

        contentPane.repaint();  

  

    }  

  

/* 

  * Function that receives a question and displays the answer. This function is called upon in the 

  * previous method to create a JTextArea 

  */ 

  

    private String getAnswerForQuestion(String question) {  

  

        // Sample data: You can replace this with your actual data retrieval logic  

  

        HashMap<String, String> answers = new HashMap<>();  

  

        answers.put("What is the purpose of this application?", "The purpose is to manage products.");  

  

        answers.put("How do I exit the application?", "You can exit by selecting 'Exit' from the File menu.");  

  

        answers.put("How do I add a new product?", "To add a new product, select 'Add Product' from the File menu.");  

  

        answers.put("How do I modify an existing product?", "To modify a product, select 'Modify Product' from the File menu.");  

  

        answers.put("For more information:", "Contact: \nProfesor Carlos De La Torre: cdelatorre@pupr.edu "  

  

        		+ "\nMariana Alvarez: alvarez_121229@students.pupr.edu \nDaniel Montes: montes@students.pupr.edu \nEdilka Gonzalez: gonzalez@students.pupr.edu  ");  

  

  

  

        // Retrieve the answer for the given question  

  

        return answers.getOrDefault(question, "Answer not available");  

  

    }  

  

     

    //ABOUT 

     

    /*Function that removes all content from the MenuFrame content panel 

     * and adds a new one to display a JTextArea with information on every 

     * option in the File Menu. It also displays team members' information and an additional  

     * gif to decorate with. 

     *  

     */ 

  

    private void showAbout() {  

  

        contentPane.removeAll();  

  

        contentPane.setLayout(new BorderLayout());  

  

  

  

        JTextArea textArea = new JTextArea("Product Store:"  

  

        		+ "\n The following store is to modify, add,\n" 

        		+ "" 

        		+ " and show products from a data base."  

  

        		+ "\n Our team members are:"  

  

        		+ "\n Mariana Alvarez: alvarez_121229@students.pupr.edu \n Daniel Montes: montes_142281@students.pupr.edu \n Edilka Gonzalez: gonzalez_146105@students.pupr.edu  ");  

  

          

  

        textArea.setEditable(false);  

  

        textArea.setFont(new Font("Arial", Font.PLAIN, 22)); // Adjust font and size  

  

        

  

        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);  

  

        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);  

  

  

  

        JPanel centerPanel = new JPanel(new BorderLayout());  

  

        centerPanel.add(textArea, BorderLayout.CENTER);  

  

          

  

        textArea.setEditable(false);  

  

        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);  

  

  

  

        // Load the GIF  

  

        ImageIcon icon = createImage("golden_snitch.gif", 200, 200);  

  

        JLabel label = new JLabel(icon);  

  

        contentPane.add(label, BorderLayout.SOUTH);  

  

  

  

        contentPane.revalidate();  

  

        contentPane.repaint();  

  

    }  

  

    private ImageIcon createImage(String path, int width, int height) {  

  

        java.net.URL imgURL = getClass().getResource(path);  

  

        if (imgURL != null) {  

  

            ImageIcon originalIcon = new ImageIcon(imgURL);  

  

            Image image = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);  

  

            return new ImageIcon(image);  

  

        } else {  

  

            System.err.println("Couldn't find file: " + path);  

  

            return null;  

  

        }  

  

    }  

  

}   

 