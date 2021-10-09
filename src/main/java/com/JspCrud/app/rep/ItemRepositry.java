package com.JspCrud.app.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JspCrud.app.model.Item;

@Repository
public interface ItemRepositry extends JpaRepository<Item, Integer> {

	@Query(value = "CALL curd.GetAllProducts();", nativeQuery = true)
	List<Item> getItems();

	@Query(nativeQuery = true, value = "SELECT curd.SaveProduct(:p_name,:p_category,:p_description,:p_code,:p_price,:p_quntity,:p_rate)")
	String addProduct(@Param("p_name") String name, @Param("p_category") String cat, @Param("p_description") String dis,
			@Param("p_code") String code, @Param("p_price") double price, @Param("p_quntity") int quntity,
			@Param("p_rate") int rate);

	@Query(nativeQuery = true, value = "SELECT curd.updateProduct(:p_id,:p_name,:p_category,:p_description,:p_code,:p_price,:p_quntity,:p_rate) ")
	String editProduct(@Param("p_name") String name, @Param("p_category") String cat,
			@Param("p_description") String dis, @Param("p_code") String code, @Param("p_price") double price,
			@Param("p_quntity") int quntity, @Param("p_rate") int rate, @Param("p_id") int id);

	@Query(nativeQuery = true, value = "SELECT curd.deleteProduct(:p_id)")
	String deleteProduct(@Param("p_id") int id);
}
