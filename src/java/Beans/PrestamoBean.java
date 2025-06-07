
package Beans;

import DAO.PrestamoDAO;
import Modelo.Prestamo;
import Modelo.Usuario;
import Modelo.Ejemplar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class PrestamoBean implements Serializable{

    private Prestamo prestamo = new Prestamo();
    private List<Prestamo> prestamos;
    private PrestamoDAO dao = new PrestamoDAO();

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public List<Prestamo> getPrestamos() {
        if (prestamos == null) {
            prestamos = dao.listarTodos();
        }
        return prestamos;
    }

    public void guardar() {
        if (prestamo.getIdPrestamo() == 0) {
            dao.guardar(prestamo);
        } else {
            dao.actualizar(prestamo);
        }
        limpiar();
    }

    public void eliminar(Prestamo p) {
        dao.eliminar(p);
        prestamos = null;
    }

    public void editar(Prestamo p) {
        this.prestamo = p;
    }

    public void limpiar() {
        prestamo = new Prestamo();
        prestamo.setDevuelto("No");
        prestamo.setFechaPrestamo(new Date());
    }
}
