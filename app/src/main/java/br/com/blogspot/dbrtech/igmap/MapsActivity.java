package br.com.blogspot.dbrtech.igmap;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public  class MapsActivity extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "erro de autori";
    private GroundOverlayOptions newarkMap=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (mMap != null) {
            return;
        }
        mMap = googleMap;
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

        LatLngBounds newarkBounds = new LatLngBounds(
                new LatLng(-10.199698383333333, -41.646426936666664),       // South west corner
                new LatLng(-5.572608783333333, -34.24308357666667));      // North east corner

        newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pe))
                .positionFromBounds(newarkBounds).transparency((float) 0.5);

        getMap().addGroundOverlay(newarkMap);
    }

    protected GoogleMap getMap() {
        return mMap;
    }

}
