package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Repository
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {

	public UserRepositoryImpl(SessionFactory sessionFactory) {

		super(sessionFactory, User.class);

	}

	@Override
	public List<UserDto> findAllJoin() {
		String hql = "SELECT new com.myclass.dto.UserDto(u.id, "
				+ "u.email, u.password, u.fullname, u.avatar, u.roleId, r.description) "
				+ "FROM User u JOIN Role r ON u.roleId = r.id";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<User> findAllLeader() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User u WHERE u.roleId = 2", User.class);
		return query.getResultList();
	}

}
