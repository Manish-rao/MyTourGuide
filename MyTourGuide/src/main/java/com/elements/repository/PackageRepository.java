package com.elements.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elements.DO.PackageDetailsDO;

public interface PackageRepository extends JpaRepository<PackageDetailsDO, String>{
	
	PackageDetailsDO findByPackageName(String packageName);
	
}
