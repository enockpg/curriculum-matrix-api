package com.matrix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.model.Professor;
import com.matrix.service.AbstractService;
import com.matrix.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource extends AbstractResource<Professor> {

	@Autowired
	private ProfessorService service;

	@Override
	protected AbstractService<Professor> getService() {
		return service;
	}
	

}
