/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import br.edu.ifnmg.TesteJPA.DomainModel.Produto;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ProdutoRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author petronio
 */
@Named(value = "produtoController")
@SessionScoped
public class ProdutoController extends ControllerGenerico<Produto> implements Serializable {

    /**
     * Creates a new instance of testeController
     */
    public ProdutoController() {
        super("listagemProdutos.xhtml","editarProduto.xhtml");
        entidade = new Produto();
        filtro = new Produto();
        filtro.setPreco(null);
    }
    
    @EJB
    private ProdutoRepositorio repositorio;

    @PostConstruct
    public void configurar(){
        setDao(repositorio);
    }
    
}
