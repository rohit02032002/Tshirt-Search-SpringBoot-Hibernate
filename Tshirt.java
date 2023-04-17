package com.tshirtsearch.assignment.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Tshirt {

	@Id
	@Column
    private String id;
    private String name;
    private String color;
    private String gender;
    private String size;
    private double price;
    private float rating;
    private String availability;

    public Tshirt() {
		super();
		// TODO Auto-generated constructor stub
	}

    public  Tshirt(String id, String name, String color, String gender, String size, double price, float rating,String availability) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability=availability;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
       this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

	@Override
	public String toString() {
		return "Tshirt [Id=" + id + ", Name=" + name + ", Color=" + color + ", Gender=" + gender + ", Size=" + size
				+ ", Price=" + price + ", Rating=" + rating + ", Availability=" + availability + "]";
	}

}
