package kr.inha.inti.iceapp;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static kr.inha.inti.iceapp.R.id.fab;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private long lastTimeBackPressed; // 뒤로 두번 누를 때의 간격
    List<Integer> galleryId = new ArrayList<Integer>(); // 이미지 플리퍼를 위한 이미지들을 리스트형으로 선언
    AdapterViewFlipper avf; // 이미지 플리퍼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        for (int i=1; i<6;i++) {
            galleryId.add(getResources().getIdentifier("t"+i,"drawable",this.getPackageName()));
        } // t1부터 t6까지 이미지 띄움

        avf = (AdapterViewFlipper) findViewById(R.id.image_flips);
        avf.setAdapter(new galleryAdapter(this));
        avf.startFlipping();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
                finish();
                return;
            }
            Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            lastTimeBackPressed = System.currentTimeMillis();
        }

    }

   /*  private void verifyDialog(){
        Log.e("response","Verify!!");
        LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout verifyLayout = (LinearLayout) vi.inflate(R.layout.verify_dialog, null);
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("학번 인증");
        adb.setView(verifyLayout);

        adb.setNeutralButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // 이 부분에 OK를 눌렀을 때 어떻게 되는지를 추가

            }
        }).show();
    } */

    public class galleryAdapter extends BaseAdapter { // 이미지 플리퍼

        private final Context mContext;
        LayoutInflater inflater;

        public galleryAdapter(Context c) {
            mContext=c;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount(){
            return galleryId.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView=inflater.inflate(R.layout.item,parent,false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.items);
            imageView.setImageResource(galleryId.get(position));
            return convertView;
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) { // 각각의 버튼을 눌렀을 때 어떻게 동작하는지
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.introduce_ICE) {
            // Handle the camera action
        } else if (id == R.id.professor) {

        } else if (id == R.id.about_ICE) {

        } else if (id == R.id.about_class) {

        } else if (id == R.id.student_action) {

        } else if (id == R.id.graduation_project) {

        } else if (id == R.id.information) {

        } else if (id == R.id.semina_room) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
