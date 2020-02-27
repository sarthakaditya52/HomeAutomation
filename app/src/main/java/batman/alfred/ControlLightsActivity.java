package batman.alfred;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ControlLightsActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_lights);
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void turnLightsOn(View v){

        // animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(anim);
        this.lightsOn();

    }

    public void turnLightsOff(View v){

        // animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(anim);
        this.lightsOff();
    }


    public void lightsOn(){
        mDatabase.child("State").setValue("ON");
    }


    public void lightsOff(){

        mDatabase.child("State").setValue("OFF");

    }
}

