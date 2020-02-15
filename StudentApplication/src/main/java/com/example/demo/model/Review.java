package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) //You just need to know how to tell your serializer to ignore the helpful garbage that Hibernate adds to your classes so it can manage lazy loading of data.
@DynamicInsert  //it will create a sql insert query and it will not allow null column 
@DynamicUpdate  // it will only update the data that it have been changed while updating
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String description;
	
	private String rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Long id, String description, String rating) {
		this.id = id;
		this.description = description;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", rating=" + rating + "]";
	}
	

}
