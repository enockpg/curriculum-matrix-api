package com.matrix.model.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.BindingResult;

import com.matrix.model.AbstractModel;

@SuppressWarnings({  "rawtypes" })
public abstract class AbstractService<T extends AbstractModel> {

	protected abstract JpaRepository<T, Long> getRepository();

	public T findById(Long id) {
		return getRepository().findById(id).map(result -> {
			return result;
		}).orElseGet(() -> {
			throw new EntityNotFoundException();
		});
	}

	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}
	
	public List<T> findAll() {
		return getRepository().findAll();
	}

	public T save(T t, BindingResult result) {
		return getRepository().save(t);
	}
	/**
	 * case existe save, but save the type t because that is
 	 *	the modification and not the "any"
	 *
	 * @author enockpinheiro
	 * @since 
	 * @param t
	 * @param id
	 * @param result
	 * @return
	 */
	public T put(T t, Long id, BindingResult result) {
		// case exsite them save but salve type t decause this is modificate end not msp
		return getRepository().findById(id).map(any -> {
			return getRepository().save(t);
		}).orElseThrow(RuntimeException::new);
	}

	public void deleteById(Long id) {
		T obj = this.findById(id);
		getRepository().delete(obj);
	}
}
