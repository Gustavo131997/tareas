package TestCurso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curso {
    
    private String nombredecurso;
    private String modulo;
    private String codigo_curso;
    private final ArrayList<Alumno> alumnos ;
    public Curso() {
        this.alumnos = new ArrayList<>();
    }

    public Curso( String nombredecurso, String codigo_curso, String modulo) {
        this.nombredecurso = nombredecurso;
        Pattern patt = Pattern.compile("[0-9]+");
        Matcher matc = patt.matcher(modulo);
        if (matc.matches()) {
            this.modulo = modulo;
        }
        Pattern pat = Pattern.compile("[A-Z]{3,3}-[0-9]{3,3}");
        Matcher mat = pat.matcher(codigo_curso);
        if (mat.matches()) {
            this.codigo_curso = codigo_curso;
        }
         alumnos = new ArrayList<>();
    }

    public String getNombredecurso() {
        return nombredecurso;
    }

    public void setNombredecurso(String nombredecurso) {
        this.nombredecurso = nombredecurso;
    }

    public String getModulo() {
        return modulo;
    }
    
    public void setModulo(String modulo) {
        Pattern patt = Pattern.compile("[0-9]+");
        Matcher matc = patt.matcher(modulo);
        if (matc.matches()) {
            this.modulo = modulo;
        }
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        Pattern pat = Pattern.compile("[A-Z]{3,3}-[0-9]{3,3}");
        Matcher mat = pat.matcher(codigo_curso);
        if (mat.matches()) {
            this.codigo_curso = codigo_curso;
        }
    }
    public void AñadirAlumno(Alumno alumno) {
        if(Coicidencias(alumno.getNombre(),alumno.getApellido(),alumno.getRut(),alumno.getNumero_de_matricula()) == null){
        this.alumnos.add(alumno);
        }else{
            System.out.println("El alumno ya existe");
        }
    }   
    private Alumno Coicidencias(String nombre,String apellido,String rut, String matricula){
        Alumno resultado = null;
    for (Alumno alumno : alumnos) {
        if (alumno.getNombre().equals(nombre) && alumno.getApellido().equals(apellido) && alumno.getRut().equals(rut) && alumno.getNumero_de_matricula().equals(matricula)) {
            resultado = alumno;
            break;
        }
    }
    return resultado;
    }
    public void EliminarAlumno(String nombre , String apellido){
        if(BuscarAlumno(nombre,apellido) != null){
      this.alumnos.remove(BuscarAlumno(nombre,apellido));
      System.out.println("Ha sido elimnado");
      }else{
          System.out.println("El alumno que desea eliminar no exite ");
      }
    }
    private Alumno BuscarAlumno(String nombre, String apellido) {
    
    Alumno resultado = null;
    for (Alumno alumno : alumnos) {
        if (alumno.getNombre().equals(nombre) && alumno.getApellido().equals(apellido)) {
            resultado = alumno;
            break;
        }
    }
    return resultado;
    }
    @Override
     public String toString() 
    {
        System.out.println("Curso: " + nombredecurso + "\t codigo del curso: " + codigo_curso + "\t modulo: " + modulo );
        for (Iterator i = this.alumnos.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
        System.out.println("Total de Alumnos: "+this.alumnos.size());
        return "fin curso";
    }
    private Alumno BuscaPerfil(String rut) {
    Pattern pat = Pattern.compile("[0-9]{1,2}.[0-9]{3,3}.[0-9]{3,3}-[0-9]{1,1}");
        Matcher mat = pat.matcher(rut);
        if (mat.matches()) {
         Alumno resultado = null;
            for (Alumno alumno : this.alumnos) {
                    if (alumno.getRut().equals(rut)) {
                        resultado = alumno;
                        break;
                    }
            }
            return resultado;
        } else {
         return null;
        }
    }
    public void ResultadoBusqueda(String rut){
       if(BuscaPerfil(rut) != null ){
          System.out.println("Resultado de la Busqueda");
          System.out.println("Nombre de Alumno: "+ BuscaPerfil(rut).getNombre()+ " " + BuscaPerfil(rut).getApellido() +
             " \n Rut: "+BuscaPerfil(rut).getRut() +"\t Numero de Matricula: "+BuscaPerfil(rut).getNumero_de_matricula());
        }else{
            System.out.println("No se encontra el rut indicado(verifique si el rut ingresado tiene el formato correcto)");
        }
    
    }
    
}
