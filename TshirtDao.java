package com.tshirtsearch.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tshirtsearch.assignment.entity.Tshirt;

public interface TshirtDao extends JpaRepository<Tshirt, String> {
	
	

}
