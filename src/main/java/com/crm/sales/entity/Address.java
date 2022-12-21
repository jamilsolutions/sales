package com.crm.sales.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Pattern(regexp = "^[0-9]{5}(?:-[0-9]{3})?$")
	@NotBlank(message = "Zip Code is a required field")
	private String zipcode;
	
	@Column 
	@NotNull(message = "Number is a required field")
	private Integer number;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Customer> customer;

}
