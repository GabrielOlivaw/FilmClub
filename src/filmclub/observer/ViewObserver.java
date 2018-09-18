/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.observer;

import java.util.List;

/**
 * Definition for the listeners of each controller operation. This has to be 
 * implemented in each view.
 * 
 * @author gabag
 * @param <T>
 */
public interface ViewObserver <T> {
    
    public void onFindAll(List<T> list);
    public void onAddEntity(T entity);
    public void onUpdateEntity(T entity);
    public void onDeleteEntity(T entity);
}
