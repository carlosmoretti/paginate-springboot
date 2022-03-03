package com.moretti.paginate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceBase<T, L> {
	void save(T obj);
	void remove(T obj);
	void update(T obj);
	Page<T> getAll(Pageable pageable);
	Optional<T> get(L id);
}