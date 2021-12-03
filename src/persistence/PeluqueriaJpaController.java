/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.Peluqueria;
import persistence.exceptions.NonexistentEntityException;
import persistence.exceptions.PreexistingEntityException;

/**
 *
 * @author D_Soft_01
 */
public class PeluqueriaJpaController implements Serializable {

    public PeluqueriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PeluqueriaJpaController(){
        this.emf = Persistence.createEntityManagerFactory("ProyectoRRHH_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Peluqueria peluqueria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(peluqueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeluqueria(peluqueria.getClienteN()) != null) {
                throw new PreexistingEntityException("Peluqueria " + peluqueria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Peluqueria peluqueria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            peluqueria = em.merge(peluqueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = peluqueria.getClienteN();
                if (findPeluqueria(id) == null) {
                    throw new NonexistentEntityException("The peluqueria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Peluqueria peluqueria;
            try {
                peluqueria = em.getReference(Peluqueria.class, id);
                peluqueria.getClienteN();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The peluqueria with id " + id + " no longer exists.", enfe);
            }
            em.remove(peluqueria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Peluqueria> findPeluqueriaEntities() {
        return findPeluqueriaEntities(true, -1, -1);
    }

    public List<Peluqueria> findPeluqueriaEntities(int maxResults, int firstResult) {
        return findPeluqueriaEntities(false, maxResults, firstResult);
    }

    private List<Peluqueria> findPeluqueriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Peluqueria.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Peluqueria findPeluqueria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Peluqueria.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeluqueriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Peluqueria> rt = cq.from(Peluqueria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
