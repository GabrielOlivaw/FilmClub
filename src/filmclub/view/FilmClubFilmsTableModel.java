/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.view;

import filmclub.model.Film;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Table model for the table of actors in the FilmClubActors window. 
 * When we want to edit a row after creating a new Actor or editing an existing 
 * one, we set that row to be editable passing its position to the editableRow 
 * field. If there isn't an editable row, that field equals to -1.
 * Also, the temporalActor and temporalActorPos values are used to undo unsaved 
 * changes when pressing the Cancel button after trying to modify or delete an Actor.
 *
 * @author gabag
 */
public class FilmClubFilmsTableModel extends AbstractTableModel {
    
    private static final String[] COLNAMES = {"Film ID", "Title"};
    private static final Class[] COLCLASSES = {Short.class, String.class};
    private List<Film> films;
    
    private Film temporalFilm;
    private int temporalFilmPos;
    
    public FilmClubFilmsTableModel(List<Film> films) {
        this.films = new ArrayList<>(films);
    }

    @Override
    public int getRowCount() {
        return films.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return COLNAMES[col];
    }
    
    @Override
    public Class<?> getColumnClass(int col) {
        return COLCLASSES[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "-";
        Film film = films.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = film.getFilmId();
                break;
            case 1:
                value = film.getTitle();
                break;
        }
        
        return value;
    }
    
    @Override
    public void setValueAt(Object val, int row, int col) {
        String str = (String)val;
        switch(col) {
            case 1: 
                films.get(row).setTitle(str);
                break;
        }
        
        fireTableDataChanged();
    }
    
    public Film getFilmAt(int row) {
        return films.get(row);
    }
    
    public List<Film> getFilms() {
        return films;
    }
    
    public void setFilms(List<Film> films) {
        this.films = films;
        fireTableDataChanged();
    }
    
    public void addFilm(Film film) {
        this.films.add(film);
        fireTableDataChanged();
    }
    
    public void editFilm(int pos, Film film) {
        films.set(pos, film);
        fireTableDataChanged();
    }
    
    public void removeFilm(int pos) {
        films.remove(pos);
        fireTableDataChanged();
    }
    
    public Film getTemporalFilm() {
        return temporalFilm;
    }
    
    public void setTemporalFilm(int pos) {
        this.temporalFilm = new Film(
                films.get(pos).getLanguageByLanguageId(), 
                films.get(pos).getTitle(), films.get(pos).getRentalDuration(), 
                films.get(pos).getRentalRate(), 
                films.get(pos).getReplacementCost(), new Date());
        this.temporalFilmPos = pos;
    }
    
    public void setTemporalFilm(Film a, int pos) {
        this.temporalFilm = a;
        this.temporalFilmPos = pos;
    }
    
    public int getTemporalFilmPos() {
        return temporalFilmPos;
    }
    
    public void rollback(ModifyMode modifyMode) {
        if (temporalFilm != null && temporalFilmPos != -1) {
            switch (modifyMode) {
                case ADD_MODE:
                    films.remove(films.size() - 1);
                    temporalFilmPos--;
                    break;
                case EDIT_MODE:
                    /*
                    films.get(temporalFilmPos).setFirstName(temporalActor.getFirstName());
                    films.get(temporalFilmPos).setLastName(temporalActor.getLastName());
*/
                    break;
                case DELETE_MODE:
                    films.add(temporalFilmPos, temporalFilm);
                    temporalFilmPos++;
                    break;
            }
            fireTableDataChanged();
        }
    }
}
