
-----add PROCEDURE
CREATE DEFINER=`root`@`localhost` PROCEDURE `curd`.`GetAllProducts`()
BEGIN
	SELECT *  FROM `product`;
END


------------- add Save product FUNCTION 

CREATE DEFINER=`root`@`localhost` FUNCTION `curd`.`SaveProduct`( 
    p_name VARCHAR(255),
    p_category VARCHAR(255),
    p_description VARCHAR(255),
    p_code VARCHAR(255),
    p_price  double,
    p_quntity int,
    p_rate int
    
    ) RETURNS int(6)
BEGIN
	
	 declare bus_id varchar(2);   
   INSERT INTO curd.product
( category,  description, code , name, price, quantity, rating)
VALUES(p_category , p_description,p_code,  p_name, p_price, p_quntity, p_rate);  
    SET bus_id = LAST_INSERT_ID() ;
    RETURN bus_id;  
	
END


-------------- edit FUNCTION
CREATE DEFINER=`root`@`localhost` FUNCTION `curd`.`updateProduct`( 
p_id int ,
    p_name VARCHAR(255),
    p_category VARCHAR(255),
    p_description VARCHAR(255),
       p_code VARCHAR(255),
    p_price	 double,
    p_quntity int,
    p_rate int
    
    ) RETURNS int(6)
BEGIN
	
	
	 
   UPDATE `curd`.`product` SET category =p_category ,description=p_description,code=p_code,name=p_name
   ,price=p_price,quantity=p_quntity,rating=p_rate WHERE `id`=p_id;
 
      
    RETURN 1;  
	
END


-------------delete FUNCTION

CREATE DEFINER=`root`@`localhost` FUNCTION `curd`.`deleteProduct`( 
 
    p_id int
    
    ) RETURNS int(6)
BEGIN
	
	
	 
   delete from `curd`.`product`  WHERE id =p_id;
 
      
    RETURN 1;  
	
END
