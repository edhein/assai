package br.feevale.assai.service.impl;

import br.feevale.assai.domain.Order;
import br.feevale.assai.domain.Product;
import br.feevale.assai.domain.Store;
import br.feevale.assai.dto.order.CreateOrderDto;
import br.feevale.assai.exception.OrderNotFoundException;
import br.feevale.assai.exception.ProductNotFoundException;
import br.feevale.assai.exception.StoreNotFoundException;
import br.feevale.assai.repository.OrderRepository;
import br.feevale.assai.service.OrderService;
import br.feevale.assai.service.ProductService;
import br.feevale.assai.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private StoreService storeService;

	@Autowired
	private ProductService productService;

	private static final Collection<String> ACTIVE_ORDER_STATUS = List.of("NEW");

	@Override
	public List<Order> findActiveOrdersByStore(Long storeId) {
		Store store = storeService.findStoreById(storeId);

		if (store != null) {
			return orderRepository.findOrdersByStoreAndStatusIn(store, ACTIVE_ORDER_STATUS);
		}

		return List.of();
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);

		return true;
	}

	@Override
	public void updateOrderStatus(Long orderId, String status) {
		orderRepository.updateOrderStatus(orderId, status);
	}

	@Override
	public Long addOrder(CreateOrderDto createOrderDto) {
		Order order = new Order();

		Store store = storeService.findStoreById(createOrderDto.getStoreId());
		Product product = productService.findProductById(createOrderDto.getProductId());

		if (store == null) {
			throw new StoreNotFoundException(String.format("Store with id %s not found.", createOrderDto.getStoreId()));
		}

		if (product == null) {
			throw new ProductNotFoundException(String.format("Product with id %s not found.", createOrderDto.getProductId()));
		}

		order.setStatus("NEW");
		order.setClient(null);
		order.setStore(store);
		order.setProduct(product);

		Order persistedOrder = orderRepository.save(order);

		return persistedOrder.getOrderId();
	}

}
