
package Beans;

import DAO.MoraDAO;
import Modelo.Mora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class MoraBean {

    private Mora mora = new Mora();
    private List<Mora> moras;
    private MoraDAO dao = new MoraDAO();

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public List<Mora> getMoras() {
        if (moras == null) {
            moras = dao.listarTodos();
        }
        return moras;
    }

    public void guardar() {
        if (mora.getIdMora() == 0) {
            dao.guardar(mora);
        } else {
            dao.actualizar(mora);
        }
        limpiar();
    }

    public void eliminar(Mora m) {
        dao.eliminar(m);
        moras = null;
    }

    public void editar(Mora m) {
        this.mora = m;
    }

    public void limpiar() {
        mora = new Mora();
    }
    
    
}
