/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.Repositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author petronio
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {

    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ExemploJPAPU");
    protected EntityManager manager;
    private Class tipo;

    public DAOGenerico(Class t) {
        manager = fabrica.createEntityManager();
        this.tipo = t;
    }

    @Override
    public boolean Salvar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.persist(obj);
            t.commit();
            return true;
        } catch(Exception e){
            t.rollback();
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        return (T)manager.find(tipo, id);
    }

    @Override
    public boolean Apagar(T obj) {
        EntityTransaction t = manager.getTransaction();
        try {
            t.begin();
            manager.remove(obj);
            t.commit();
            return true;
        } catch(Exception e){
            t.rollback();
            return false;
        }
    }

    public abstract List<T> Buscar(T filtro);

}
