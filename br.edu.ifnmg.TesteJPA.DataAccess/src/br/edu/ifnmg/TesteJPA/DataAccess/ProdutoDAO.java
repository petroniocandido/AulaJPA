/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Produto;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ProdutoRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
@Singleton
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio{

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> Buscar(Produto filtro) {
        
        return  IgualA("id", filtro.getId())
                .IgualA("preco", filtro.getPreco())
                .Like("nome", filtro.getNome())
                .OrderBy("nome", "Asc")
                .Buscar();
        
    }
    
}
