package br.feevale.assai.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
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
public class Store {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Basic(optional = false)
	private Long storeId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Basic(optional = false)
	@NotNull
	private Double longitude;

	private Double latitude;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String street;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String city;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String number;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String cnpj;

}
