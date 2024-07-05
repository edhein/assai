package br.feevale.assai.repository;

import br.feevale.assai.domain.Client;
import br.feevale.assai.domain.Order;
import br.feevale.assai.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findOrdersByStoreAndStatusIn(Store store, Collection<String> status);

	List<Order> findOrdersByClient(Client client);

}
