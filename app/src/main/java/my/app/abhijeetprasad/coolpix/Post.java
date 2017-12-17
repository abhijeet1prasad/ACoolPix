package my.app.abhijeetprasad.coolpix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.abhijeetprasad.coolpix.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abhijeet Prasad on 12/17/2017.
 */
public class Post extends AppCompatActivity implements View.OnClickListener {

    public static final String TrailerNoValue = "trailerno";

    public static final String KEY_CHASSIS_NO = "chassis_no";
    public static final String KEY_OK_Condition = "ok_condition";
    private static final String POST_URL = "https://vatsalasharma3595.000webhostapp.com/newpost.php";


    Button continuebutton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        continuebutton = (Button) findViewById(R.id.button2);
        continuebutton.setOnClickListener(this);

    }




    public void sendData(){

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

      //  final String trialerno = message;
        final String chassis_no = message;
        //Log.d("k",checked);
     //   final String ok_condition = "OK";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, POST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Post.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Post.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_CHASSIS_NO, chassis_no);
                //params.put(KEY_OK_Condition, ok_condition);
             //   params.put(TrailerNoValue, trialerno);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(Post.this);
        requestQueue.add(stringRequest);



    }



    @Override
    public void onClick(View v) {
        if(v == continuebutton){
            sendData();

            Intent i;
            i = new Intent(Post.this, Welcome.class);
            startActivity(i);
        }
    }




}
