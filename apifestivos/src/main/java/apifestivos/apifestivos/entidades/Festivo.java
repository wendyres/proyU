package apifestivos.apifestivos.entidades;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="festivo")
public class Festivo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO , generator="secuencia festivo")
    @GenericGenerator(name="secuencia festivo", strategy="increment")
    private long id;

    @Column(name="nombre",length = 100)
    private String nombre;

    @Column(name="dia")
    private int dia;

    @Column(name="mes")
    private int mes;

    @Transient
    private int año;

    @Column(name="diaspascua")
    private int diasPascua;

    @ManyToOne
    @JoinColumn(name="idtipo",referencedColumnName="id")
    private Tipo tipo;
    

    public Festivo() {
    }

    public Festivo(long id, String nombre, int dia, int mes, int diasPascua, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
    }

    public Festivo(long id, String nombre, int dia, int mes, int año, int diasPascua, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public void setFecha (Date fecha){
    Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        this.dia=calendar.get(Calendar.DAY_OF_MONTH);
        this.mes=calendar.get(Calendar.MONTH)+1;
        this.año=calendar.get(Calendar.YEAR);

    }

    public Date getFecha(){
        Calendar calendar=Calendar.getInstance();
         calendar.set(this.año, this.mes-1,this.dia);
         return calendar.getTime();
        
    }

    




}
