package br.feevale.assai.service.impl;

import br.feevale.assai.domain.ProductType;
import br.feevale.assai.repository.ProductTypeRepository;
import br.feevale.assai.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductType findProductTypeById(Long productTypeId) {
		return productTypeRepository.findById(productTypeId).orElse(null);
	}

}
