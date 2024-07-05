package br.feevale.assai.service.impl;

import br.feevale.assai.domain.Product;
import br.feevale.assai.domain.ProductType;
import br.feevale.assai.dto.product.CreateProductDto;
import br.feevale.assai.exception.ProductTypeNotFoundException;
import br.feevale.assai.repository.ProductRepository;
import br.feevale.assai.service.ProductService;
import br.feevale.assai.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeService productTypeService;

	@Override
	public Product findProductById(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Long addProduct(CreateProductDto createProductDto) {
		ProductType productType = productTypeService.findProductTypeById(createProductDto.getProductTypeId());

		if (productType == null) {
			throw new ProductTypeNotFoundException(String.format("Product type %s not found.", createProductDto.getProductTypeId()));
		}

		Product product = new Product();

		product.setName(createProductDto.getName());
		product.setProductType(productType);
		product.setStartDate(LocalDateTime.now());

		Product persistedProduct = productRepository.save(product);

		return persistedProduct.getProductId();
	}

}
