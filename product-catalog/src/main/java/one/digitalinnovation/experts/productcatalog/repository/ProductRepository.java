package one.digitalinnovation.experts.productcatalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.experts.productcatalog.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    
    
}
