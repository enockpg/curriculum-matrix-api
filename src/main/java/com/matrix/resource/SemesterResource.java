package com.matrix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.model.Semester;
import com.matrix.model.service.AbstractService;
import com.matrix.model.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterResource extends AbstractResource<Semester> {

	@Autowired
	private SemesterService service;

	@Override
	protected AbstractService<Semester> getService() {
		return service;
	}
	

}
