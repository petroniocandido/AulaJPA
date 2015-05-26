/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.Repositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {

    @PersistenceContext(name = "ExemploJPAPU")
    protected EntityManager manager;
    private Class tipo;
    String where = "";
    String orderby = "";
    String jpql = "select c from ";
    Map<String,Object> parametros = new HashMap<>();

    public DAOGenerico(Class t) {
        this.tipo = t;
        jpql += t.getSimpleName() + " c";
    }
    
    public DAOGenerico<T> OrderBy(String campo, String order){
        
        if(campo != null){
            if(orderby.length() > 0)
                    orderby += ",";
        
            orderby += "c." + campo + " " + order;
        }
        
        return this;
    }
    
    public DAOGenerico<T> IgualA(String campo, Object valor){
        
        if(where.length() > 0)
                    where += " and ";
        
        if(valor != null){
                where = where + "c." + campo + " = :" + campo;
                parametros.put(campo, valor);
            }
        
        return this;
    }
    
    public DAOGenerico<T> Like(String campo, String valor){
        
        if(where.length() > 0)
                    where += " and ";
        
        if(valor != null){
                where = where + "c." + campo +" like '%"+ valor +"%'";
            }
        
        return this;
    }
    
    public List<T> Buscar() {
        if(where.length() > 0){
            jpql = jpql + " where " + where;
        }
        
        if(orderby.length() > 0)
            jpql = jpql + " order by " + orderby;
        
        Query consulta = manager.createQuery(jpql);
        
        for(String parametro : parametros.keySet())
            consulta.setParameter(parametro, parametros.get(parametro));
        
        where = "";
        
        return consulta.getResultList();
    }

    @Override
    public boolean Salvar(T obj) {
        try {
            manager.persist(obj);
            manager.flush();
            return true;
        } catch(Exception e){
            
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        return (T)manager.find(tipo, id);
    }

    @Override
    public boolean Apagar(T obj) {
        try {
            manager.remove(obj);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public abstract List<T> Buscar(T filtro);

}

