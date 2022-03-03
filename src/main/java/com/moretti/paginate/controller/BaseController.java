package com.moretti.paginate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.moretti.paginate.service.ServiceBase;

public abstract class BaseController<T, L> {

	public abstract ServiceBase<T, L> getService();
	
	@GetMapping()
	public List<T> get() throws Exception {
		throw new Exception("O filtro é obrigatório");
	}
	
	@GetMapping(value = "/page/{page}/size/{size}")
	public Page<T> getPaginate(@PathVariable("page") int page,
			@PathVariable("size") int size,
			@RequestParam(name = "order", required = false) String order,
			@RequestParam(name = "property", required = false) String property) {
		Pageable pageSetup;
		
		if(property != null) {
			Sort sortSetup = order.equals("asc") ? 
					Sort.by(property).ascending()
					: Sort.by(property).descending();
			
			pageSetup = PageRequest.of(page, size, sortSetup);
		} else {
			pageSetup = PageRequest.of(page, size);
		}
		
		return this.getService().getAll(pageSetup);
	}
	
	@PostMapping()
	public void post(@Valid @RequestBody() T obj) {
		this.getService().save(obj);
	}
}
