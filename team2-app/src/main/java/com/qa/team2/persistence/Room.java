package com.qa.team2.persistence;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qa.team2.business.repository.ApartmentService;
import com.qa.team2.business.repository.RoomService;
import com.qa.team2.util.JSONUtil;

@Entity
public class Room {
	
	@Inject
	ApartmentService apartmentService;
	JSONUtil util;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_room_apartment"))
	private Apartment apartment;
	
	public Room() {

	}

	public Room(Long apartmentId) {
		String aApartmentString = apartmentService.findApartment(apartmentId);
		Apartment aApartment = util.getObjectForJSON(aApartmentString, Apartment.class);
		this.apartment = aApartment;
	}
	
	public Room(Long id, Long apartmentId) {
		this(apartmentId);
		this.id = id;
	}

	
}
