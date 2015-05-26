/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.MeuPrimeiroJSF.Controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author petronio
 */
@Named(value = "testeController")
@SessionScoped
public class testeController implements Serializable {

    /**
     * Creates a new instance of testeController
     */
    public testeController() {
        valor1 = 0;
        valor2 = 0;
        resultado = 0;
    }
    
    private Integer valor1;
    private Integer valor2;
    private Integer resultado;

    public Integer getValor1() {
        return valor1;
    }

    public void setValor1(Integer valor1) {
        this.valor1 = valor1;
    }

    public Integer getValor2() {
        return valor2;
    }

    public void setValor2(Integer valor2) {
        this.valor2 = valor2;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
    
    public void somar() {
        resultado = valor1 + valor2;
    }
    
    
}
