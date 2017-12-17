package my.app.abhijeetprasad.coolpix;

/**
 * Created by Abhijeet Prasad on 12/16/2017.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.abhijeetprasad.coolpix.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity {
    ListView chassisList;


    // Get the Intent that started this activity and extract the string
    //Intent intent = getIntent();
    //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    // String message  = "MH12AB0123";

    //String url = "http://www.thecrazyprogrammer.com/example_data/fruits_array.json";
    // String url = "http://192.168.43.162/apod_api/getchassis.php?dealer=DL111&trailer=MH12AB0123";
    // String url = "http://192.168.43.162/apod_api/getchassis.php?dealer=DL111&trailer=" + message;
    //
    ProgressDialog dialog;
    Button continuebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        String url = "https://vatsalasharma3595.000webhostapp.com/allpost.php";

        chassisList = (ListView) findViewById(R.id.list);


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {

                parseJsonData(string);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(Timeline.this);
        rQueue.add(request);


        // initiate the date picker and a button


    }

    void parseJsonData(String jsonString) {


        try {
            Log.d("k", "we have reached here.");
            //JSONObject object = new JSONObject(jsonString);
            JSONArray fruitsArray = new JSONArray(jsonString);


            //Log.d("object", String.valueOf(object));
            //JSONArray fruitsArray = object.getJSONArray(0);
            //Log.d("fruitsArray", String.valueOf(fruitsArray));

            final ArrayList al = new ArrayList();

            for (int i = 0; i < fruitsArray.length(); ++i) {

                //al.add(fruitsArray.getString(i));
                //  al.add(fruitsArray.getString(i)); */

                JSONObject object = new JSONObject(fruitsArray.getString(i));
                al.add(object.getString("content"));

            }
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,al);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
            // ListView fruitList = (ListView) findViewById(R.id.fruitsList);

            chassisList.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }



 /*public void ConfirmButton(View v) {

        if (v.getId() == R.id.thank_you) {
            Intent i;
            i = new Intent(ShowChassis.this, ThankYou.class);
            startActivity(i);



        }
    }

    */


//*/


}
