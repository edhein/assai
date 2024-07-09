package br.feevale.assai.service;

import br.feevale.assai.domain.ProductType;
import br.feevale.assai.view.product_type.ProductTypeStorePanelView;

import java.util.List;

public interface ProductTypeService {

	ProductType findProductTypeById(Long productTypeId);

	List<ProductTypeStorePanelView> findProductTypesByStoreForStore(Long storeId);

}
