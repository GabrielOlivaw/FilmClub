/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.controller;

import filmclub.dao.SakilaDAO;
import filmclub.model.Film;
import filmclub.model.Language;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * Controller used in the views which deal with Films.
 *
 * @author gabag
 */
public class FilmsController extends Controller <Film> {
    
    private List<Film> films;
    private List<Language> languages;
    private final SakilaDAO<Film> sakilaDaoFilm;
    private final SakilaDAO<Language> sakilaDaoLanguage;
    
    public FilmsController(SakilaDAO<Film> sakilaDaoFilm, SakilaDAO<Language> sakilaDaoLanguage) {
        this.sakilaDaoFilm = sakilaDaoFilm;
        this.sakilaDaoLanguage = sakilaDaoLanguage;
    }
    
    public List<Film> getFilms() {
        return films;
    }
    
    public List<Language> getLanguages() {
        return languages;
    }
    
    public Language getLanguageById(int id) {
        return sakilaDaoLanguage.findById(id);
    }
    
    public Film getNewFilm() {
        return new Film(languages.get(0), "", (byte)0, new BigDecimal("0.00"), new BigDecimal("0.00"), new Date());
   }    

    @Override
    public void findAll() {
        films = sakilaDaoFilm.findAll();
        languages = sakilaDaoLanguage.findAll();
        this.observer.onFindAll(films);
    }

    @Override
    public void addEntity(Film f) {
        sakilaDaoFilm.add(f);
        this.observer.onAddEntity(f);
    }

    @Override
    public void updateEntity(Film f) {
        sakilaDaoFilm.update(f);
        this.observer.onUpdateEntity(f);
    }

    @Override
    public void deleteEntity(Film f) {
        sakilaDaoFilm.delete(f);
        this.observer.onDeleteEntity(f);
    }
    
}
