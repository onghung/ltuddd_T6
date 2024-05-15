package com.example.myapplication.t61;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class T61MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t61_main);

        listView=findViewById(R.id.t61listview);
        productList=new ArrayList<>();
        adapter = new ProductAdapter( this, productList);
        listView.setAdapter(adapter);

        //get data from API
        new FetchProductsTask().execute();
    }
    private class FetchProductsTask extends AsyncTask<Void, Void, String>{
        //get data from api via internet
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response=new StringBuilder();//save result

            try {
                URL url = new URL("https://hungnttg.github.io/shopgiay.json");//url
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();//open connection
                //set method for read data
                connection.setRequestMethod("GET");
                //tao bo dem doc du lieu
                BufferedReader reader = new
                        BufferedReader(new InputStreamReader(connection.getInputStream()));
                //doc du lieu
                String line = "";
                while ((line=reader.readLine())!=null)//doc cho den khi het file
                {
                    response.append(line);
                }
                reader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return response.toString();
        }
        //return data for client
        @Override
        protected void onPostExecute(String s) {
            if (s!=null && !s.isEmpty()){
                try {
                    JSONObject json=new JSONObject(s);
                    JSONArray productArray=json.getJSONArray("products");//get array for objects
                    for(int i=0; i<productArray.length();i++){
                        JSONObject productObject=productArray.getJSONObject(i);
                        String styleId=productObject.getString("styleid");
                        String brand=productObject.getString("brands_filter_facet");
                        String price=productObject.getString("price");
                        String additionalInfo=productObject.getString("product_additional_info");
                        String searchImage =productObject.getString("search_image");

                        Product product = new Product(styleId,brand,price,additionalInfo,searchImage);
                        productList.add(product);
                    }
                    adapter.notifyDataSetChanged();//update to addapter
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }else {
                Toast.makeText(T61MainActivity.this, "Failed to frtch products!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}