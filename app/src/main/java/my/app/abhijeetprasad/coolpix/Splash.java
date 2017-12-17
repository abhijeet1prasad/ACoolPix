package my.app.abhijeetprasad.coolpix;

/**
 * Created by Abhijeet Prasad on 12/17/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.app.abhijeetprasad.coolpix.R;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Splash.this,Login.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }

}