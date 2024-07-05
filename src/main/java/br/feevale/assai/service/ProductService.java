package br.feevale.assai.service;

import br.feevale.assai.domain.Product;
import br.feevale.assai.dto.product.CreateProductDto;

public interface ProductService {

	Product findProductById(Long productId);

	Long addProduct(CreateProductDto createProductDto);

}
