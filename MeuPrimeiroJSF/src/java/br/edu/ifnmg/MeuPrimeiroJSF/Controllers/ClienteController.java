/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import br.edu.ifnmg.TesteJPA.DomainModel.Cliente;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ClienteRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.print.attribute.standard.Severity;

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
        filtro = new Cliente();
    }
    
    private Cliente entidade;
    private Cliente filtro;
    
    @EJB
    private ClienteRepositorio dao;

    public Cliente getEntidade() {
        return entidade;
    }

    public void setEntidade(Cliente entidade) {
        this.entidade = entidade;
    }

    public Cliente getFiltro() {
        return filtro;
    }

    public void setFiltro(Cliente filtro) {
        this.filtro = filtro;
    }
        
    protected void MensagemSucesso(String titulo, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, titulo);
        context.addMessage(null, m);
        context.getExternalContext().getFlash().setKeepMessages(true);        
    }
    
    protected void MensagemErro(String titulo, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, titulo);
        context.addMessage(null, m);
        context.getExternalContext().getFlash().setKeepMessages(true);        
    }
    
    public void salvar() {
        if(dao.Salvar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro salvo com sucesso!");
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
        }
        
    }
    
    public String apagar() {
        if(dao.Apagar(entidade)) {
            MensagemSucesso("Sucesso!", "Registro removido com sucesso!");
            return "listagemClientes.xhtml";
        } else {
            MensagemErro("Erro!", "Consulte o administrador do sistema!");
            return null;
        }
        
    }
    
    public String voltar() {
        return "listagemClientes.xhtml";
    }
    
     public String filtrar() {
        return "listagemClientes.xhtml";
    }
     
     public String limparfiltros() {
         filtro = new Cliente();
        return "listagemClientes.xhtml";
    }
    
    public String novo() {
        entidade = new Cliente();
        return "editarCliente.xhtml";
    }
    
    public String abrir(Cliente obj) {
        entidade = obj;
        return "editarCliente.xhtml";
    }
    
    public List<Cliente> getListagem() {
        return dao.Buscar(filtro);
    }
    
}
