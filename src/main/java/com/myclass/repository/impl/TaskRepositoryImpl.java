package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.dto.TaskDto;
import com.myclass.entity.Task;
import com.myclass.repository.TaskRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class TaskRepositoryImpl extends BaseRepositoryImpl<Task, Integer> implements TaskRepository {

	public TaskRepositoryImpl(SessionFactory sessionFactory) {

		super(sessionFactory, Task.class);

	}

//	@Override
//	public List<Task> findAll() {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Task> query = session.createQuery("FROM Task", Task.class);
//		return query.getResultList();
//	}
//
//	@Override
//	public Task findById(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.find(Task.class, id);
//	}
//
//	@Override
//	public void save(Task entity) {
//		Session session = sessionFactory.getCurrentSession();
//		session.saveOrUpdate(entity);
//	}
//
//	@Override
//	public void delete(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		Task entity = session.find(Task.class, id);
//		session.delete(entity);
//	}

	@Override
	public List<TaskDto> findAllJoin() {
		String hql = "SELECT new com.myclass.dto.TaskDto(t.id, t.name, t.startDate, t.endDate, t.statusId, t.userId,"
				+ "	t.projectId, s.name, u.fullname, p.name) FROM Task t "
				+ "JOIN Status s ON t.statusId = s.id "
				+ "JOIN Project p ON t.projectId = p.id "
				+ "JOIN User u ON t.userId = u.id";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

}
