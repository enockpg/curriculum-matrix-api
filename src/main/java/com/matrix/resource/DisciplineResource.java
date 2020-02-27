package com.matrix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.model.Discipline;
import com.matrix.service.AbstractService;
import com.matrix.service.DisciplineService;

@RestController
@RequestMapping("/discipline")
public class DisciplineResource extends AbstractResource<Discipline> {

	@Autowired
	private DisciplineService service;

	@Override
	protected AbstractService<Discipline> getService() {
		return service;
	}
	

}
