package br.feevale.assai.service;

import br.feevale.assai.domain.Order;
import br.feevale.assai.dto.order.CreateOrderDto;

import java.util.List;

public interface OrderService {

	List<Order> findActiveOrdersByStore(Long storeId);

	boolean deleteOrder(Long orderId);

	void updateOrderStatus(Long orderId, String status);

	Long addOrder(CreateOrderDto createOrderDto);

}
