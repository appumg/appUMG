package com.appumg2016gmail.appumg;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Manuel on 9/11/2016.
 */

public class adapter_lista_horario extends BaseExpandableListAdapter {
    private Context contexto;
    private HashMap<String, List<String>> horario_semestre;
    private List<String> horario_lista;

    ArrayList<hora_hor> hora_curso;
    List<List<String>> catedraticos = new ArrayList<List<String>>();


    public adapter_lista_horario(Context contexto, HashMap<String, List<String>> horario_semestre, List<String> horario_lista, ArrayList<hora_hor>s, List<List<String>> cat) {
        this.contexto = contexto;
        this.horario_semestre = horario_semestre;
        this.horario_lista = horario_lista;
        this.hora_curso=s;
        this.catedraticos=cat;
    }





    @Override
    public int getGroupCount() {
        return horario_lista.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return horario_semestre.get(horario_lista.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return horario_lista.get(groupPosition);
    }

    @Override
    public Object getChild(int padre, int hijo) {
        return horario_semestre.get(horario_lista.get(padre)).get(hijo);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int padre, int hijo) {
        return hijo;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int padrePosicion, boolean isExpanded, View convertView, ViewGroup padreView) {
        String titulo_padre=(String) getGroup(padrePosicion);
        if (convertView ==null)
        {
            LayoutInflater inflador= (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
            convertView=inflador.inflate(R.layout.padre_lista_expansible, padreView,false);
        }
        TextView padraText=(TextView)convertView.findViewById(R.id.TV_padreLista);
        padraText.setTypeface(null, Typeface.BOLD);
        padraText.setText(titulo_padre);



        return convertView;
    }

    @Override
    public View getChildView(int padre, int hijo, boolean ultimoHijo, View convertView, ViewGroup vistaPadre) {
        String hijo_titulo= (String) getChild(padre,hijo);
        if(convertView==null)
        {
            LayoutInflater inflador=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
            convertView=inflador.inflate(R.layout.hijo_lista_horario, vistaPadre,false);
        }
        TextView hijoText=(TextView)convertView.findViewById(R.id.TV_HijoLista);
        hijoText.setText(hijo_titulo);

        TextView horaText=(TextView)convertView.findViewById(R.id.TV_Horario);
        horaText.setText(hora_curso.get(0).getHora(hijo));

        TextView catedratico_text=(TextView)convertView.findViewById(R.id.TV_Catedratico);
        catedratico_text.setText(catedraticos.get(padre).get(hijo));


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
