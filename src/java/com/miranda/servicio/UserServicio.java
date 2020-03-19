/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miranda.servicio;

import com.miranda.dao.UserDao;
import com.miranda.entidades.User;
import java.util.List;

/**
 *
 * @author miran
 */
public class UserServicio {
    
    private UserDao userDao;
    
    public UserServicio(){
        userDao = new UserDao();
    }
    
    public List<User> getAll(){
        return userDao.getAll();
    }
    
    public User get(User user){
        return userDao.get(user.getUsername(), user.getDescription());
    }
    
    public void create(User user) throws Exception{
        
        if(user == null)
            throw new NullPointerException("Usuario no puede ser null");
        
        if(user.getUsername() == null || user.getUsername().length() == 0)
            throw new Exception("Nombre del usuario no contiene caracteres: '"+user.getUsername()+"'");
        
        if(user.getDescription() == null || user.getDescription().length() == 0)
            throw new Exception("La descripción del usuario no contiene caracteres: '"+ user.getDescription()+"'");
        
        userDao.addUser(user );
        
    }
    
    public void update(User user) throws Exception{
        
        if(user == null)
            throw new NullPointerException("Usuario no puede ser null");
        
        if(user.getUsername() == null || user.getUsername().length() == 0)
            throw new Exception("Nombre del usuario no contiene caracteres: '"+user.getUsername()+"'");
        
        if(user.getDescription() == null || user.getDescription().length() == 0)
            throw new Exception("La descripción del usuario no contiene caracteres: '"+ user.getDescription()+"'");
        
        userDao.updateUser(user);
        
    }
    
    public void delete(User user) throws Exception{
        if(user == null)
            throw new NullPointerException("Usuario no puede ser null");
        
        userDao.deleteUser(user);
    }
    
}
