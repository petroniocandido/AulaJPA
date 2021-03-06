/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import br.edu.ifnmg.TesteJPA.DomainModel.Cliente;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ClienteRepositorio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author petronio
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController extends ControllerGenerico<Cliente> implements Serializable {

    /**
     * Creates a new instance of testeController
     */
    public ClienteController() {
        super("listagemClientes.xhtml","editarCliente.xhtml");
        entidade = new Cliente();
        filtro = new Cliente();
    }
    
    @EJB
    private ClienteRepositorio repositorio;

    @PostConstruct
    public void configurar(){
        setDao(repositorio);
    }
    
}
