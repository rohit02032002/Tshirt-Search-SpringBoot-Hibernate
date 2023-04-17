package com.tshirtsearch.assignment.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tshirtsearch.assignment.entity.Tshirt;
import com.tshirtsearch.assignment.entity.SortByChoice;
import com.tshirtsearch.assignment.dao.TshirtDao;

@Service
public class TshirtService {

	@Autowired
	private TshirtDao tshirtDao;
	
	//Inserting All Csv File Data Into Table
	public void CsvToTable() throws FileNotFoundException
	{
		String directoryPath = "/Users/macbook/Downloads";
	     File[] filesInDirectory = new File(directoryPath).listFiles();
	        
	        for(File f : filesInDirectory){
	            String filePath = f.getAbsolutePath();
	            String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
	            if("csv".equals(fileExtension)){
	            	 File MyCsvFile = new File(filePath);
	            	 Scanner fc = new Scanner(MyCsvFile);
	            	 fc.nextLine();
	            	 while (fc.hasNext()) {
	            		 
	                     String line = fc.nextLine().toUpperCase();
	                     String[] wordArray = line.split("\\|");
	                     Tshirt tshirt = new Tshirt(wordArray[0],wordArray[1],wordArray[2],wordArray[3],wordArray[4],Double.parseDouble(wordArray[5]),Float.parseFloat(wordArray[6]),wordArray[7]);
	                     tshirtDao.save(tshirt);
	            	 }
	            }
	        }
	}
	
	//Get All T-shirts
	public List<Tshirt> getAllTshirt()
	{
		return tshirtDao.findAll();
	}
	
	//Search Tshirts by Properties
	public List<Tshirt> getTshirt(String Color,String Size,String Gender,String Preference)
	{
		List<Tshirt> tshirts = tshirtDao.findAll();
		List<Tshirt> filteredTshirt = new ArrayList<>();
		tshirts.stream().filter(tshirt->tshirt.getColor().equals(Color)&&tshirt.getSize().equals(Size)&&tshirt.getGender().equals(Gender)).forEach(tshirt->filteredTshirt.add(tshirt));
		
//		for(Tshirt tshirt:tshirts)
//		{
//			if(tshirt.getColor().equals(Color)&&tshirt.getSize().equals(Size)&&tshirt.getGender().equals(Gender))
//			{
//				filteredTshirt.add(tshirt);
//			}
//		}
		Collections.sort(filteredTshirt,new SortByChoice(Preference));
		return filteredTshirt;
	}
	
	//Add New T-shirt
	public void addTshirt(Tshirt tshirt)
	{
		tshirtDao.save(tshirt);
	}
}
