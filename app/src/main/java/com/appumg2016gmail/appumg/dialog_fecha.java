package com.appumg2016gmail.appumg;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import java.util.Calendar;

/**
 * Created by zombozo on 17/10/2016.
 */

public class dialog_fecha extends DialogFragment {
    private LayoutInflater builder;


    public Dialog createSimpleDialog(Bundle savedInstanceState){
        final Calendar calendario=Calendar.getInstance();
        int dia=calendario.get(Calendar.DAY_OF_MONTH);
        int mes=calendario.get(Calendar.MONTH);
        int year=calendario.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),dia,mes,year);
    }


}
