package br.feevale.assai.view.product_type;

import java.math.BigDecimal;

public interface ProductTypeStorePanelView {

    Long getProductTypeId();

    String getName();

    BigDecimal getPrice();

    Integer getPrepareTime();

}
