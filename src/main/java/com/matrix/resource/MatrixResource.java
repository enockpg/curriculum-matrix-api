package com.matrix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.model.Matrix;
import com.matrix.model.service.AbstractService;
import com.matrix.model.service.MatrixService;

@RestController
@RequestMapping("/matrix")
public class MatrixResource extends AbstractResource<Matrix> {

	@Autowired
	private MatrixService service;

	@Override
	protected AbstractService<Matrix> getService() {
		return service;
	}
	

}
