/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import br.edu.ifnmg.TesteJPA.DomainModel.Cliente;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ClienteRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author petronio
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {

    /**
     * Creates a new instance of testeController
     */
    public ClienteController() {
        entidade = new Cliente();
    }
    
    private Cliente entidade;
    
    @EJB
    private ClienteRepositorio dao;

    public Cliente getEntidade() {
        return entidade;
    }

    public void setEntidade(Cliente entidade) {
        this.entidade = entidade;
    }
    
    
    public void salvar() {
        dao.Salvar(entidade);
    }
    
    public void apagar() {
        dao.Apagar(entidade);
    }
    
    public String voltar() {
        return "listagemClientes.xhtml";
    }
    
    public String novo() {
        entidade = new Cliente();
        return "editarCliente.xhtml";
    }
    
}
