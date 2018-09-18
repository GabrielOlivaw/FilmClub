/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.dao;

import java.util.List;

/**
 * Definition of the various operations used in each Data Access Object.
 *
 * @author gabag
 * @param <T>
 */
public interface SakilaDAO <T> {
    public List<T> findAll();
    public T findById(int id);
    public void add(T a);
    public void update(T a);
    public void delete(T a);
}
