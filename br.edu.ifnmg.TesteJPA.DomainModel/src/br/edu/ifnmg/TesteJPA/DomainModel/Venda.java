/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.TesteJPA.DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author petronio
 */
@Entity
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne()
    private Cliente cliente;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;
    
    @Column(precision = 8, scale = 2)
    private BigDecimal valorTotal;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<ItemVenda> itens;

    public Venda() {
        this.criacao = new Date();
        this.valorTotal = new BigDecimal("0.00");
        this.itens = new ArrayList<>();
    }

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.criacao = new Date();
        this.valorTotal = new BigDecimal("0.00");
        this.itens = new ArrayList<>();
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public void addItem(Produto p, int qtd){
        ItemVenda i = new ItemVenda(this, p, qtd);
        if(!itens.contains(i)){
            itens.add(i);
            valorTotal = valorTotal.add(p.getPreco().multiply( BigDecimal.valueOf(qtd) ));
        }
    }
    
    public void addItem(ItemVenda i){
        if(itens.contains(i)){
            itens.remove(i);
            valorTotal = valorTotal.subtract(i.getProduto().getPreco().multiply( BigDecimal.valueOf(i.getQuantidade()) ));
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.TesteJPA.DomainModel.Venda[ id=" + id + " ]";
    }
    
}
