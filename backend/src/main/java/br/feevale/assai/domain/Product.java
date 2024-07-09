package br.feevale.assai.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Basic(optional = false)
	private Long productId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@JoinColumn(name = "productTypeId", referencedColumnName = "productTypeId")
	@ManyToOne(optional = false)
	private ProductType productType;

	@Basic(optional = false)
	@NotNull
	private LocalDateTime startDate;

}
