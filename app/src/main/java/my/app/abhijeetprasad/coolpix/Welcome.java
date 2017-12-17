package my.app.abhijeetprasad.coolpix;

/**
 * Created by Abhijeet Prasad on 12/16/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.abhijeetprasad.coolpix.R;


public class Welcome extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



    }




    public void  Timeline(View v)
    {

        Intent ob = new Intent(this,Timeline.class);
        startActivity(ob);

    }
    public void  Post(View v)
    {

        Intent ob = new Intent(this,Post.class);
        startActivity(ob);

    }







}
