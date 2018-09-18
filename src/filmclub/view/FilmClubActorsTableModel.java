/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.view;

import filmclub.model.Actor;
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
public class FilmClubActorsTableModel extends AbstractTableModel {
    
    private static final String[] COLNAMES = {"Actor ID", "First name", "Last name"};
    private static final Class[] COLCLASSES = {Short.class, String.class, String.class};
    private int editableRow;
    private List<Actor> actors;
    
    private Actor temporalActor;
    private int temporalActorPos;
    
    public FilmClubActorsTableModel(List<Actor> actors) {
        this.actors = new ArrayList<>(actors);
        this.editableRow = -1;
    }

    @Override
    public int getRowCount() {
        return actors.size();
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
    public boolean isCellEditable(int row, int col) {
        return editableRow > -1 && editableRow == row && col > 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "-";
        Actor actor = actors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = actor.getActorId();
                break;
            case 1:
                value = actor.getFirstName();
                break;
            case 2:
                value = actor.getLastName();
                break;
        }
        
        return value;
    }
    
    @Override
    public void setValueAt(Object val, int row, int col) {
        String str = (String)val;
        switch(col) {
            case 1: 
                actors.get(row).setFirstName(str);
                break;
            case 2:
                actors.get(row).setLastName(str);
                break;
        }
        
        fireTableDataChanged();
    }
    
    public Actor getActorAt(int row) {
        return actors.get(row);
    }
    
    public List<Actor> getActors() {
        return actors;
    }
    
    public void setActors(List<Actor> actors) {
        this.actors = actors;
        fireTableDataChanged();
    }
    
    public void addActor(Actor actor) {
        this.actors.add(actor);
        fireTableDataChanged();
    }
    
    public void editActor(int pos, Actor actor) {
        actors.set(pos, actor);
        fireTableDataChanged();
    }
    
    public void removeActor(int pos) {
        actors.remove(pos);
        fireTableDataChanged();
    }
    
    public int getRowEditable() {
        return this.editableRow;
    }
    
    public void setRowEditable(int row, boolean editable) {
        if (editable)
            editableRow = row;
        else
            editableRow = -1;
    }
    
    public Actor getTemporalActor() {
        return temporalActor;
    }
    
    public void setTemporalActor(int pos) {
        this.temporalActor = new Actor(actors.get(pos).getFirstName(), 
                actors.get(pos).getLastName(), new Date());
        this.temporalActorPos = pos;
    }
    
    public void setTemporalActor(Actor a, int pos) {
        this.temporalActor = a;
        this.temporalActorPos = pos;
    }
    
    public int getTemporalActorPos() {
        return temporalActorPos;
    }
    
    public void rollback(ModifyMode modifyMode) {
        if (temporalActor != null && temporalActorPos != -1) {
            switch (modifyMode) {
                case ADD_MODE:
                    actors.remove(actors.size() - 1);
                    temporalActorPos--;
                    break;
                case EDIT_MODE:
                    actors.get(temporalActorPos).setFirstName(temporalActor.getFirstName());
                    actors.get(temporalActorPos).setLastName(temporalActor.getLastName());
                    break;
                case DELETE_MODE:
                    actors.add(temporalActorPos, temporalActor);
                    temporalActorPos++;
                    break;
            }
            fireTableDataChanged();
        }
    }
}
