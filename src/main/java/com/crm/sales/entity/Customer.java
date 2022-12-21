package com.crm.sales.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "Customer",
		uniqueConstraints = {
		   @UniqueConstraint(columnNames = "name")
		}
)
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank(message = "Name is a required field")
	private String name;
	
	@Column 
	@NotBlank(message = "Age is a required field")
	private String age;

	@Column
	private Date registration;

	@Column
	private Date lastUpdate;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	


}
