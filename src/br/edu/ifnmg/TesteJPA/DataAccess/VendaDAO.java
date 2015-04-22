/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.VendaRepositorio;
import br.edu.ifnmg.TesteJPA.DomainModel.Venda;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio{

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public List<Venda> Buscar(Venda filtro) {
        Query consulta = manager.createQuery("select c from Venda c");
        return consulta.getResultList();
    }
    
}
