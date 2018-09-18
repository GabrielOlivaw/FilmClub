/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.view;

/**
 * This enumerated class represents the possible states of the actors table 
 * section of the FilmClubActors window.
 * 
 * NORMAL_MODE is the default read-only mode.
 * ADD_MODE, EDIT_MODE and DELETE_MODE are for editing the Actor table content, 
 * disabling the upper toolbar and enabling the lower toolbar to confirm the 
 * user changes.
 * 
 * @author gabag
 */
public enum ModifyMode {
    NORMAL_MODE, ADD_MODE, EDIT_MODE, DELETE_MODE;
}
