/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DataAccess;

import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.VendaRepositorio;
import br.edu.ifnmg.TesteJPA.DomainModel.Venda;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author petronio
 */
@Singleton
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio{

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public List<Venda> Buscar(Venda filtro) {
        return IgualA("cliente", filtro.getCliente())
                .IgualA("criacao", filtro.getCriacao())
                .IgualA("id", filtro.getId())
                .IgualA("valorTotal", filtro.getValorTotal())
                .OrderBy("criacao", "DESC")
                .Buscar();
    }
    
}
