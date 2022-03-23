/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package budzet.controller;

import budzet.util.HibernateUtil;
import budzet.util.MojException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Ivan
 * 
 */
public abstract class Obrada<T> {

    protected Session session;
    protected T entitet;

    public abstract List<T> read();

    protected abstract void kontrolaCreate() throws MojException;

    protected abstract void kontrolaUpdate() throws MojException;

    protected abstract void kontrolaDelete() throws MojException;
    
    public Obrada(){
        session=HibernateUtil.getSession();
    }
    
    public T create() throws MojException{
        kontrolaCreate();
        save();
        return entitet;
    }
    
    public T update() throws MojException{
        kontrolaUpdate();
        save();
        return entitet;
    }
    
    public void delete() throws MojException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

}
