package TestCurso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {
    private String nombre;
    private String apellido;
    private String rut ;
    private String numero_de_matricula;

    public Alumno() {
    }


    public Alumno(String nombre, String apellido, String rut, String numero_de_matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        Pattern pat = Pattern.compile("[0-9]{1,2}.[0-9]{3,3}.[0-9]{3,3}-[0-9]{1,1}");
        Matcher mat = pat.matcher(rut);
        if (mat.matches()) {
          this.rut = rut;  
        }
        Pattern pate = Pattern.compile("[0-9]{10,11}");
        Matcher mate = pate.matcher(numero_de_matricula);
        if (mate.matches()) {
          this.numero_de_matricula = numero_de_matricula;  
        }
    }
    
    
    public String getNombre() {
        return nombre;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        Pattern pat = Pattern.compile("[0-9]{1,2}.[0-9]{3,3}.[0-9]{3,3}-[0-9]{1,1}");
        Matcher mat = pat.matcher(rut);
        if (mat.matches()) {
         this.rut = rut;
     } else {
         System.out.println("No se ajusta al formato");
     }
    }

    public String getNumero_de_matricula() {
        return numero_de_matricula;
    }

    public void setNumero_de_matricula(String numero_de_matricula) {
    Pattern pat = Pattern.compile("[0-9]{10,11}");
        Matcher mat = pat.matcher(numero_de_matricula);
        if (mat.matches()) {
            this.numero_de_matricula = numero_de_matricula;
        }else{
            System.out.println("No se ajusta el formato");
        }
        
        }
    

    @Override
    public String toString() {
        return "Nombre del Alumno: " + nombre + " " + apellido + " \n rut:" + rut + " \t numero de matricula:" + numero_de_matricula  ;
    }
  
}
