/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.TesteJPA.Presentation;

import br.edu.ifnmg.TesteJPA.DataAccess.ClienteDAO;
import br.edu.ifnmg.TesteJPA.DataAccess.ProdutoDAO;
import br.edu.ifnmg.TesteJPA.DataAccess.VendaDAO;
import br.edu.ifnmg.TesteJPA.DomainModel.Cliente;
import br.edu.ifnmg.TesteJPA.DomainModel.Produto;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ClienteRepositorio;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.ProdutoRepositorio;
import br.edu.ifnmg.TesteJPA.DomainModel.Repositorios.VendaRepositorio;
import br.edu.ifnmg.TesteJPA.DomainModel.Venda;
import java.math.BigDecimal;

/**
 *
 * @author petronio
 */
public class ExemploJPA {

    static ClienteRepositorio clientes = new ClienteDAO();
    static ProdutoRepositorio produtos = new ProdutoDAO();
    static VendaRepositorio vendas = new VendaDAO();

    public static void criaBancoInicial() {
            Cliente c1 = new Cliente();
        c1.setNome("Petrônio");
        c1.setCpf("920.489.366-72");
        if (clientes.Salvar(c1)) {
            System.out.println(c1 + " Salvo");
        } else {
            System.out.println(c1 + " Não Salvo!");
        }

        Cliente c2 = new Cliente();
        c2.setNome("José");
        c2.setCpf("111.111.111-11");
        if (clientes.Salvar(c2)) {
            System.out.println(c2 + " Salvo");
        } else {
            System.out.println(c2 + " Não Salvo!");
        }

        Produto p1 = new Produto("Escova de Dente", new BigDecimal("2.00"), 10);
        produtos.Salvar(p1);
        Produto p2 = new Produto("Ovos de galinha", new BigDecimal("6.00"), 10);
        produtos.Salvar(p2);
        Produto p3 = new Produto("Camisinha", new BigDecimal("5.00"), 10);
        produtos.Salvar(p3);
        Produto p4 = new Produto("Arroz", new BigDecimal("3.50"), 10);
        produtos.Salvar(p4);
        Produto p5 = new Produto("Feijão", new BigDecimal("2.00"), 10);
        produtos.Salvar(p5);

        Venda v1 = new Venda(c1);
        v1.addItem(p1, 1);
        v1.addItem(p2, 1);
        v1.addItem(p3, 5);

        vendas.Salvar(v1);
    }

    public static void main(String[] args) {

        Produto filtro = new Produto();
        filtro.setPreco(null);
        filtro.setNome("nha");

        
        for(Produto p : produtos.Buscar(filtro))
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getPreco());

    }

}
