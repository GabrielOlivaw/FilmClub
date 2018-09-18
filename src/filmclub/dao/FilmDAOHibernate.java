/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.dao;

import filmclub.model.Film;
import hibernate.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Implementation of the Film Data Access Object using Hibernate.
 *
 * @author gabag
 */
public class FilmDAOHibernate implements SakilaDAO <Film> {
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Film> findAll() {
        
        //Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Film f order by f.filmId");
        List<Film> films = query.list();
        
        return films;
    }

    @Override
    public Film findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Film a) {
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    @Override
    public void update(Film a) {
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        a.setLastUpdate(new Date());
        session.update(a);
        tx.commit();
    }

    @Override
    public void delete(Film a) {
        Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }
}
