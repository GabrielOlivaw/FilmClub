/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.controller;

import filmclub.dao.SakilaDAO;
import filmclub.model.Actor;
import java.util.List;

/**
 *
 * Controller for the views where Actors are shown.
 * 
 * @author gabag
 */
public class ActorsController extends Controller <Actor> {
    
    private List<Actor> actors;
    private final SakilaDAO<Actor> sakilaDao;
    
    public ActorsController(SakilaDAO<Actor> sakilaDao) {
        super();
        this.sakilaDao = sakilaDao;
    }
    
    public List<Actor> getActors() {
        return this.actors;
    }

    @Override
    public void findAll() {
        actors = sakilaDao.findAll();
        this.observer.onFindAll(actors);
    }

    @Override
    public void addEntity(Actor a) {
        sakilaDao.add(a);
        this.observer.onAddEntity(a);
    }

    @Override
    public void updateEntity(Actor a) {
        sakilaDao.update(a);
        this.observer.onUpdateEntity(a);
    }

    @Override
    public void deleteEntity(Actor a) {
        sakilaDao.delete(a);
        this.observer.onDeleteEntity(a);
    }
    
}
