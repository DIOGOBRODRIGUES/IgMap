package br.com.blogspot.dbrtech.utils;

import android.graphics.Color;

/**
 * Created by diogo on 02/03/2017.
 */

public class BalColors {

    public static float magnitudeToColor(double magnitude) {

        if (magnitude <= -175) {
            //vermelho

            return  Color.parseColor("#D9f15f2d");

        } else if (magnitude <= -150) {

            return  Color.parseColor("#D9ea8d39");

        } else if (magnitude <= -125) {

            return  Color.parseColor("#D9e9b03d");

        } else if (magnitude <= -100) {

            return  Color.parseColor("#D9efc93a");

        } else if (magnitude <= -75) {

            return  Color.parseColor("#D9f4e137");

        } else if (magnitude <= -50) {
            //amarelo
            return  Color.parseColor("#D9f8fa35");

        } else if (magnitude <= -25) {

            return  Color.parseColor("#D9f8fa35");
        } else if (magnitude <= 0) {

            return  Color.parseColor("#D94ffade");
        } else if (magnitude <= 25) {
            //Azul
            return  Color.parseColor("#D91e5cd6");

        }else if (magnitude <= 140) {
            //Azul Escuro
            return  Color.parseColor("#D92934d5");

        }else if (magnitude <= 150) {
            //purple
            return  Color.parseColor("#D9632dd0");

        }
        else if (magnitude <= 160) {
            //roxo
            return  Color.parseColor("#D99c25cb");

        }

        else {
            //rosaclaro
            return Color.parseColor("#D9cd15be");


        }
    }
}
