package br.com.blogspot.dbrtech.igmap;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;
import java.text.DecimalFormat;

import br.com.blogspot.dbrtech.utils.MesesUtil;

public class GeoJsonETPActivity extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "erro de autori";
    private int mes;
    private ProgressDialog progress;
    private GeoJsonLayer layer=null;
    GroundOverlayOptions newarkMap=null;
    private AlertDialog alerta;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
        MainActivity mainActivity = (MainActivity) getActivity();
        mes = mainActivity.getMyData();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        retrieveFileFromResource();


        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            mMap.setMyLocationEnabled(true);

        }catch (SecurityException ex){
            Log.e(TAG, "Error", ex);
        }

        //coordenadas para estado de Pernambuco
        LatLng pernambuco = new LatLng( -8.31, -37.86);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pernambuco));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(6));

    }
    private final static String mLogTag = "GeoJsonDemo";

    private void retrieveFileFromResource() {
        GeoJsonETPActivity.MyAsyncTask task = new GeoJsonETPActivity.MyAsyncTask();
        task.execute();

    }

    public class MyAsyncTask extends AsyncTask<Void, GeoJsonLayer, GeoJsonLayer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress =ProgressDialog.show(getContext(), "Aguarde", "Carregando a imagem");
        }

        @Override
        protected GeoJsonLayer doInBackground(Void... params) {
            LatLngBounds newarkBounds = new LatLngBounds(
                    new LatLng(-10.199698383333333, -41.646426936666664),       // South west corner
                    new LatLng(-5.572608783333333, -34.24308357666667));      // North east corner

            try {
                if(mes ==0) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp01, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp01))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }
                if(mes ==1) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp02, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp02))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }
                if(mes ==2) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp03, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp03))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes ==3) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp04, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp04))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes ==4) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp05, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp05))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }
                if(mes ==5) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp06, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp06))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes ==6) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp07, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp07))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes ==7) {
                     layer = new GeoJsonLayer(getMap(), R.raw.etp08, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp08))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }
                if(mes ==8) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp09, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp09))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes ==9) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp10, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp10))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }
                if(mes ==10) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp11, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp11))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                if(mes == 11) {
                    layer = new GeoJsonLayer(getMap(), R.raw.etp12, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.etp12))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }

                Thread.sleep(7000);

            } catch (IOException e) {
                Log.e(mLogTag, "GeoJSON file could not be read");
            } catch (JSONException e) {
                Log.e(mLogTag, "GeoJSON file could not be converted to a JSONObject");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }


            for (GeoJsonFeature feature : layer.getFeatures()) {
                // Check if the magnitude property exists
                if (feature.getProperty("DN") != null && feature.hasProperty("DN")) {

                    GeoJsonPolygonStyle polygonStyle = new GeoJsonPolygonStyle();

                    polygonStyle.setStrokeColor(Color.TRANSPARENT);
                    feature.setPolygonStyle(polygonStyle);
                }
            }

            return  layer;
        }
        @Override
        protected void onPostExecute(GeoJsonLayer layer) {
            //super.onPostExecute(layer);
            getMap().addGroundOverlay(newarkMap);
            layer.addLayerToMap();
            closeProgrees();
            onLayerClick();
        }

    }

    private void onLayerClick() {

        try{
        layer.setOnFeatureClickListener(new GeoJsonLayer.GeoJsonOnFeatureClickListener() {
            @Override
            public void onFeatureClick(Feature feature) {

                DecimalFormat df = new DecimalFormat("0.##");
                final Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.activity_tabe_etc);
                    dialog.setTitle("Evapotranspiração Potencial");

                    double Etp = Double.parseDouble(feature.getProperty("DN"));

                    //set valor do evapo
                    final TextView valor = (TextView) dialog.findViewById(R.id.tvValorEtp);
                    valor.setText(feature.getProperty("DN") + " mm");

                    //Setando o mes no Dialog
                    final TextView tvmes = (TextView) dialog.findViewById(R.id.tvMesEtp);
                    MesesUtil mesesUtil = new MesesUtil();
                    tvmes.setText(mesesUtil.ConvertIntToMes(mes));

                    // banana 1.10
                    final TextView etcBanana = (TextView) dialog.findViewById(R.id.tvValorBanana);
                    String bn = df.format(Etp * 1.10);
                    etcBanana.setText(bn);

                    // Cana de açúcar 1.25
                    final TextView etcCana = (TextView) dialog.findViewById(R.id.tvValorCana);
                    String ca = df.format(Etp * 1.25);
                    etcCana.setText(ca);

                    // Feijão 1.05
                    final TextView etcFeijap = (TextView) dialog.findViewById(R.id.tvValorFeijao);
                     String fj = df.format(Etp * 1.05);
                    etcFeijap.setText(fj);

                    // Mandioca 0.80
                    final TextView etcMandioca = (TextView) dialog.findViewById(R.id.tvValorMandioca);
                    String ma = df.format(Etp * 0.80);
                    etcMandioca.setText(ma);

                    // Milho 1.20
                    final TextView etcMilho = (TextView) dialog.findViewById(R.id.tvValorMilho);
                    String mi = df.format(Etp * 1.20);
                    etcMilho.setText(mi);

                    Button dialogButton = (Button) dialog.findViewById(R.id.imageButton3);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                ImageButton share = (ImageButton) dialog.findViewById(R.id.shareetp);
                share.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent shareIntent =  new Intent(android.content.Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");

                        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Aplicativo IgMap");

                        String shareMessage="A Etp do mês de "+tvmes.getText()+" é "+ valor.getText()+ System.getProperty ("line.separator")+
                                "Evapotranpiração das culturas: "+ System.getProperty ("line.separator")+"Banana = "+etcBanana.getText()+
                                 System.getProperty ("line.separator")+"Cana-de-Açúcar = "+etcCana.getText()+ System.getProperty ("line.separator")
                                +"Feijão = "+etcFeijap.getText() + System.getProperty ("line.separator")+ "Mandioca = "+etcMandioca.getText()
                                + System.getProperty ("line.separator")+"Milho = "+etcMilho.getText();

                        //message
                        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,shareMessage);
                        //start sharing via
                        startActivity(Intent.createChooser(shareIntent,"Sharing via"));
                    }
                });

                    dialog.show();

            }

        });
    }catch (NullPointerException e){
            Log.e(mLogTag, "GeoJSON feature could not be read");
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setMessage("Semdados")
                    .setTitle("Alerta");
            android.app.AlertDialog dialog = builder.create();
            dialog.show();
           // layer.setOnFeatureClickListener(null);

        }


    }
    private  void closeProgrees (){
        if(progress!=null && progress.isShowing()){
            progress.dismiss();
            progress=null;
        }
    }

    protected GoogleMap getMap() {
        return mMap;
    }
}
