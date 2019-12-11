package com.example.sketcher;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class SomeFragment extends Fragment {

    public Activity containerActivity = null;
    private View inflatedView = null;
    private Path drawPath;
    DrawingView dv = null;
    private Paint drawPaint, canvasPaint;
    private static int paintColor;
    private static float paintSize;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private FirebaseDatabase database;
    private DatabaseReference pathRef;
    private HashSet<String> dbValues;
    public ArrayList<String> lines = new ArrayList<>();
    public Map<Double, Integer> colorMap  = new HashMap<Double, Integer>() {{
        put(-65536.0, R.color.colorRed);
        put(-16711936E7, R.color.colorGreen);
        put(-1.6676961E7, R.color.colorBlue);
        put(-9764609.0, R.color.colorPurple);
        put(-1.6711681E7, R.color.aqua);
        put(-1.6711936E7, R.color.pink);
        put(-8355712.0, R.color.grey);
        put(-23296.0, R.color.orange);


    }};

    public SomeFragment() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        inflatedView = inflater.inflate(R.layout.fragment_guess, container, false);
        database = FirebaseDatabase.getInstance();
//        dv = new DrawingView(containerActivity,null);
//        dv = new DrawingView(containerActivity,null);


//        drawCanvas = new Canvas();
//        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);




//        dv = new DrawingView(containerActivity,null);
//        FrameLayout ll = (FrameLayout) inflatedView.findViewById(R.id.draw_view);
//        ll.setImageBitmap(canvasBitmap);
//        ll.addView(dv);
//        ll.setBackground(canvasBitmap);
//        setupDrawing();
        fetch();

        return inflatedView;
    }

    public void setupDrawing(){
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(0);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(15);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    public void fetch(){
        DatabaseReference dbWords = database.getReference().child("DrawPaths");
        dbWords.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Object info = snapshot.getValue();
                System.out.println(info);

                if(info != null){
                    String[] arr = info.toString().split("%%%");

                    float xCord = Float.parseFloat(arr[0]);
                    float yCord = Float.parseFloat(arr[1]);
                    float size = Float.parseFloat(arr[2]);
                    float color = Float.parseFloat(arr[3]);
//                    dv.changePaintSize(size);

//                    drawPath.lineTo(xCord, yCord);
//                    dv.drawWithPath(drawPath, drawPaint);





                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed");
            }
        });

    }




}