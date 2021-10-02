/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.homework.interfaces;

import com.spboot.homework.models.Todo;
import java.util.List;

/**
 *
 * @author Naga
 */
 public interface TodoInterface {
    List<Todo> getAll();
    void store(Todo inventories);
    Todo getById(long id);
    void delete(long id);
}
