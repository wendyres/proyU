package apifestivos.apifestivos.Interfaces;

import java.util.Date;

public interface IFestivoServicio {
     public boolean esFestivo(Date fecha);

     public boolean esFechaValida(String strFecha);
    
}
