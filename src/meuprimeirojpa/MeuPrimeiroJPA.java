/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuprimeirojpa;

import br.edu.ifnmg.AS.DomainModel.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class MeuPrimeiroJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadePersistencia");
        EntityManager manager = factory.createEntityManager();

        Disciplina as = new Disciplina();
        as.setNome("Arquitetura de Software");
        as.setCargaHoraria(72);

        EntityTransaction t = manager.getTransaction();

        t.begin();

        try {
            manager.persist(as);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
            ex.printStackTrace();
        }
        
        
        Query consulta = manager.createQuery("select o from Disciplina o", Disciplina.class);
        
        List<Disciplina> lista = consulta.getResultList();
        
        for(Disciplina d : lista)
            System.out.println(d.getNome());
        
    }

}
