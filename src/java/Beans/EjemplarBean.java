
package Beans;

import DAO.EjemplarDAO;
import Modelo.Ejemplar;
import Modelo.Material;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class EjemplarBean implements Serializable {

   
    private Ejemplar ejemplar = new Ejemplar();
    private List<Ejemplar> ejemplares;
    private EjemplarDAO dao = new EjemplarDAO();

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public List<Ejemplar> getEjemplares() {
        if (ejemplares == null) {
            ejemplares = dao.listarTodos();
        }
        return ejemplares;
    }

    public void guardar() {
        if (ejemplar.getIdEjemplar() == 0) {
            dao.guardar(ejemplar);
        } else {
            dao.actualizar(ejemplar);
        }
        limpiar();
    }

    public void eliminar(Ejemplar e) {
        dao.eliminar(e);
        ejemplares = null;
    }

    public void editar(Ejemplar e) {
        this.ejemplar = e;
    }

    public void limpiar() {
        ejemplar = new Ejemplar();
        ejemplar.setEstado("Disponible");
    }
    
}
