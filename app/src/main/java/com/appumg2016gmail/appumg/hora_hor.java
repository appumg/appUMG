package com.appumg2016gmail.appumg;

import java.util.ArrayList;

/**
 * Created by Manuel on 9/11/2016.
 */

public class hora_hor {
    ArrayList<String> hora=new ArrayList<>();

    public hora_hor(String hora0, String hora1,String hora2,String hora3,String hora4) {
        hora.add(hora0);
        hora.add(hora1);
        hora.add(hora2);
        hora.add(hora3);
        hora.add(hora4);

    }

    public String getHora(int i) {
        return hora.get(i);
    }


}
