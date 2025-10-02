package sg.edu.nus.team6_springbootca.repository;

import sg.edu.nus.team6_springbootca.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // 根据商品名称查找（精确匹配）
    Optional<Product> findByName(String name);

    // 根据商品名称模糊查找（忽略大小写）
    List<Product> findByNameContainingIgnoreCase(String name);

    // 查找价格低于某个值的商品
    List<Product> findByPriceLessThan(BigDecimal price);

    // 查询有库存的商品
    @Query("SELECT p FROM Product p WHERE p.stockQuantity > 0")
    List<Product> findAvailableProducts();
}
