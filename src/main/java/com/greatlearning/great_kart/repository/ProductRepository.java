package com.greatlearning.great_kart.repository;

import com.greatlearning.great_kart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Query is build by methode name
    Optional<Product> findByName(String name);

    @Query("Select * from Product where name = :name and price = :price")
    Product someCustomQuery(@Param("name") String name, @Param("price") String price);
}
