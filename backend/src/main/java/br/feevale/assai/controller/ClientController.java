package br.feevale.assai.controller;

import br.feevale.assai.dto.order.CreateOrderDto;
import br.feevale.assai.service.OrderService;
import br.feevale.assai.service.ProductService;
import br.feevale.assai.view.product.ProductClientPanelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@ResponseStatus(OK)
	@GetMapping("/products/{storeId}")
	public ResponseEntity<List<ProductClientPanelView>> getActiveProductsByStore(@PathVariable("storeId") Long storeId) {
		List<ProductClientPanelView> products = productService.findActiveProductsByStoreForClient(storeId);

		return ResponseEntity.ok(products);
	}

	@ResponseStatus(OK)
	@PostMapping("/order")
	public ResponseEntity<Long> createOrder(@RequestBody CreateOrderDto createOrderDto) {
		final Long orderId = orderService.addOrder(createOrderDto);

		return ResponseEntity.ok(orderId);
	}

	@ResponseStatus(OK)
	@DeleteMapping("/order/{orderId}")
	public ResponseEntity deleteOrder(@PathVariable("orderId") Long orderId) {
		orderService.deleteOrder(orderId);

		return ResponseEntity.ok().build();
	}

}
