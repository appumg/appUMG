package com.appumg2016gmail.appumg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class himno_u extends Fragment {

    private static final String llave_api = "AIzaSyAN09prJVmobwDKuDTiX0UaqBfaDYyYQwI";
    private static String id_video = "FCH6bZWrlig";


    TextView encabezado;
    TextView coro;
    TextView coro2;




    public himno_u() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_himno_u, container, false);


        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(llave_api, new OnInitializedListener() {

            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(id_video);
                    player.pause();//dejamos en pausa el video, por defecto!!
                }
            }


            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        encabezado=(TextView)v.findViewById(R.id.T_HimnoEncabezado);
        coro=(TextView)v.findViewById(R.id.T_HimnoCoro);
        coro2=(TextView)v.findViewById(R.id.T_HimnoCoro2);

        encabezado.setText("Alma Mater, tu origen cristiano\n" +
                "Entroniza en la Patria el deber\n" +
                "Y remonta su luz al Arcano.\n" +
                "\n" +
                "Como un signo que irradia saber.\n" +
                "Al llamado puntual de la Ciencia\n" +
                "Acudimos con paso triunfal:\n" +
                "La Verdad es tu fértil herencia\n" +
                "Libertad, es tu lema inmortal.\n");


        coro.setText("\nEstudiantes de Mariano Gálvez\n" +
                "Honrad siempre a vuestra Universidad,\n" +
                "Con la entrega al estudio encomiable\n" +
                "Proclamad el Amor, la Verdad.\n" +
                "\n" +
                "Alma Mater, tu Augusta raigambre\n" +
                "Es un símbolo de alta virtud,\n" +
                "En tus aulas un cálido enjambre\n" +
                "Le da mieles a la Juventud.\n" +
                "\n" +
                "Egresados, volved jubilosos\n" +
                "Con el triunfo ceñido en la sien\n" +
                "Compartid los recursos gloriosos\n" +
                "Que os hicieron personas de bien.\n");

        coro2.setText("\nEstudiantes de Mariano Gálvez\n" +
                "Honrad siempre a vuestra Universidad,\n" +
                "Con la entrega al estudio encomiable\n" +
                "Proclamad el Amor, la Verdad.");


        return v;

    }

    public void insertarText(){


    }
}
