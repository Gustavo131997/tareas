
package TestCurso;

import java.util.Scanner;

public class TestCurso{
    
    public static void main(String[] args){
        String nombrecurso,codigo,modulo;
        String nombrealumno, apellido, rut, matricula;
        Scanner leer = new Scanner(System.in);
        String opc1, resp;
        System.out.println("Bienvenido al intranet");
        System.out.println("-------------------------------------");
        Curso Curso1 = new Curso();
        System.out.println("Ingrese nombre del curso");
        nombrecurso = leer.nextLine();
        Curso1.setNombredecurso(nombrecurso);
        do{
            System.out.println("Ingrese codigo del curso");
            codigo = leer.next();
            Curso1.setCodigo_curso(codigo);
        }while(Curso1.getCodigo_curso() == null);
        do{
            System.out.println("Ingrese modulo del curso");
            modulo = leer.next();
            Curso1.setModulo(modulo);
        }while(Curso1.getModulo() == null);

       do{
            System.out.println("\n Bienvenido al menu del Curso"
                              + "\n\n\t 1. Agregar alumno al Curso."
                              + "\n\t 2. Eliminar alumno del Curso."
                              + "\n\t 3. Buscar Alumno."
                              + "\n\t 4. Mostrar Curso \n"
                              + "Ingrese opcion:");
            opc1 = leer.next();
            switch(opc1){
                case "1" :  Alumno alumno1 = new Alumno(); 
                            System.out.println("Ingrese nombre del Alumno");
                            nombrealumno = leer.next();
                            alumno1.setNombre(nombrealumno);
                            System.out.println("Ingrese apellido del Alumno");
                            apellido = leer.next();
                            alumno1.setApellido(apellido);
                            do{
                                System.out.println("Ingrese rut de alumno (example: xx.xxx.xxx-x)");
                                rut = leer.next();
                                alumno1.setRut(rut);
                            }while(alumno1.getRut() == null);
                            do{
                                System.out.println("Ingrese numero de matricula");
                                matricula = leer.next();
                                alumno1.setNumero_de_matricula(matricula);
                            }while(alumno1.getNumero_de_matricula() == null);
                            Curso1.AñadirAlumno(alumno1);
                break;
                case "2":   System.out.println("Ingrese nombre del alumno");
                            nombrealumno = leer.next();
                            System.out.println("Ingrese apellido del alumno");
                            apellido = leer.next();
                            Curso1.EliminarAlumno(nombrealumno, apellido);
                break;
                case "3":   System.out.println("Ingrese rut de alumno a buscar (example: xx.xxx.xxx-x)");
                            rut = leer.next();
                            Curso1.ResultadoBusqueda(rut);
                break;
                case "4": Curso1.toString();
                break;
                default: System.out.println("Opcion no valida"); break;
            }
               System.out.println("¿Desea Continuar?(si/no)");
            resp = leer.next();
       }while("si".equals(resp.toLowerCase()));
           
    }
    
}
