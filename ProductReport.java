/*ProductReport class: Creates a new ProductReport frame with its own main function to 

* create the frame and set it to visible. 

* 

*ProductReport() constructor: 

*Establishes the frame and its decorations.  

*  

* A ProductQuery instance is created and calls upon the ProductQuery method,  

* getAllProducts(), which searches for all the products 

* and returns a list of them. The database connection is then closed. 

* 

* ProductReportFrame : 

* -A new JPanel is created and decorated 

* -A JTable is created with a JTabelModel that contains the list returned  

* by the ProductQuery method. 

* 

*/ 

  

  

  

  

package edu.pupr.store; 

  

import java.awt.EventQueue; 

  

import javax.swing.JFrame; 

import javax.swing.JPanel; 

import javax.swing.JScrollPane; 

import javax.swing.border.EmptyBorder; 

import javax.swing.GroupLayout; 

import javax.swing.GroupLayout.Alignment; 

import java.awt.Color; 

import javax.swing.JLabel; 

import java.awt.Font; 

import java.util.List; 

  

import javax.swing.JTable; 

import javax.swing.table.DefaultTableModel; 

  

import java.awt.Component; 

import java.awt.event.ActionEvent; 

import java.awt.event.ActionListener; 

import java.io.File; 

import javax.swing.ButtonGroup; 

import javax.swing.ImageIcon; 

import javax.swing.JButton; 

import javax.swing.JFileChooser; 

import javax.swing.JOptionPane; 

import javax.swing.JRadioButton; 

import javax.swing.SwingConstants; 

import javax.swing.LayoutStyle.ComponentPlacement; 

import javax.swing.border.BevelBorder; 

import javax.swing.border.EtchedBorder; 

import javax.swing.border.SoftBevelBorder; 

import javax.swing.JTextArea; 

  

  

  

public class ProductReport extends JFrame { 

    

private static final long serialVersionUID = 1L; 

private JPanel contentPane; 

    private JTable tableData; 

    private List<Products> productList; 

  

    public static void main(String[] args) { 

        EventQueue.invokeLater(new Runnable() { 

            public void run() { 

                try { 

                    ProductReport frame = new ProductReport(); 

                    frame.setVisible(true); 

                } catch (Exception e) { 

                    e.printStackTrace(); 

                } 

            } 

        }); 

    }  

  

    public ProductReport() { 

  

     

    	setForeground(new Color(255, 255, 255)); 

     

        setTitle("Product Report"); 

     

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        setBounds(100, 100, 1084, 290); 

        contentPane = new JPanel(); 

        contentPane.setBackground(new Color(5, 112, 16)); 

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 

        setContentPane(contentPane); 

     

    

     

        JLabel lblNewLabel = new JLabel("Store database information: "); 

        lblNewLabel.setForeground(new Color(255, 255, 255)); 

        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 28)); 

  

        tableData = new JTable(); 

        tableData.setAlignmentY(Component.TOP_ALIGNMENT); 

        tableData.setBackground(new Color(116, 197, 245)); 

        tableData.setFont(new Font("Serif", Font.PLAIN, 13)); 

  

        // Fetch product data from your database using your ProductQueries class 

        ProductQueries productQueries = new ProductQueries(); 

        productList = productQueries.getAllProducts(); 

        productQueries.close(); 

  

        // Create a custom table model and set it in the JTable 

        ProductTableModel tableModel = new ProductTableModel(productList); 

        tableData.setModel(tableModel); 

  

         

        for (int i = 0; i < tableModel.getColumnCount(); i++) { 

            tableData.getColumnModel().getColumn(i).setPreferredWidth(tableModel.getPreferredWidth(i)); 

        } 

  

        JScrollPane scrollPane = new JScrollPane(tableData); 

        scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 

        scrollPane.setBackground(new Color(5, 112, 16)); 

  

        GroupLayout gl_contentPane = new GroupLayout(contentPane); 

        gl_contentPane.setHorizontalGroup( 

        	gl_contentPane.createParallelGroup(Alignment.LEADING) 

        		.addGroup(gl_contentPane.createSequentialGroup() 

        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING) 

        				.addGroup(gl_contentPane.createSequentialGroup() 

        					.addGap(363) 

        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)) 

        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)) 

        			.addContainerGap()) 

        ); 

        gl_contentPane.setVerticalGroup( 

        	gl_contentPane.createParallelGroup(Alignment.LEADING) 

        		.addGroup(gl_contentPane.createSequentialGroup() 

        			.addGap(26) 

        			.addComponent(lblNewLabel) 

        			.addGap(52) 

        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE) 

        			.addContainerGap(56, Short.MAX_VALUE)) 

        ); 

  

        contentPane.setLayout(gl_contentPane); 

    } 

     

} 

 