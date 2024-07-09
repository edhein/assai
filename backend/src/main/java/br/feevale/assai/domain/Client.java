package br.feevale.assai.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Client {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Basic(optional = false)
	private Long clientId;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String cpf;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String telephone;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	private String email;

	private String password;

}
