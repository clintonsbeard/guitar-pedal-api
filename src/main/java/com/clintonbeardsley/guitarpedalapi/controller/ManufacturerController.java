package com.clintonbeardsley.guitarpedalapi.controller;

import com.clintonbeardsley.guitarpedalapi.model.Manufacturer;
import com.clintonbeardsley.guitarpedalapi.service.ManufacturerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.exception.SQLGrammarException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag (name = "Manufacturer API")
@RequestMapping ("/manufacturer")
public class ManufacturerController {

	private final ManufacturerService manufacturerService;

	/**
	 * API endpoint for creating a new manufacturer and persisting them in the database.
	 *
	 * @param manufacturer Desired manufacturer in JSON format.
	 * @return Manufacturer in JSON format after being persisted (includes primary key).
	 */

	@PostMapping ("/create")
	@Operation (summary = "Create new manufacturer and persist them in the database.")
	@ApiResponses ({
		@ApiResponse (responseCode = "201",
			description = "Manufacturer successfully created.",
			content = @Content (mediaType = "application/json", schema = @Schema (implementation = Manufacturer.class))
		),
		@ApiResponse (responseCode = "500",
			description = "Failure creating manufacturer due to server error.",
			content = @Content (mediaType = "application/json", schema = @Schema (implementation = Manufacturer.class))
		)
	})
	public ResponseEntity<Manufacturer> createManufacturer(@Valid @RequestBody Manufacturer manufacturer) {
		try {
			log.info("ManufacturerController.createManufacturer() - Method Entry");
			manufacturerService.create(manufacturer);
			log.info("ManufacturerController.createManufacturer() - Method Exit");
			return new ResponseEntity<>(manufacturer, HttpStatus.CREATED);
		}
		catch (SQLGrammarException ex) {
			log.error("SQLGrammarException - {}", ex.getLocalizedMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Encountered an error attempting to persist manufacturer in the database.", ex);
		}
	}

}