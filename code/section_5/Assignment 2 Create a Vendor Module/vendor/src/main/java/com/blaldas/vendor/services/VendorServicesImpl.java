package com.blaldas.vendor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaldas.vendor.entities.Vendor;
import com.blaldas.vendor.repos.VendorRepository;

@Service
public class VendorServicesImpl implements VendorService {

	@Autowired
	VendorRepository repo;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		repo.delete(vendor);

	}

	@Override
	public Vendor getVendorById(int id) {
		return repo.getReferenceById(id);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return repo.findAll();
	}

}
