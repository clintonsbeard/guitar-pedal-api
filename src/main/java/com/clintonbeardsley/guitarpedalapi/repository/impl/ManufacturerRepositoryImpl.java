package com.clintonbeardsley.guitarpedalapi.repository.impl;

import com.clintonbeardsley.guitarpedalapi.model.Manufacturer;
import com.clintonbeardsley.guitarpedalapi.repository.ManufacturerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerRepositoryImpl implements ManufacturerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Manufacturer manufacturer) {
		entityManager.persist(manufacturer);
	}

}