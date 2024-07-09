package br.feevale.assai.controller;

import br.feevale.assai.dto.product.CreateProductDto;
import br.feevale.assai.service.OrderService;
import br.feevale.assai.service.ProductService;
import br.feevale.assai.service.ProductTypeService;
import br.feevale.assai.view.product.ProductStorePanelView;
import br.feevale.assai.view.product_type.ProductTypeStorePanelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductTypeService productTypeService;

	@ResponseStatus(CREATED)
	@PostMapping("/product")
	public ResponseEntity<Long> addProduct(@RequestBody CreateProductDto createProductDto) {
		final Long productId = productService.addProduct(createProductDto);

		return new ResponseEntity<>(productId, CREATED);
	}

	@ResponseStatus(OK)
	@DeleteMapping("/product/{productId}")
	public ResponseEntity deleteProduct(@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);

		return ResponseEntity.ok().build();
	}

	@ResponseStatus(OK)
	@PutMapping("/order/{orderId}")
	public ResponseEntity updateOrder(@PathVariable("orderId") Long orderId, @RequestBody String status) {
		orderService.updateOrderStatus(orderId, status);

		return ResponseEntity.ok().build();
	}

	@ResponseStatus(OK)
	@GetMapping("/products/{storeId}")
	public ResponseEntity<List<ProductStorePanelView>> getActiveProductsByStore(@PathVariable("storeId") Long storeId) {
		List<ProductStorePanelView> products = productService.findActiveProductsByStoreForStore(storeId);

		return ResponseEntity.ok(products);
	}

	@ResponseStatus(OK)
	@GetMapping("product-types/{storeId}")
	public ResponseEntity<List<ProductTypeStorePanelView>> getProductTypesByStore(@PathVariable("storeId") Long storeId) {
		List<ProductTypeStorePanelView> productTypes = productTypeService.findProductTypesByStoreForStore(storeId);

		return ResponseEntity.ok(productTypes);
	}

}
