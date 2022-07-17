package com.clintonbeardsley.guitarpedalapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Schema (defaultValue = "{\"name\": \"string\", \"active\": true}")
@NoArgsConstructor
@Table (name = "manufacturers", schema = "guitarpedalapi")
public class Manufacturer {

	@Id
	@Getter
	@Setter
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "manufacturer_id", nullable = false, unique = true)
	@Schema (name = "id", type = "Integer", description = "Primary key of manufacturer (automatically generated).")
	private Integer id;

	@Getter
	@Setter
	@NotBlank
	@Column (name = "manufacturer_name", nullable = false, unique = true)
	@Schema (name = "name", type = "String", description = "Name of manufacturer.")
	private String name;

	@Getter
	@Setter
	@NotBlank
	@Column (name = "active", nullable = false)
	@Schema (name = "active", type = "Boolean", description = "Is manufacturer still active?")
	private Boolean active;

	@Getter
	@Setter
	@CreationTimestamp
	@Column (name = "create_date", nullable = false)
	@Schema (name = "createTimestamp", type = "LocalDateTime", description = "Timestamp from when manufacturer was first created (automatically generated).")
	private LocalDateTime createTimestamp;

	@Getter
	@Setter
	@UpdateTimestamp
	@Column (name = "last_update_date", nullable = false)
	@Schema (name = "lastUpdateTimestamp", type = "LocalDateTime", description = "Timestamp from when manufacturer was last updated (automatically generated).")
	private LocalDateTime lastUpdateTimestamp;

}