package com.djx.layoutchangeanimation;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mContainer;
    private LinearLayout mContainer2;
    private Button mAdd;
    private Button mRemove;
    private Button mAdd2;
    private Button mRemove2;

    private LayoutTransition mLayoutTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer = findViewById(R.id.container);
        mContainer2 = findViewById(R.id.container2);

        mAdd = findViewById(R.id.add);
        mRemove = findViewById(R.id.remove);
        mAdd2 = findViewById(R.id.add2);
        mRemove2 = findViewById(R.id.remove2);
        mAdd.setOnClickListener(this);
        mRemove.setOnClickListener(this);
        mAdd2.setOnClickListener(this);
        mRemove2.setOnClickListener(this);

        mLayoutTransition = new LayoutTransition();
        ObjectAnimator animator = ObjectAnimator.ofFloat(null, "translationX", 0, 30, 0);
        mLayoutTransition.setDuration(LayoutTransition.APPEARING, 800);
        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, animator);

        AnimatorSet animator1 = new AnimatorSet();
        animator1.playTogether(ObjectAnimator.ofFloat(null, "scaleX", 1, 0),
                ObjectAnimator.ofFloat(null, "scaleY", 1, 0));
        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animator1);

        // This doesn't work!
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotation", 0, 360, 0);
//        mLayoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING, 800);
//        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, animator2);

        AnimatorSet animator2 = new AnimatorSet();
        animator2.playTogether(ObjectAnimator.ofFloat(null, "rotation", 0, 360, 0));
        mLayoutTransition.setDuration(LayoutTransition.CHANGE_APPEARING, 800);
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, animator2);

        // This doesn't work!
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(null, "rotation", 0, 360, 0);
//        mLayoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, 800);
//        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, animator3);

        AnimatorSet animator3 = new AnimatorSet();
        animator3.playTogether(ObjectAnimator.ofFloat(null, "rotation", 0, 360, 0));
        mLayoutTransition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, 800);
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, animator3);

        mContainer2.setLayoutTransition(mLayoutTransition);
    }


    @Override
    public void onClick(View view) {
        if (view == mAdd) {
            mContainer.addView(inflateItemSun());
        } else if (view == mRemove) {
            mContainer.removeView(mContainer.getChildAt(mContainer.getChildCount() - 1));
        } else if (view == mAdd2) {
            mContainer2.addView(inflateItemMoon());
        } else if (view == mRemove2) {
            mContainer2.removeView(mContainer2.getChildAt(mContainer2.getChildCount() - 1));
        }
    }

    private ImageView inflateItemSun() {
        return (ImageView) LayoutInflater.from(this).inflate(R.layout.item_sun, null);
    }

    private ImageView inflateItemMoon() {
        return (ImageView) LayoutInflater.from(this).inflate(R.layout.item_moon, null);
    }
}
