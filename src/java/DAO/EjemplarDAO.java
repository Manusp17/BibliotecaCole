
package DAO;

import Modelo.Ejemplar;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Persistencia.NewHibernateUtil;

import java.util.List;

public class EjemplarDAO {
    
      public void guardar(Ejemplar ejemplar) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(ejemplar);
        tx.commit();
        session.close();
    }

    public void actualizar(Ejemplar ejemplar) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(ejemplar);
        tx.commit();
        session.close();
    }

    public void eliminar(Ejemplar ejemplar) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ejemplar);
        tx.commit();
        session.close();
    }

    public Ejemplar obtenerPorId(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Ejemplar ejemplar = session.get(Ejemplar.class, id);
        session.close();
        return ejemplar;
    }

    public List<Ejemplar> listarTodos() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Ejemplar> lista = session.createQuery("from Ejemplar").list();
        session.close();
        return lista;
    }
}
