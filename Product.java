/*Products class: Creates a new data type that will be used in ProductQueries and  

* ProductTableModel 

* 

*Establishes attributes, constructors, setters, and getters 

*/ 

 package edu.pupr.store; 

  

import javax.swing.Icon; 

  

public class Products { 

 

  private String productNo; 

  private String productName; 

  private String productDescription; 

  private String productBrand; 

  private String productImage; 

  private Integer quantity; 

  private Float cost; 

  private Float price; 

  

 

   

  

 

 

//constructors 

public Products() { 

 

} 

  

  

 

  

public Products(String productNo, String productName, String productDescription, String productBrand, 

String productImage, Integer quantity, Float cost, Float price) { 

super(); 

this.productNo = productNo; 

this.productName = productName; 

this.productDescription = productDescription; 

this.productBrand = productBrand; 

this.productImage = productImage; 

this.quantity = quantity; 

this.cost = cost; 

this.price = price; 

} 

  

  

 

//getters and setters 

  

public String getProductNo() { 

return productNo; 

} 

  

  

  

  

public void setProductNo(String productNo) { 

this.productNo = productNo; 

} 

  

  

  

  

public String getProductName() { 

return productName; 

} 

  

  

  

  

public void setProductName(String productName) { 

this.productName = productName; 

} 

  

  

  

  

public String getProductDescription() { 

return productDescription; 

} 

  

  

  

  

public void setProductDescription(String productDescription) { 

this.productDescription = productDescription; 

} 

  

  

  

  

public String getProductBrand() { 

return productBrand; 

} 

  

  

  

  

public void setProductBrand(String productBrand) { 

this.productBrand = productBrand; 

} 

  

  

  

  

public String getProductImage() { 

return productImage; 

} 

  

  

  

  

public void setProductImage(String productImage) { 

this.productImage = productImage; 

} 

  

  

  

  

public Integer getQuantity() { 

return quantity; 

} 

  

  

  

  

public void setQuantity(Integer quantity) { 

this.quantity = quantity; 

} 

  

  

  

  

public Float getCost() { 

return cost; 

} 

  

  

  

  

public void setCost(Float cost) { 

this.cost = cost; 

} 

  

  

  

  

public Float getPrice() { 

return price; 

} 

  

  

  

  

public void setPrice(Float price) { 

this.price = price; 

} 

  

  

 

 

 

 

 

} 

 