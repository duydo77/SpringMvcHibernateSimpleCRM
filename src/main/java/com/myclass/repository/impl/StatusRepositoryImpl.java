package com.myclass.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Status;
import com.myclass.repository.StatusRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class StatusRepositoryImpl extends BaseRepositoryImpl<Status, Integer> implements StatusRepository {

	public StatusRepositoryImpl(SessionFactory sessionFactory) {

		super(sessionFactory, Status.class);

	}

//	@Override
//	public List<Status> findAll() {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Status> query = session.createQuery("FROM Status", Status.class);
//		return query.getResultList();
//	}
//
//	@Override
//	public Status findById(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.find(Status.class, id);
//	}
//
//	@Override
//	public void save(Status entity) {
//		Session session = sessionFactory.getCurrentSession();
//		session.saveOrUpdate(entity);
//	}
//
//	@Override
//	public void delete(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		Status entity = session.find(Status.class, id);
//		session.delete(entity);
//	}

}
