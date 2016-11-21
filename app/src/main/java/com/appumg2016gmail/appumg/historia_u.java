package com.appumg2016gmail.appumg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class historia_u extends Fragment {


    public historia_u() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_historia_u, container, false);
    /*    TextView historia=(TextView)vista.findViewById(R.id.TV_historia);
          historia.setText("El primer ciclo académico de la Universidad Mariano Gálvez, se inició el 2 de marzo de 1966 en acto solemne en el que el Rector de la Universidad de San Carlos de Guatemala, pronunció el discurso de salutación y el primer Rector de la naciente Universidad pronunció el discurso de inauguración.\n" +
                "\n" +
                "En 1968, la Universidad Mariano Gálvez abrió las carreras de Derecho, Economía, Ingeniería Civil, Administración de Empresas, Teología y Humanidades. Posteriormente se abrieron carreras cortas en Pedagogía y Artes Plásticas, Gerencia, Economía Aduanera y Visita Médica.\n" +
                "\n" +
                "Las primeras instalaciones utilizadas por la Universidad fueron ambientes del edificio de la Antigua Escuela de Enfermeras del Hospital Americano.\n" +
                "\n" +
                "En el año de 1972 la Universidad inició su traslado al Campus Central actual, donde ha desarrollado una infraestructura física que incluye complejos para Observatorio, Biblioteca, un Teatro al aire libre, jardines, un bosque ecológico, un centro de cómputo e instalaciones deportivas.");
*/
        return vista;
    }

}
