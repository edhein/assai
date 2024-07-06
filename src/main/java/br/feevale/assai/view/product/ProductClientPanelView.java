package br.feevale.assai.view.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ProductClientPanelView {

	Long getProductId();

	String getProductName();

	LocalDateTime getStartDate();

	Integer getPrepareTime();

	BigDecimal getPrice();

	String getProductTypeName();

}
