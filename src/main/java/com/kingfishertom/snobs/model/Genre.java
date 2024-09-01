package com.kingfishertom.snobs.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedEntity
public class Genre {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private boolean enabled;

}