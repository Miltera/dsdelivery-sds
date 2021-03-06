package com.devsuperior.dsdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;

public class OrderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "{address.not.blank}")
	private String address;		
	@NotNull(message = "{latitude.not.blank}")
	private Double latitude;
	@NotNull(message = "{longitude.not.blank}")
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	private List<ProductDTO> products;
	
	public OrderDTO() {
		
	}

	public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	public OrderDTO(Order entity) {	
		this.id = entity.getId();
		this.address = entity.getAddress();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.products = entity.getProducts().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	

}
