package com.apnatutorials.androidadapterviewflipper;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AdapterViewFlipper avfImageFlipper;
    ArrayList<ImageDetail> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avfImageFlipper = (AdapterViewFlipper) findViewById(R.id.avfImageFlipper);
        imageList = new ArrayList<>();
        imageList = populateImageDetail(imageList);
        ImageArrayAdapter adapter = new ImageArrayAdapter(this, imageList);
        avfImageFlipper.setAdapter(adapter);
    }

    private ArrayList<ImageDetail> populateImageDetail(ArrayList<ImageDetail> imageList) {
        ImageDetail imageDetail1 = new ImageDetail(R.drawable.taj_1, "TajMahal pic 1");
        imageList.add(imageDetail1);

        ImageDetail imageDetail2 = new ImageDetail(R.drawable.taj_2, "TajMahal pic 2");
        imageList.add(imageDetail2);

        ImageDetail imageDetail3 = new ImageDetail(R.drawable.taj_3, "TajMahal pic 3");
        imageList.add(imageDetail3);

        ImageDetail imageDetail4 = new ImageDetail(R.drawable.taj_4, "TajMahal pic 4");
        imageList.add(imageDetail4);

        ImageDetail imageDetail5 = new ImageDetail(R.drawable.taj_5, "TajMahal pic 5");
        imageList.add(imageDetail5);

        ImageDetail imageDetail6 = new ImageDetail(R.drawable.taj_6, "TajMahal pic 6");
        imageList.add(imageDetail6);

        return imageList;
    }

    public void flipperHandler(View view) {

        switch (view.getId()) {
            case R.id.btnStart:
                avfImageFlipper.setFlipInterval(3000);
                avfImageFlipper.setAutoStart(true);
                avfImageFlipper.setInAnimation(getApplicationContext(), R.animator.left_in);
                avfImageFlipper.setOutAnimation(getApplicationContext(), R.animator.right_out);
                avfImageFlipper.startFlipping();

                break;
            case R.id.btnStop:
                avfImageFlipper.stopFlipping();
                avfImageFlipper.setAutoStart(false);
                break;

            case R.id.btnNext:
                avfImageFlipper.stopFlipping();
                avfImageFlipper.setInAnimation(getApplicationContext(), R.animator.left_in);
                avfImageFlipper.setOutAnimation(getApplicationContext(), R.animator.right_out);
                avfImageFlipper.showNext();
                break;

            case R.id.btnPrevious:
                avfImageFlipper.stopFlipping();
                avfImageFlipper.setInAnimation(getApplicationContext(), R.animator.right_in);
                avfImageFlipper.setOutAnimation(getApplicationContext(), R.animator.left_out);
                avfImageFlipper.showPrevious();
                break;

        }
    }
}
