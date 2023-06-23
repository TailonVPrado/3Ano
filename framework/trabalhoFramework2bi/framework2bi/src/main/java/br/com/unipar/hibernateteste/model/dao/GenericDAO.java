package br.com.unipar.hibernateteste.model.dao;

import br.com.unipar.hibernateteste.model.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;


public abstract class GenericDAO<T> {
    
    private final Class<T> clazz;
    protected EntityManager em;
    
    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
        this.em = EntityManagerUtil.getManager();
    }
    
    public void fechar() {
        em.close();
    }
    
    public T save(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ops, algo deu errado \n" + e);
        } finally{
            fechar();
        }
        return entity;
    }
    
    public T update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        fechar();
        return entity;
    }
    
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        
        //fechar();
    }
    
    public T findById(Long id) {
        return em.find(clazz, id);
    }
    
    public List<T> findAll() {
        String jpql = "from "+clazz.getSimpleName();
        TypedQuery<T> query = em.createQuery(jpql, clazz);
        return query.getResultList();
    }
    
    public List<T> findWithParam(int id) {
        String jpql = "from "+clazz.getSimpleName()+" where id_agendamento = "+id;
        TypedQuery<T> query = em.createQuery(jpql, clazz);
        return query.getResultList();
    }
    
    public List<T> findCityWithEstado(String desc){
        String jpql = "from estado, "+clazz.getSimpleName()+" where cod_estado = estado.codigo and estado.nome = "+desc;
        TypedQuery<T> query = em.createQuery(jpql, clazz);
        return query.getResultList();
    }
}   
