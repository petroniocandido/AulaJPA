/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Cliente;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ClienteRepositorio;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio{

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> Buscar(Cliente filtro) {
       return Like("nome", filtro.getNome())
               .IgualA("id", filtro.getId())
               .IgualA("cpf", filtro.getCpf())
               .OrderBy("nome", "ASC")
               .Buscar();
    }

    @Override
    public Cliente AbrirPorCPF(String cpf) {
        Query consulta = manager.createQuery("select o from Cliente o "
                + "where o.cpf = :cpf");
        consulta.setParameter("cpf", cpf);
        return (Cliente)consulta.getSingleResult();
    }
    
}















