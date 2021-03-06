package br.com.blogspot.dbrtech.igmap;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
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

import br.com.blogspot.dbrtech.utils.MesesUtil;


public class GeoJsonBalActivity extends SupportMapFragment implements OnMapReadyCallback{
    private GoogleMap mMap;
    private LocationManager locationManager;
    private int mes;
    private GeoJsonLayer layer=null;
    GroundOverlayOptions newarkMap=null;
    private ProgressDialog progress;

    private static final String TAG = "erro de autori";
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
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }


    private class MyAsyncTask extends AsyncTask<Void, GeoJsonLayer, GeoJsonLayer> {

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
                    layer = new GeoJsonLayer(getMap(), R.raw.bal01, getContext());
                   newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal01))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);

                }
                if(mes ==1) {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal02, getContext());
                     newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal02))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }
                if(mes ==2)  {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal03, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal03))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==3)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal04, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal04))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==4)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal05, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal05))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==5)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal06, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal06))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==6)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal07, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal07))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==7)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal08, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal08))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==8)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal09, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal09))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==9)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal10, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal10))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==10)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal11, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal11))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                if(mes ==11)   {
                    layer = new GeoJsonLayer(getMap(), R.raw.bal12, getContext());
                    newarkMap = new GroundOverlayOptions()
                            .image(BitmapDescriptorFactory.fromResource(R.drawable.bal12))
                            .positionFromBounds(newarkBounds).transparency((float) 0.5);
                }

                for (GeoJsonFeature feature : layer.getFeatures()) {
                    // Check if the magnitude property exists
                    if (feature.getProperty("DN") != null && feature.hasProperty("DN")) {
                        GeoJsonPolygonStyle polygonStyle = new GeoJsonPolygonStyle();
                        polygonStyle.setStrokeColor(Color.TRANSPARENT);
                        feature.setPolygonStyle(polygonStyle);
                    }
                }
                Thread.sleep(7000);

            } catch (IOException e) {
                Log.e(mLogTag, "GeoJSON file could not be read");
            } catch (JSONException e) {
                Log.e(mLogTag, "GeoJSON file could not be converted to a JSONObject");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return layer;
        }
        @Override
        protected void onPostExecute(GeoJsonLayer layer) {
            getMap().addGroundOverlay(newarkMap);
            layer.addLayerToMap();
            closeProgrees();
            onLayerClick();

        }
    }


    private void onLayerClick(){
        try {
            layer.setOnFeatureClickListener(new GeoJsonLayer.GeoJsonOnFeatureClickListener() {
                @Override
                public void onFeatureClick(Feature feature) {
                    final Dialog dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.activity_custom_dialog);
                    dialog.setTitle("Balanço Hídrico");

                    // set the custom dialog components - tex, image and buttom
                    final TextView valor = (TextView) dialog.findViewById(R.id.tx);

                    valor.setText(feature.getProperty("DN").toString()+" mm");

                    final TextView tvmes = (TextView) dialog.findViewById(R.id.tvMes);
                    MesesUtil mesesUtil = new MesesUtil();
                    tvmes.setText(mesesUtil.ConvertIntToMes(mes));

                    final TextView tvvariavel = (TextView) dialog.findViewById(R.id.tvVariavel);
                    Double defExc =  Double.valueOf(feature.getProperty("DN").toString());
                    if(defExc<0) {
                        tvvariavel.setText("Def: ");
                    }else
                        tvvariavel.setText("Exc: ");
                    Button dialogButton = (Button) dialog.findViewById(R.id.button2);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });


                    ImageButton share = (ImageButton) dialog.findViewById(R.id.shareButton);
                    share.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            Intent shareIntent =  new Intent(android.content.Intent.ACTION_SEND);
                            shareIntent.setType("text/plain");

                            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"IgMap");

                            String shareMessage="O"+ tvvariavel.getText()+" do mês de "+tvmes.getText()+" é "+valor.getText();
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