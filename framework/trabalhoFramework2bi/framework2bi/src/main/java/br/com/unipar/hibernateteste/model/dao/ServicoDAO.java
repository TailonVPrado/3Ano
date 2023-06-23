package br.com.unipar.hibernateteste.model.dao;

import br.com.unipar.hibernateteste.model.usuario.Servico;
import javax.persistence.TypedQuery;

public class ServicoDAO extends GenericDAO<Servico>{
  public ServicoDAO() {
        super(Servico.class);
    }

    public Servico findByDescricao(String descricao) {
        String jpql = "from Servico where descricao = :desc";
        TypedQuery<Servico> query = em.createQuery(jpql, Servico.class).setParameter("desc", descricao);
        return query.getSingleResult();
        
        
    }
    
    
}
