package Modelo;
// Generated 26-may-2025 2:25:21 by Hibernate Tools 4.3.1

import javax.persistence.*;

/**
 * Tesis generated by hbm2java
 */
@Entity
@Table(name = "Tesis")
@PrimaryKeyJoinColumn(name = "ID_Material")
public class Tesis extends Material  implements java.io.Serializable {


      @Column(name = "Universidad")
     private String universidad;
      @Column(name = "Carrera")
     private String carrera;

    public Tesis() {
    }

    public String getUniversidad() {
        return this.universidad;
    }
    
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }




}


