package br.feevale.assai.service;

import br.feevale.assai.domain.Product;
import br.feevale.assai.dto.product.CreateProductDto;
import br.feevale.assai.view.product.ProductClientPanelView;
import br.feevale.assai.view.product.ProductStorePanelView;

import java.util.List;

public interface ProductService {

	Product findProductById(Long productId);

	Long addProduct(CreateProductDto createProductDto);

	void deleteProduct(Long productId);

	List<ProductStorePanelView> findActiveProductsByStoreForStore(Long storeId);

	List<ProductClientPanelView> findActiveProductsByStoreForClient(Long storeId);

}
