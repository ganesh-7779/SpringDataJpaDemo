package com.springDataJPA.springDataJpaDemo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The @Embeddable annotation in JPA is used to specify that a class will be embedded into another entity.
 * This means that the fields of the Guardian class (name, email, mobile) will be stored directly within the Student table in the database.
 * The @AttributeOverrides annotation allows you to customize the column names and properties of the embedded object when it's embedded into an entity.
 */
@Embeddable  
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
	@AttributeOverride(name ="name", column=@Column(name ="guardian_name")),
	@AttributeOverride(name ="email", column=@Column(name ="guardian_email")),
	@AttributeOverride(name ="mobile", column=@Column(name ="guardian_mobile"))
	})
@Builder
public class Guardian {	
	private String name;
	private String email;
	private String mobile; 

}
