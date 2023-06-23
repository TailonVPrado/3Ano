package br.com.unipar.hibernateTeste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;

public class ConnectionTest {

    @Test
    public void testConnection(){
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // Carrega a unidade de persistência
            entityManagerFactory = Persistence.createEntityManagerFactory("NomeUnidadePersistencia");
            Assert.assertNotNull("Falha ao carregar EntityManagerFactory", entityManagerFactory);

            // Cria o EntityManager
            entityManager = entityManagerFactory.createEntityManager();
            Assert.assertNotNull("Falha ao criar EntityManager", entityManager);

            // Testa a conexão do banco
            boolean isConnected = entityManager.isOpen() && entityManager.getTransaction().isActive();
            Assert.assertTrue("Falha na conexão do banco", isConnected);

        } finally {
            // Fecha o EntityManager e o EntityManagerFactory
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

    }
    
}
