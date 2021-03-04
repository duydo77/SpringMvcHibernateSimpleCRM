package com.myclass.service;

import java.util.List;

import com.myclass.dto.StatusDto;

public interface StatusService {

	List<StatusDto> findAll();

	StatusDto findById(int id);

	int add(StatusDto dto);

	int edit(StatusDto dto);

	int delete(int id);

}
