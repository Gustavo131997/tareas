/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa01;
import java.util.*;
/**
 *
 * @author Gustavo Huerta
 */
public class Programa01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a=0, n , resp1=0;
        String resp="No", Resp;
        Scanner leer = new Scanner(System.in);
        System.out.println("Indique el numero de estimados a encuestar");
        n = leer.nextInt();
        char [][] encuesta = new char [2][n];
        int cont =0, contHAprueban=0 , contMdesaprueban=0, contRespondieron=0, contMAprueban = 0;
        do {
            
            do{
            System.out.println("Indique sexo: (M o F)");
            Resp= leer.next();
            }while(!"M".equals(Resp) && !"F".equals(Resp));
            do{
            System.out.println("Responda: ¿Aprueba la gestión del gobierno? Si:1 No:2 No sabe o no responde: 3 (equivalente a las dos casillas)");
            resp1 = leer.nextInt();
            }while(resp1 >3 || resp1 <= 0);
            LlenarMatriz(cont ,resp1 ,encuesta);
            if ("F".equals(Resp) && resp1 == 2) {
                contMdesaprueban++;
            }
            if ("M".equals(Resp) && resp1 == 1) {
                contHAprueban++;
            }
            if ("F".equals(Resp)&& resp1 == 1) {
                
                contMAprueban++;
            }
            if( ("F".equals(Resp) && resp1== 1) || ("M".equals(Resp) && resp1 ==1) || ("F".equals(Resp) && resp1==2) || ("M".equals(Resp) && resp1 ==2)){
            
                            contRespondieron++;
                    
            }
            cont++;
        
         } while (cont != n);
        System.out.println("Cantidad de Hombres que aprueban el gobierno:"+contHAprueban);
        System.out.println("Cantida de Mujeres que desaprueban el gobierno:"+contMdesaprueban);
        System.out.println("Porcentaje de encuestado que aprueba el gobierno:"+((100*(contMAprueban+contHAprueban))/cont)+"%");
        System.out.println("Cantidad de personas que participaron la encuesta:"+contRespondieron);
        MostrarMatriz(cont,encuesta);
    }
    public static void LlenarMatriz(int cont , int resp1 , char [][] encuesta){
        if (resp1== 1 ) {
                encuesta[0][cont]= 1;
            }
            if(resp1 == 2) {
                encuesta[1][cont]=2;
            }
            if (resp1 == 3) {
                encuesta[0][cont]=3;
                encuesta[1][cont]=3;
            }
    }
    public static void MostrarMatriz(int cont , char[][] encuesta){
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(encuesta[j][i]+"\t");
            }
            System.out.println();
        }
    }
}
