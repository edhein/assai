package br.feevale.assai.service.impl;

import br.feevale.assai.domain.Store;
import br.feevale.assai.repository.StoreRepository;
import br.feevale.assai.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store findStoreById(Long storeId) {
		return storeRepository.findById(storeId).orElse(null);
	}

}
