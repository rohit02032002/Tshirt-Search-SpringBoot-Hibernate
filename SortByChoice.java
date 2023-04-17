package com.tshirtsearch.assignment.entity;

import java.util.Comparator;


public class SortByChoice implements Comparator<Tshirt> {
	
	String Preference;

	public SortByChoice(String preference) {
		
		this.Preference = preference;
	}


	@Override
	public int compare(Tshirt o1, Tshirt o2) {
		
		if(this.Preference.equals("Price")) {
			
			  if(o1.getPrice()>o2.getPrice())
		        {
		                return 1;
		        }
		        else if (o2.getPrice()>o1.getPrice())
		        {
		                return -1;
		        }
		        else 
		            return 0;
		}
		else {
			
			if(o1.getRating()>o2.getRating())
	        {
	                return -1;
	        }
	        else if (o2.getRating()>o1.getRating())
	        {
	                return 1;
	        }
	        else 
	            return 0;
		}
	        	
	}
}
