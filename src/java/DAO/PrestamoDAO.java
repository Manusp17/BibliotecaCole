
package DAO;

import Modelo.Prestamo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Persistencia.NewHibernateUtil;
import java.util.List;

public class PrestamoDAO {
    
     public void guardar(Prestamo prestamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(prestamo);
        tx.commit();
        session.close();
    }

    public void actualizar(Prestamo prestamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(prestamo);
        tx.commit();
        session.close();
    }

    public void eliminar(Prestamo prestamo) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(prestamo);
        tx.commit();
        session.close();
    }

    public Prestamo obtenerPorId(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Prestamo prestamo = session.get(Prestamo.class, id);
        session.close();
        return prestamo;
    }

    public List<Prestamo> listarTodos() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Prestamo> lista = session.createQuery("from Prestamo").list();
        session.close();
        return lista;
    }
}
