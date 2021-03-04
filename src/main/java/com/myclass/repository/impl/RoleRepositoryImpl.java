package com.myclass.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role, Integer> implements RoleRepository {
	
	public RoleRepositoryImpl(SessionFactory sessionFactory) {

		super(sessionFactory, Role.class);

	}

//	@Override
//	public List<Role> findAll() {
//		Session session = sessionFactory.getCurrentSession();
//		Query<Role> query = session.createQuery("FROM Role", Role.class);
//		return query.getResultList();
//	}
//
//	@Override
//	public Role findById(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.find(Role.class, id);
//	}
//
//	@Override
//	public void save(Role entity) {
//		Session session = sessionFactory.getCurrentSession();
//		session.saveOrUpdate(entity);
//	}
//
//	@Override
//	public void delete(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		Role entity = session.find(Role.class, id);
//		session.delete(entity);
//	}

}
