package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.StatusDto;
import com.myclass.entity.Status;
import com.myclass.repository.StatusRepository;
import com.myclass.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	StatusRepository statusRepository;

	public StatusServiceImpl(StatusRepository statusRepository) {

		this.statusRepository = statusRepository;

	}

	@Override
	public List<StatusDto> findAll() {
		List<StatusDto> dtos = new ArrayList<StatusDto>();
		try {
			List<Status> entities = statusRepository.findAll();

			for (Status entity : entities) {
				StatusDto dto = new StatusDto(entity.getId(), entity.getName());
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public StatusDto findById(int id) {
		try {
			Status entity = statusRepository.findById(id);
			if (entity != null)
				return new StatusDto(entity.getId(), entity.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StatusDto();
	}

	@Override
	public int add(StatusDto dto) {
		try {
			Status entity = new Status(dto.getId(), dto.getName());
			statusRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int edit(StatusDto dto) {
		try {
			Status entity = statusRepository.findById(dto.getId());
			if (entity == null)
				return -1;
			entity.setName(dto.getName());
			statusRepository.save(entity);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		try {
			statusRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
