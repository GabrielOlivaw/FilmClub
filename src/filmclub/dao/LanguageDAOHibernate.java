/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.dao;

import filmclub.model.Language;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Implementation of the Language Data Access Object using Hibernate.
 * 
 * @author gabag
 */
public class LanguageDAOHibernate implements SakilaDAO<Language> {
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Language> findAll() {
        Query query = session.createQuery("from Language l order by l.languageId");
        List<Language> languages = query.list();
        
        return languages;
    }

    @Override
    public Language findById(int id) {
        Query query = session.createQuery("from Language l where l.languageId = 1");
        Language language = (Language) query.uniqueResult();
        
        return language;
    }

    @Override
    public void add(Language a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Language a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Language a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
