
package Beans;

import DAO.UsuarioDAO;
import Modelo.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

   private String email;
    private String contrasena;
    private Usuario usuarioAutenticado;

    private UsuarioDAO dao = new UsuarioDAO();

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Usuario getUsuarioAutenticado() { return usuarioAutenticado; }

    public String login() {
        usuarioAutenticado = dao.autenticar(email, contrasena);

        if (usuarioAutenticado != null) {
           switch (usuarioAutenticado.getRol()) {
            case Administrador:
                return "admin/index.xhtml?faces-redirect=true";
            case Profesor:
                return "profesor/index.xhtml?faces-redirect=true";
            case Alumno:
                return "alumno/index.xhtml?faces-redirect=true";
        }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", "Usuario o contraseña incorrectos"));
        }
       return null;
    }  
    

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }
    
}
