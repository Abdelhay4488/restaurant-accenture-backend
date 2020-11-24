package de.accenture.restaurant.repository;

import de.accenture.restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    Product findByTitle(String title);
}
