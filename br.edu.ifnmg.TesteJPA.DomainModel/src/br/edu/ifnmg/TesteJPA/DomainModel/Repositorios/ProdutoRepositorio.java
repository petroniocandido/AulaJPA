/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DomainModel.Repositorios;

import br.edu.ifnmg.TesteJPA.DomainModel.Produto;
import javax.ejb.Local;

/**
 *
 * @author petronio
 */
@Local
public interface ProdutoRepositorio extends Repositorio<Produto> {
    
}
