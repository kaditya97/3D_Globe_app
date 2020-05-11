package com.example.nasaworldwind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layer.BackgroundLayer;
import gov.nasa.worldwind.layer.BlueMarbleLandsatLayer;
import gov.nasa.worldwind.layer.RenderableLayer;
import gov.nasa.worldwind.shape.Ellipse;

import com.example.nasaworldwind.LabelsFragment;

public class MainActivity extends AppCompatActivity {
    private WorldWindow wwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a WorldWindow (a GLSurfaceView)...
        WorldWindow wwd = new WorldWindow(getApplicationContext());
        // ... and add some map layers
        wwd.getLayers().addLayer(new BackgroundLayer());
        wwd.getLayers().addLayer(new BlueMarbleLandsatLayer());
        // Add the WorldWindow view object to the layout that was reserved for the globe.
        FrameLayout globeLayout = (FrameLayout) findViewById(R.id.globe);
        globeLayout.addView(wwd);

        // Create a surface ellipse with the default attributes, a 500km major-radius and a 300km minor-radius. Surface
        // ellipses are configured with a CLAMP_TO_GROUND altitudeMode and followTerrain set to true.
        Ellipse ellipse = new Ellipse(new Position(45, -120, 0), 500000, 300000);
        ellipse.setAltitudeMode(WorldWind.CLAMP_TO_GROUND); // clamp the ellipse's center position to the terrain surface
        ellipse.setFollowTerrain(true); // cause the ellipse geometry to follow the terrain surface
        // Create a layer for the Sightline
        RenderableLayer tutorialLayer = new RenderableLayer();
        wwd.getLayers().addLayer(tutorialLayer);
        tutorialLayer.addRenderable(ellipse);

        RenderableLayer added = new LabelsFragment().createWorldWindow();
        // Place the viewer directly over the tutorial labels.
        wwd.getNavigator().setLatitude(38.89);
        wwd.getNavigator().setLongitude(-77.023611);
        wwd.getNavigator().setAltitude(10e3);

        wwd.getLayers().addLayer(added);
    }
}
