package br.feevale.assai.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductType {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Basic(optional = false)
	private Long productTypeId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Basic(optional = false)
	@NotNull
	@Digits(integer = 6, fraction = 2)
	private BigDecimal price;

	@Basic(optional = false)
	@NotNull
	private Integer prepareTime;

	@JoinColumn(name = "storeId", referencedColumnName = "storeId")
	@ManyToOne(optional = false)
	private Store store;

}
