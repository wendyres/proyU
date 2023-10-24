package apifestivos.apifestivos.contoladores;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.Interfaces.IFestivoServicio;

@RestController
@RequestMapping("/festivos")
public class contolador {
    @Autowired
    private IFestivoServicio servicio;
@RequestMapping(value ="/verificar/{año}/{mes}/{dia}",method = RequestMethod.GET)
public String verificarfestivo(@PathVariable int año,@PathVariable int mes, @PathVariable int dia){
     String fechaString= Integer.valueOf(año)+"-"+ Integer.valueOf(mes)+"-"+ Integer.valueOf(dia);
     if (!servicio.esFechaValida(fechaString)){ 
        return "fecha no valida";
     }else{
        Calendar fecha=Calendar.getInstance();
        fecha.set(año,mes-1,dia);
        if (servicio.esFestivo(fecha.getTime()))
        return "es festivo";
        else return "no es festivo";
     }

     

    }
    
}

