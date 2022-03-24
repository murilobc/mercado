package br.senai.model.dao;

import br.senai.connection.JpaConnectionFactory;
import br.senai.model.persistence.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    EntityManager entityManager;

    public CategoriaDAO() {
        this.entityManager = new JpaConnectionFactory().getEntityManager();
    }

    public void criar(Categoria categoria) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(categoria);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
    }

    public void apagar(Categoria categoria) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(categoria);
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
    }

    public List<Categoria> listar() {
        String jpql = "SELECT c FROM Categoria c";
        return getEntityManager().createQuery(jpql, Categoria.class).getResultList();
    }
    public Categoria procurar(Long id) {
        return getEntityManager().find(Categoria.class, id);
    }

    public List<Categoria> procurar(String nome) {

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
