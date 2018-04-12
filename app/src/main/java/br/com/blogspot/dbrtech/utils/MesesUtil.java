package br.com.blogspot.dbrtech.utils;

/**
 * Created by diogo on 02/03/2017.
 */

public class MesesUtil {
    private int num;
    private String mes;

    private String[] mesesArray = {"Janeiro","Fevereiro", "Março","Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
            "Novembro", "Dezembro"} ;

    public String[] getMesesArray() {
        return mesesArray;
    }

    public int Convert(String s) {
       if (s.equals(mesesArray[0])) {
           num = 0;
       }else if (s.equals(mesesArray[1])){
                num = 1;
       }else if (s.equals(mesesArray[2])){
           num = 2;
       }else if (s.equals(mesesArray[3])){
           num = 3;
       }else if (s.equals(mesesArray[4])){
           num = 4;
       }else if (s.equals(mesesArray[5])){
           num = 5;
       }else if (s.equals(mesesArray[6])){
           num = 6;
       }else if (s.equals(mesesArray[7])){
           num = 7;
       }else if (s.equals(mesesArray[8])){
           num = 8;
       }else if (s.equals(mesesArray[9])){
           num = 9;
       }else if (s.equals(mesesArray[10])){
           num = 10;
       }else if (s.equals(mesesArray[11])){
           num = 11;
       }


       return num;
   }

    public String ConvertIntToMes(int i) {
        if (i == 0) {
            mes =(mesesArray[0]);
        }else if (i == 1){
            mes =(mesesArray[1]);
        }else if (i == 2){
            mes =(mesesArray[2]);
        }else if (i == 3){
            mes =(mesesArray[3]);
        }else if (i == 4){
            mes =(mesesArray[4]);
        }else if (i == 5){
            mes =(mesesArray[5]);
        }else if (i == 6){
            mes =(mesesArray[6]);
        }else if (i == 7){
            mes =(mesesArray[7]);
        }else if (i == 8){
            mes =(mesesArray[8]);
        }else if (i == 9){
            mes =(mesesArray[9]);
        }else if (i == 10){
            mes =(mesesArray[10]);
        }else if (i == 11){
            mes =(mesesArray[11]);
        }


        return mes;
    }

}

