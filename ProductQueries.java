/*ProductQueries class: Establishes a connection to the MYSQL database and generated prepared  

* statements. 

* 

*ProductQueries() constructor: 

*-Defines methods for every product query 

* 

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

  

import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.PreparedStatement; 

import java.sql.ResultSet; 

import java.sql.SQLException; 

import java.util.ArrayList; 

import java.util.List; 

  

import javax.swing.Icon; 

import javax.swing.JDialog; 

import javax.swing.JOptionPane; 

  

  

public class ProductQueries { 

  

//to connect and manage SQL queries 

 

private static final String URL = "jdbc:mysql://localhost:3306/store"; 

//private static final String URL = ("\Program Files\MySQL\MySQL Server 8.0\bin"); 

  

private static final String USERNAME = "root"; 

 

private static final String PASSWORD = "Pizzalover2003"; 

 

private Connection connection = null; 

 

private PreparedStatement selectAllProducts = null; 

private PreparedStatement selectProductByNo = null; 

private PreparedStatement checkProductExistence = null; 

 

private PreparedStatement insertNewProduct = null; 

private PreparedStatement updateProduct = null; 

 

 

 

/*Constructor with hard-coded queries 

 * selectAllProducts: finds all the products from the product table in the database 

 * selectByProductNo: finds the specific product that has THAT product number 

 *  from the product table in the database 

 *  checkProductExistence : finds the number of times the product appears, if zero,  

 *  the product does not exist 

 */  

 

public ProductQueries() { 

 

try { 

 

 

connection = DriverManager.getConnection(URL,USERNAME,PASSWORD); 

 

selectAllProducts = connection.prepareStatement("SELECT * FROM store.product"); 

 

selectProductByNo = connection.prepareStatement("SELECT * FROM store.product WHERE productNo = ?"); 

 

checkProductExistence = connection.prepareStatement( 

            "SELECT COUNT(*) FROM store.product WHERE productNo = ?"); 

 

 

 

}catch (SQLException ex) { 

 

System.err.println("Connection error to DB! " + ex.getMessage()); 

System.exit(1); 

} 

} 

 

 

/* Method getAllProducts creates a list of the Products data type 

 * Creates a resultSet that will contain all the products from the product table in the 

 * database by calling selectAllProducts and executing the query. 

 *  

 * Creates an array list that will contain the products under the values of the strings passed 

 * Ex. it finds the string productNo in the result set, and creates a product with that 

 * column name 

 *  

 * Once done, it closes its connection to the database and returns the  

 *  list of products 

 *  

 */ 

public List<Products> getAllProducts(){ 

 

List<Products> results = null; 

 

ResultSet resultSet = null; 

 

try { 

resultSet = selectAllProducts.executeQuery(); 

results = new ArrayList<>(); 

 

 

while (resultSet.next()) { 

 

results.add(new Products (resultSet.getString("productNo"),  

resultSet.getString("productName"), 

resultSet.getString("productDescription"), 

resultSet.getString("productBrand"), 

resultSet.getString("productImage"), 

resultSet.getInt("quantity"), 

resultSet.getFloat("cost"), 

resultSet.getFloat("price"))); 

 

} 

 

 

 

}catch (SQLException ex) { 

 

System.err.println("Error in DB!" + ex.getMessage()); 

 

}finally { 

 

try { 

 

resultSet.close(); //hay que cerrar la base de datos 

 

}catch (SQLException ex) { 

 

 

ex.printStackTrace(); 

 

} 

} 

 

return results; 

} 

 

 

 

//------------------------------------ 

 

/* Method getProductByNo receives a string product number and  creates a list  

 * of the Products data type. Creates a resultSet that will contain all the 

 *  products from the product table in the database by calling selectProductByNo 

 *  and executing the query. 

 *   

 *   

 *  

 * Creates an array list that will contain the products under the values of the strings passed 

 * Ex. it finds the string productNo in the result set, and creates a product with that 

 * column name 

 *  

 * Once done, it closes its connection to the database and returns the  

 *  list of products 

 *  

 */ 

 

 

 

public List<Products> getProductByNo(String num){ 

 

List<Products> results = null; 

 

ResultSet resultSet = null; 

 

try { 

 

selectProductByNo.setString(1, num); 

resultSet = selectProductByNo.executeQuery(); 

results = new ArrayList<>(); 

 

 

while (resultSet.next()) { 

 

results.add(new Products (resultSet.getString("productNo"),  

resultSet.getString("productName"), 

resultSet.getString("productDescription"), 

resultSet.getString("productBrand"), 

resultSet.getString("productImage"), 

resultSet.getInt("quantity"), 

resultSet.getFloat("cost"), 

resultSet.getFloat("price"))); 

}  

 

}catch (SQLException ex) { 

 

System.err.println("Error in DB! " + ex.getMessage()); 

 

}finally { 

 

try { 

 

resultSet.close(); //hay que cerrar la base de datos 

 

}catch (SQLException ex) { 

 

 

ex.printStackTrace(); 

 

} 

} 

 

return results; 

} 

  

 

