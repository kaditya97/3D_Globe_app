package com.example.nasaworldwind;


import android.graphics.Typeface;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Offset;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layer.RenderableLayer;
import gov.nasa.worldwind.shape.Label;
import gov.nasa.worldwind.shape.TextAttributes;

public class LabelsFragment {


    public RenderableLayer createWorldWindow() {


        // Create a layer to display the tutorial labels.
        RenderableLayer layer = new RenderableLayer();

        // Create a basic label with the default attributes, including the default text color (white), the default text
        // size (24 pixels), the system default typeface, and the default alignment (bottom center).
        Label label = new Label(new Position(38.8977, -77.0365, 0), "The White House");
        layer.addRenderable(label);

        // Create a label with a black text color, the default text size, the system default typeface, the default
        // alignment, and a thick white text outline.
        TextAttributes attrs = new TextAttributes();
        attrs.setTextColor(new gov.nasa.worldwind.render.Color(0,0,0,1)); // black text via r,g,b,a
        attrs.setOutlineColor(new gov.nasa.worldwind.render.Color(1,1,1,1)); // white outline via r,g,b,a
        attrs.setOutlineWidth(5); // thicken the white outline
        label = new Label(new Position(38.881389, -77.036944, 0), "Thomas Jefferson Memorial", attrs);
        layer.addRenderable(label);

        // Create a right-aligned label using a bottom-right offset.
        attrs = new TextAttributes();
        attrs.setTextOffset(Offset.bottomRight());
        label = new Label(new Position(38.8893, -77.050111, 0), "Lincoln Memorial", attrs);
        layer.addRenderable(label);

        // Create a left-aligned label using a bottom-left offset.
        attrs = new TextAttributes();
        attrs.setTextOffset(Offset.bottomLeft());
        label = new Label(new Position(38.889803, -77.009114, 0), "United States Capitol", attrs);
        layer.addRenderable(label);

        // Create a label with a 48 pixel text size and a bold typeface.
        attrs = new TextAttributes();
        attrs.setTypeface(Typeface.DEFAULT_BOLD); // system default bold typeface
        attrs.setTextSize(48); // 48 screen pixels
        label = new Label(new Position(38.907192, -77.036871, 0), "Washington", attrs);
        layer.addRenderable(label);

        // Create a label with its orientation fixed relative to the globe.
        label = new Label(new Position(38.89, -77.023611, 0), "National Mall");
        label.setRotationMode(WorldWind.RELATIVE_TO_GLOBE);
        layer.addRenderable(label);

        return layer;

    }
}