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

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Basic(optional = false)
	private Long orderId;

	@JoinColumn(name = "clientId", referencedColumnName = "clientId")
	@ManyToOne(optional = false)
	private Client client;

	@JoinColumn(name = "productId", referencedColumnName = "productId")
	@ManyToOne(optional = false)
	private Product product;

	@JoinColumn(name = "storeId", referencedColumnName = "storeId")
	@ManyToOne(optional = false)
	private Store store;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String status;

}
