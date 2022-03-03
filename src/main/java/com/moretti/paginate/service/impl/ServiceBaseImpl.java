package com.moretti.paginate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.moretti.paginate.service.ServiceBase;

public abstract class ServiceBaseImpl<T, L> implements ServiceBase<T, L> {
	
	public abstract JpaRepository<T, L> getRepository();

	@Override
	public void save(T obj) {
		this.getRepository().save(obj);
	}

	@Override
	public void remove(T obj) {
		this.getRepository().delete(obj);
	}

	@Override
	public void update(T obj) {
		this.getRepository().save(obj);
	}

	@Override
	public Page<T> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.getRepository().findAll(pageable);
	}

	@Override
	public Optional<T> get(L id) {
		// TODO Auto-generated method stub
		return this.getRepository().findById(id);
	}

}
