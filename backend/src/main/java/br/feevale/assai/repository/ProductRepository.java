package br.feevale.assai.repository;

import br.feevale.assai.domain.Product;
import br.feevale.assai.view.product.ProductClientPanelView;
import br.feevale.assai.view.product.ProductStorePanelView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT " +
		"p.product_id AS product_id, " +
		"p.name AS product_name, " +
		"p.start_date AS start_date, " +
		"pt.prepare_time AS prepare_time, " +
		"pt.price AS price, " +
		"pt.name AS product_type_name, " +
		"o.client_id AS client_id, " +
		"c.name AS client_name, " +
		"c.telephone AS client_telephone, " +
		"o.status AS order_status," +
		"o.order_id AS order_id " +
		"FROM product AS p " +
		"JOIN product_type AS pt ON pt.product_type_id = p.product_type_id " +
		"LEFT JOIN \"order\" AS o ON o.product_id = p.product_id " +
		"LEFT JOIN client AS c ON o.client_id = c.client_id " +
		"WHERE pt.store_id = :storeId " +
		"AND (o.status = 'NEW' OR o.status IS NULL)", nativeQuery = true)
	List<ProductStorePanelView> findActiveProductsByStoreForStore(@Param("storeId") Long storeId);

	@Query(value = "SELECT " +
		"p.product_id AS product_id, " +
		"p.name AS product_name, " +
		"p.start_date AS start_date, " +
		"pt.prepare_time AS prepare_time, " +
		"pt.price AS price, " +
		"pt.name AS product_type_name, " +
		"o.order_id AS order_id " +
		"FROM product AS p " +
		"JOIN product_type AS pt ON pt.product_type_id = p.product_type_id " +
		"LEFT JOIN \"order\" AS o ON o.product_id = p.product_id " +
		"WHERE pt.store_id = :storeId " +
		"AND o.status IS NULL", nativeQuery = true)
	List<ProductClientPanelView> findActiveProductsByStoreForClient(@Param("storeId") Long storeId);

}
