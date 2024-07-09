package br.feevale.assai.repository;

import br.feevale.assai.domain.Client;
import br.feevale.assai.domain.Order;
import br.feevale.assai.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findOrdersByStoreAndStatusIn(Store store, Collection<String> status);

	List<Order> findOrdersByClient(Client client);

	@Transactional
	@Modifying
	@Query(value = "UPDATE \"order\" " +
			"SET status = :status " +
			"WHERE order_id = :orderId", nativeQuery = true)
	void updateOrderStatus(@Param("orderId") Long orderId, @Param("status") String status);

}
