package com.tshirtsearch.assignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileNotFoundException;

import com.tshirtsearch.assignment.service.TshirtService;
import com.tshirtsearch.assignment.entity.Tshirt;


@RestController
public class TshirtController {

	@Autowired 
	private TshirtService tshirtService;
	
	@GetMapping("/CsvToTable")
	public void CsvToTable() throws FileNotFoundException
	{
		 	tshirtService.CsvToTable();
	}
	
	@GetMapping("/tshirts")
	public List<Tshirt> getAllTshirt() {
		
		return tshirtService.getAllTshirt();
	}
	@GetMapping("/tshirt")
	public List<Tshirt> getTshirt(@RequestParam String Color,@RequestParam String Size,@RequestParam String Gender,@RequestParam String Preference) {
		
		return tshirtService.getTshirt(Color.toUpperCase(),Size.toUpperCase(),Gender.toUpperCase(),Preference);
	}
	
	@PostMapping("/tshirt")
	public void addTshirt(@RequestBody Tshirt tshirt)
	{
		tshirtService.addTshirt(tshirt);
	}
}
