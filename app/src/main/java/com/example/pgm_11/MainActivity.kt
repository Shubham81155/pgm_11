package com.example.pgm_11

import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        findViewById<RadioGroup>(R.id.mapTypeGroup).setOnCheckedChangeListener { _, checkedId ->
            googleMap?.mapType = when (checkedId) {
                R.id.typeSatellite -> GoogleMap.MAP_TYPE_SATELLITE
                R.id.typeTerrain -> GoogleMap.MAP_TYPE_TERRAIN
                R.id.typeHybrid -> GoogleMap.MAP_TYPE_HYBRID
                else -> GoogleMap.MAP_TYPE_NORMAL
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isCompassEnabled = true

        val bengaluru = LatLng(BENGALURU_LAT, BENGALURU_LNG)
        map.addMarker(
            MarkerOptions()
                .position(bengaluru)
                .title(getString(R.string.marker_title))
                .snippet(getString(R.string.marker_snippet))
        )?.showInfoWindow()
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bengaluru, DEFAULT_ZOOM))
    }

    companion object {
        const val BENGALURU_LAT = 12.9791
        const val BENGALURU_LNG = 77.5913
        const val DEFAULT_ZOOM = 14f
    }
}
