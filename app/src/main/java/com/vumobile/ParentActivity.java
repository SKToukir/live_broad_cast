package com.vumobile;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vumobile.Config.Api;
import com.vumobile.celeb.Adapters.CelebrityListAdapter;
import com.vumobile.celeb.R;
import com.vumobile.celeb.Utils.CelebrityClass;
import com.vumobile.fan.login.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private CelebrityClass celebrityClass;
    private List<CelebrityClass> celebrityClassList = new ArrayList<CelebrityClass>();
    private CelebrityListAdapter adapter;
    private ListView listCeleb;

    Button  btnViewLiveFan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUI();

        // initialize comment list adapter
        adapter = new CelebrityListAdapter(this, R.layout.celeb_list_row, celebrityClassList);
        listCeleb.setAdapter(adapter);

        Log.d("Session: ", Session.retreiveName(ParentActivity.this,Session.USER_NAME));
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadCelebrityData(Api.URL_CELEBRITY);
    }

    private void loadCelebrityData(String urlCelebrity) {

        JsonArrayRequest request = new JsonArrayRequest(urlCelebrity, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {


                for (int i = 0; i<=15; i++){
                    try {

                        JSONObject obj = jsonArray.getJSONObject(i);
                        celebrityClass = new CelebrityClass();
                        celebrityClass.setCeleb_name(obj.getString(Api.CELEB_NAME));
                        celebrityClass.setCeleb_code(obj.getString(Api.CELEB_CODE));
                        celebrityClass.setCeleb_image(obj.getString(Api.CELEB_IMAGE));

                        celebrityClassList.add(celebrityClass);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                listCeleb.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(),volleyError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(ParentActivity.this);

        //Adding request to the queue
        requestQueue.add(request);
        //AppController.getInstance().addToRequestQueue(request);

    }

    private void initUI() {

        listCeleb = (ListView) findViewById(R.id.list_of_celeb);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

//            case R.id.btnGoLive:
//                startActivity(new Intent(ParentActivity.this, MainActivityLive.class));
//                break;
//            case R.id.btnFanViewLive:
//                startActivity(new Intent(ParentActivity.this, MainActivityLive.class));
//                break;
//            default:
//                break;
        }

    }
}
