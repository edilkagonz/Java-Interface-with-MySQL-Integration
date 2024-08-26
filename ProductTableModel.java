/*ProductTableModel class: Creates the list information necessary for the JTable needed  

* in ProductsReport frame. 

*  

*  

*  

-Creates a string array of column names, including the two additional columns  

Total Cost and Total Price. 

-Creates a List of the Products data type named productList. 

  

-Establishes a column and row count based on the the column names string array  

and productList size. 

  

-Implements get methods to extract the value from a row in the table and get the column 

name 

* 

*/ 

  

  

package edu.pupr.store; 

  

import javax.swing.table.AbstractTableModel; 

import java.util.List; 

  

public class ProductTableModel extends AbstractTableModel { 

     

private static final long serialVersionUID = 1L; 

private List<Products> productList; 

    private String[] columnNames = { 

        "Product No", "Product Name", "Product Description", 

        "Product Brand", "Product Image", "Quantity", 

        "Cost", "Price", "Total Cost" , "Total Price" 

    }; 

  

    public ProductTableModel(List<Products> productList) { 

        this.productList = productList; 

    } 

  

    @Override 

    public int getRowCount() { 

        return productList.size(); 

    } 

  

    @Override 

    public int getColumnCount() { 

        return columnNames.length; 

    } 

  

    /* 

     * getValueAt() receives the row and column indexes to extract the attributes of the 

     * Products object in that row, switching between columns to be able to display everything 

     *  

     * The values for total cost and total price are calculated by formatting 

     * the cost and price attributes and multiplying them by the quantity 

     * (case 8 and 9) 

     *  

     */ 

    @Override 

    public Object getValueAt(int rowIndex, int columnIndex) { 

        Products product = productList.get(rowIndex); 

         

  

        // Format the cost and price with two decimal places 

           String formattedCost = String.format("%.2f", product.getCost()); 

           String formattedPrice = String.format("%.2f", product.getPrice()); 

  

       	//Format the total cost and total price 

       	Float totalCost = (product.getCost()* product.getQuantity()); 

       	Float totalPrice = (product.getPrice()* product.getQuantity()); 

       	 

        String formattedTCost = String.format("%.2f", totalCost); 

        String formattedTPrice = String.format("%.2f", totalPrice); 

       	 

        switch (columnIndex) { 

            case 0: 

                return product.getProductNo(); 

            case 1: 

                return product.getProductName(); 

            case 2: 

                return product.getProductDescription(); 

            case 3: 

                return product.getProductBrand(); 

            case 4: 

                return product.getProductImage(); 

            case 5: 

                return product.getQuantity(); 

            case 6: 

                return formattedCost; 

            case 7: 

                return formattedPrice; 

            case 8: 

            	return formattedTCost; 

            	 

            case 9:  

            	return formattedTPrice; 

            default: 

                return null; 

        } 

    } 

  

    @Override 

    public String getColumnName(int columnIndex) { 

        return columnNames[columnIndex]; 

    } 

     

     

    /* 

     * getPreferredWidth() receives the column index to know which column will have the  

     * desired width, which have been hand-chosen. 

     *  

     */ 

     

    public int getPreferredWidth(int columnIndex) { 

        switch (columnIndex) { 

            case 0: 

                return 70; // Adjust the width of the first column 

            case 1: 

                return 80;  

            case 2: 

            	return 150; 

            case 3: 

            	return 100; 

            case 4: 

            	return 180; 

            case 5: 

            	return 30; 

            case 6: 

            	return 30; 

            case 7: 

            	return 30; 

            case 8: 

            	return 50; 

            case 9: 

            	return 50; 

            	 

            default: 

                return 100; // Default width 

        } 

    } 

} 

 