package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.dto.ProjectDto;
import com.myclass.entity.Project;
import com.myclass.repository.ProjectRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class ProjectRepositoryImpl extends BaseRepositoryImpl<Project, Integer> implements ProjectRepository {

	public ProjectRepositoryImpl(SessionFactory sessionFactory) {

		super(sessionFactory, Project.class);

	}

//	@Override
//	public List<Project> findAll() {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Project> query = session.createQuery("FROM Project", Project.class);
//		return query.getResultList();
//	}
//
//
//	@Override
//	public Project findById(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.find(Project.class, id);
//	}
//
//	@Override
//	public void save(Project entity) {
//		Session session = sessionFactory.getCurrentSession();
//		session.saveOrUpdate(entity);
//	}
//
//	@Override
//	public void delete(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		Project entity = session.find(Project.class, id);
//		session.delete(entity);
//	}

	@Override
	public List<ProjectDto> findAllJoin() {
		String hql = "SELECT new com.myclass.dto.ProjectDto(p.id, p.name, p.startDate, p.endDate, p.leaderId, u.fullname) "
				+ "FROM Project p JOIN User u ON p.leaderId = u.id";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<ProjectDto> dtos = query.getResultList();
		return dtos;
	}
}
