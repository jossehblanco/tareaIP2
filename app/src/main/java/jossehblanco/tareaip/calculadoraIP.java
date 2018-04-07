package jossehblanco.tareaip;

import java.util.Arrays;

/**
 * Created by UCA on 7/4/2018.
 */

public class calculadoraIP {
    private int[] ipByteArray, maskByteArray = {0,0,0,0};
    private int maskPrefix;
    public calculadoraIP(String direccionIP, int maskPrefix){
        //Conversion de la ip de string a un arreglo de ints, separados en 4 octetos
        String[] dir = direccionIP.split(".");
        for(int i = 0; i < 4; i++){
            this.ipByteArray[i] = Integer.parseInt(dir[0]);
        }
        this.maskPrefix = maskPrefix;
        //Metodo que convierte el prefijo a una mascara de Red trabajable
        this.generarMascara(this.maskPrefix);
    }
    private void generarMascara(int maskPrefix){
        int prefijo = maskPrefix;
        int contador = 0, cont_potencia = 7;

        while(contador < prefijo){
            if(cont_potencia < 0) cont_potencia = 7;
            if(contador < prefijo){
                maskByteArray[(int)contador/8] += 1* (Math.pow(2,cont_potencia));
                cont_potencia--;
            }
            contador++;
        }
    }
    public String genBroadcast(){
        String broadcast ="";
        for(int i = 0; i < 4; i++){

            if(i <= 2){
                broadcast += (ipByteArray[i]|(255-maskByteArray[i]));
                broadcast += ".";
            }else{
                broadcast += (ipByteArray[i]|(255-maskByteArray[i]));
            }
        }

        return broadcast;
    }
    public int genHosts(){
        return (int)(Math.pow(2, 32-maskPrefix)-2);
    }
    public String genNetId(){
        String netId ="";
        for(int i = 0; i < 4; i++){

            if(i <= 2){
                netId += (ipByteArray[i]&maskByteArray[i]);
                netId += ".";
            }else{
                netId += (ipByteArray[i]&maskByteArray[i]);
            }
        }

        return netId;
    }
}
