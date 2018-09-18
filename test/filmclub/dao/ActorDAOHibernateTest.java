/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.dao;

import filmclub.model.Actor;
import filmclub.model.Film;
import filmclub.model.FilmActor;
import filmclub.model.Language;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabag
 */
public class ActorDAOHibernateTest {
    
    SakilaDAO dao;
    
    public ActorDAOHibernateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void loadAll() {
        dao = new FilmDAOHibernate();
        
        List<Film> films = dao.findAll();
        System.out.println("Film: " + films.get(0).getTitle());
        
        assertEquals(films.get(0).getTitle(), "ACADEMY DINOSAUR");
    }
    
    @Test
    public void getDefaultLanguage() {
        dao = new LanguageDAOHibernate();
        
        Language defaultLanguage = (Language) dao.findById(0);
        
        System.out.println("Default language: " + defaultLanguage.getName());
        
        assertEquals(defaultLanguage.getName(), "English");
    }
}
