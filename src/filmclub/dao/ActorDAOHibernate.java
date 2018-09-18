/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.dao;

import filmclub.model.Actor;
import hibernate.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Implementation of the Actor Data Access Object using Hibernate.
 *
 * @author gabag
 */
public class ActorDAOHibernate implements SakilaDAO <Actor> {
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Actor> findAll() {
        
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Actor a order by a.actorId");
        List<Actor> actors = query.list();
        
        return actors;
    }

    @Override
    public Actor findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Actor a) {
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    @Override
    public void update(Actor a) {
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        a.setLastUpdate(new Date());
        session.update(a);
        tx.commit();
    }

    @Override
    public void delete(Actor a) {
        Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }
    
}
