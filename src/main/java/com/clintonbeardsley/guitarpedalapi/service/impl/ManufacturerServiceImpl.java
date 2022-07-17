package com.clintonbeardsley.guitarpedalapi.service.impl;

import com.clintonbeardsley.guitarpedalapi.model.Manufacturer;
import com.clintonbeardsley.guitarpedalapi.repository.ManufacturerRepository;
import com.clintonbeardsley.guitarpedalapi.service.ManufacturerService;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

	private final ManufacturerRepository manufacturerRepository;

	@Override
	public void create(Manufacturer manufacturer) {
		manufacturerRepository.create(manufacturer);
	}

}