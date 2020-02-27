package com.matrix.resource;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.matrix.model.AbstractModel;
import com.matrix.service.AbstractService;

@SuppressWarnings({ "rawtypes" })
public abstract class AbstractResource<T extends AbstractModel> {

	protected abstract AbstractService<T> getService();

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@Valid @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(getService().findById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<T>> findAllPageable(@Valid Pageable options) {
		return ResponseEntity.status(HttpStatus.OK).body(getService().findAll(options));
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public T create(@Valid @RequestBody T t, BindingResult result) {
		return getService().save(t, result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable Long id, @Valid @RequestBody T t, BindingResult result) {
		return ResponseEntity.ok(getService().put(t, id, result));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable @Valid Long id) {
		getService().deleteById(id);
	}
}
