/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.spec;

import java.util.List;

/**
 *
 * @author aleks
 */
public interface Repository<T,K> {
    List<T> getAll() throws Exception;
    void add(T t) throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    T getByID(K k) throws Exception;
}