//------------------------------------ 

 

/* Method addProduct receives all the attributes needed for a Products data type 

 * and executes the query insertNewProduct, which inserts the values used as parameters. 

 *  

 * insertNewProduct then sets the string, int, and double values of the according string 

 * parameter (Ex. "cost" --- setDouble(aCost)) 

 *  

 * The method returns an int to later verify which message to print 

  

 *  

 */ 

 

 

public int addProduct(String productNum, String productName, String productDescription, 

    String productBrand, String productImage, int quantity, double cost, double price) { 

    int result = 0; 

  

    try { 

        // Use placeholders in your query and set values using setX methods. 

        insertNewProduct = connection.prepareStatement( 

                "INSERT INTO store.product (productNo, productName, productDescription, productBrand, productImage, quantity, cost, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"); 

  

        insertNewProduct.setString(1, productNum); 

        insertNewProduct.setString(2, productName); 

        insertNewProduct.setString(3, productDescription); 

        insertNewProduct.setString(4, productBrand); 

        insertNewProduct.setString(5, productImage); 

        insertNewProduct.setInt(6, quantity); 

        insertNewProduct.setDouble(7, cost); 

        insertNewProduct.setDouble(8, price); 

  

        result = insertNewProduct.executeUpdate(); 

  

    } catch (SQLException ex) { 

        System.err.println("Error in DB! " + ex.getMessage()); 

        // Handle the exception here, e.g., log the error or throw a custom exception. 

    } 

    return result; 

} 

 

 

 

/* Method verifyProductNum receives a string product number and displays an InputDialog 

 * asking the client to enter a product number. 

 *  

 * The method executes the query checkProductExistance with the product No entered. 

 * A result set is created with the product found 

 *  

 * count variable finds the number of times it appears in the resultSet 

 * if the number of times the product was found == 0, 

 * a Dialog Box states the product was not found and disposes of itself. 

 */ 

public int verifyProductNum(String productNo) { 

 

//ASK FOR PRODUCT NUMBER AND VERIFY IT 

 

 

    	int count = 0; 

        // Check if the product exists in the database. 

     try { 

        checkProductExistence.setString(1, productNo); 

        ResultSet resultSet = checkProductExistence.executeQuery(); 

        resultSet.next(); 

         count = resultSet.getInt(1); 

          

        if (count == 0)  

           

            JOptionPane.showMessageDialog(null, "Product not found. Please check the product number.", productNo, JOptionPane.WARNING_MESSAGE);    

            

        } catch (SQLException ex) { 

        System.err.println("Error in DB! " + ex.getMessage()); 

        // Handle the exception here. 

    } 

      

     return count; 

 

} 

 

 

/* Method modifyProduct receives all the attributes needed for a Products data type 

 * and executes the query updateProduct, which updates the current values of the Product  

 * that has the same product Number with the values used as parameters. 

 *  

 * updateProduct then sets the string, int, and double values of the according string 

 * parameter (Ex. "cost" --- setDouble(aCost)) 

 *  

 * The method returns an int: 

 * -If the product was successfully updated, result ==1 , a DialogBox will appear saying so 

 * -If the product was not able to be updated, result ==0, a DialogBox will appear saying so 

 *  

 */ 

 

 

 

public int modifyProduct(String productNo, String productName, String productDescription, 

    String productBrand, String productImage, int quantity, double cost, double price) { 

    int result = 0; 

  

    try { 

         

            // Use placeholders and dynamic values in your update query. 

            updateProduct = connection.prepareStatement( 

                "UPDATE store.product SET productName=?, productDescription=?, productBrand=?, productImage=?, quantity=?, cost=?, price=? WHERE productNo = ?"); 

  

            updateProduct.setString(1, productName); 

            updateProduct.setString(2, productDescription); 

            updateProduct.setString(3, productBrand); 

            updateProduct.setString(4, productImage); 

            updateProduct.setInt(5, quantity); 

            updateProduct.setDouble(6, cost); 

            updateProduct.setDouble(7, price); 

           updateProduct.setString(8, productNo); 

  

            result = updateProduct.executeUpdate(); 

             

            if (result == 1) { 

                JOptionPane.showMessageDialog(null, "Product was successfully updated!"); 

            } else { 

                JOptionPane.showMessageDialog(null, "Unable to update the product. Please check your input."); 

            } 

         

    } catch (SQLException ex) { 

        System.err.println("Error in DB! " + ex.getMessage()); 

        // Handle the exception here. 

    } 

    return result; 

} 

  

 

//Close method closes connection to database  

 

public void close() { 

 

try { 

 

connection.close(); 

}catch (SQLException ex) { 

 

System.err.println("Error in DB!" + ex.getMessage()); 

 

} 

} 

} 

  