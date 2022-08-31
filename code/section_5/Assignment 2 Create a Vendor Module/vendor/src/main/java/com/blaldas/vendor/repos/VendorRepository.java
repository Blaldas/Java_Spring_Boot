package com.blaldas.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaldas.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
