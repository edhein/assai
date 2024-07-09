package br.feevale.assai.repository;

import br.feevale.assai.domain.ProductType;
import br.feevale.assai.view.product_type.ProductTypeStorePanelView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    @Query(value = "SELECT " +
            "pt.product_type_id AS product_type_id, " +
            "pt.name AS name, " +
            "pt.price AS price, " +
            "pt.prepare_time AS prepare_time " +
            "FROM product_type AS pt " +
            "WHERE pt.store_id = :storeId", nativeQuery = true)
    List<ProductTypeStorePanelView> findProductTypesByStoreForStore(@Param("storeId") Long storeId);

}
