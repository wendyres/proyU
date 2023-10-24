package apifestivos.apifestivos.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo")

public class Tipo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO , generator="secuencia tipo")
    @GenericGenerator(name="secuencia tipo", strategy="increment")
    private long id;

     @Column(name="tipo",length=100,unique = true)
    private String nombre;
    

    public Tipo() {
    }
    public Tipo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
