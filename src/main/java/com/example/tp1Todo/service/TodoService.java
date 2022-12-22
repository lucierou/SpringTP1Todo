package com.example.tp1Todo.service;

import com.example.tp1Todo.entity.Todo;
import com.example.tp1Todo.interfaces.IDAO;
import com.example.tp1Todo.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements IDAO<Todo> {

    private ServiceHibernate serviceHibernate;

    private Session session;

    public TodoService(ServiceHibernate serviceHibernate) {
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }


    @Override
    public boolean create(Todo o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Todo o) {
        return false;
    }

    @Override
    public boolean delete(Todo o) {
        return false;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
