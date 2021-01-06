package com.devsuperior.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.dsdelivery.dto.OrderDTO;
import com.devsuperior.dsdelivery.dto.ProductDTO;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import com.devsuperior.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) throws Exception {
		
		try {
		  if(dto.getProducts().isEmpty())
			throw new Exception("O pedido deve conter pelo menos um produto");
		} catch (Exception e) {
			throw new Exception("O pedido deve conter pelo menos um produto");
		}
		
		Order order = new Order(null, 
				 				dto.getAddress(), 
								dto.getLatitude(), 
								dto.getLongitude(),
								Instant.now(),
								OrderStatus.PENDING);
		
		for (ProductDTO p : dto.getProducts()) {
			
			Product product;
			
			try {
			  product = productRepository.getOne(p.getId());
			} catch (EntityNotFoundException e) {
				throw e;
			}			
			
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		
		try {
			order = repository.save(order);
		} catch (EntityNotFoundException e) {
			throw e;
		}
		
		return new OrderDTO(order);
	}
	 
}
