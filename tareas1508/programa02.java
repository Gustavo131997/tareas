/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema02;
import java.util.*;
/**
 *
 * @author Gustavo Huerta
 */
public class Problema02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] cuadroMagico = new int[3][3];
        Scanner leer = new Scanner(System.in);
        LlenarMatriz(cuadroMagico);
        MostrarMatriz(cuadroMagico);
        if (condicionMagica(cuadroMagico)== true) {
            System.out.println("Es cuadro Magico");
        }
        else{
            System.out.println("No es cuadro magico");
        }
    }
    public static void LlenarMatriz(int [][] matriz){
        Random azar = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                matriz[i][j] = azar.nextInt(9)+1;
            }
        }
    }
    public static boolean condicionMagica(int [][] matriz){
        int j=0;
        for (int i = 0; i < 3; i++) {
            if (matriz[i][j] != matriz [i][j+1] && matriz[i][j] != matriz[i][j+2] && matriz[i][j+1] != matriz[i][j+2] && matriz[i][j]+matriz[i][j+1]+matriz[i][j+2]==15 &&
                    matriz[0][0]+matriz[1][1]+matriz[2][2]==15 && matriz[0][2]+matriz[1][1]+matriz[2][0]==15 ) {
                return true;
            }
    
        }
        return false ;
    }
    public static void MostrarMatriz (int [][] matriz){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
