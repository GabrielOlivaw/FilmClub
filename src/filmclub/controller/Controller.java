/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.controller;

import filmclub.observer.ViewObserver;

/**
 * 
 * Abstract design defining the methods common to each controller. 
 *
 * @author gabag
 * @param <T>
 */
public abstract class Controller <T> {
    
    protected ViewObserver observer;
    
    public abstract void findAll();
    public abstract void addEntity(T entity);
    public abstract void updateEntity(T entity);
    public abstract void deleteEntity(T entity);
    
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }
}
