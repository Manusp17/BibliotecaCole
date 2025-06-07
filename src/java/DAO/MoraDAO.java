
package DAO;

import Modelo.Mora;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Persistencia.NewHibernateUtil;

import java.util.List;

public class MoraDAO {
    
    public void guardar(Mora mora) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(mora);
        tx.commit();
        session.close();
    }

    public void actualizar(Mora mora) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(mora);
        tx.commit();
        session.close();
    }

    public void eliminar(Mora mora) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(mora);
        tx.commit();
        session.close();
    }

    public Mora obtenerPorId(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Mora mora = session.get(Mora.class, id);
        session.close();
        return mora;
    }

    public List<Mora> listarTodos() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Mora> lista = session.createQuery("from Mora").list();
        session.close();
        return lista;
    }
}
