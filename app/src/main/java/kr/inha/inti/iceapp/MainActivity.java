package kr.inha.inti.iceapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
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
//import android.widget.ExpandableListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.support.design.widget.NavigationView;

import static kr.inha.inti.iceapp.R.id.fab;

public class MainActivity extends AppCompatActivity
         {
    private long lastTimeBackPressed; // 뒤로 두번 누를 때의 간격
    List<Integer> galleryId = new ArrayList<Integer>(); // 이미지 플리퍼를 위한 이미지들을 리스트형으로 선언
    AdapterViewFlipper avf; // 이미지 플리퍼
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        /* to set the menu icon image*/
        ab.setHomeAsUpIndicator(android.R.drawable.ic_menu_add);
        ab.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                //Log.d("DEBUG", "submenu item clicked");
                Toast.makeText(getApplicationContext(), "c click = " + i1,
                        Toast.LENGTH_SHORT).show();
                if(i==0) // 학과소개
                {
                    if(i1==0) // 인사말
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=6"));

                        startActivity(intent);
                    }
                    else if(i1==1) // 교육목표 및 연혁
                    {

                    }
                    else if(i1==2) // 교육 시설
                    {

                    }
                    else if(i1==3) // 졸업 후 진로
                    {

                    }
                    else if(i1==4) // 위치 및 연락처
                    {

                    }
                }
                else if(i==1) // 교수 및 연구
                {
                    if(i1==0) // 교수 소개
                    {

                    }
                    else if(i1==1) // 연구실 소개
                    {

                    }
                }
                else if(i==2) // 학사안내
                {
                    if(i1==0) // 학사일정
                    {

                    }
                    else if(i1==1) // 졸업 요건
                    {

                    }
                    else if(i1==2) // 장학금 안내
                    {

                    }
                }
                else if(i==3) // 교과안내
                {
                    if(i1==0) // 교육과정
                    {

                    }
                    else if(i1==1) // ABEEK
                    {

                    }
                    else if(i1==2) // 이수체계도
                    {

                    }
                }
                else if(i==4) // 학생활동
                {
                    if(i1==0) // 자유게시판
                    {

                    }
                    else if(i1==1) // 학생회
                    {

                    }
                    else if(i1==2) // 소모임
                    {

                    }
                    else if(i1==3) // 사진으로 보는 ICE
                    {

                    }
                }
                else if(i==5) // 정보통신 종합설계
                {
                    if(i1==0) // 공지사항
                    {

                    }
                    else if(i1==1) // 팀원모집
                    {

                    }
                    else if(i1==2) // 연도별 논문
                    {

                    }
                }
                else if(i==6) // 정보마당
                {
                    if(i1==0) // 학과 공지사항
                    {

                    }
                    else if(i1==1) // 대학원 공지사항
                    {

                    }
                    else if(i1==2) // FAQ
                    {

                    }
                    else if(i1==3) // 취업정보
                    {

                    }
                }
                else if(i==7) // 세미나실 예약
                {
                    if(i1==0) // ICE CAFE
                    {

                    }
                    else if(i1==1) //  대학원생 세미나실
                    {

                    }
                }
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                //Log.d("DEBUG", "heading clicked");
                return false;
            }
        });

        for (int i = 1; i < 6; i++) {
            galleryId.add(getResources().getIdentifier("t" + i, "drawable", this.getPackageName()));
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




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        } else {
            if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
                finish();
                return;
            }
            Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            lastTimeBackPressed = System.currentTimeMillis();
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public class galleryAdapter extends BaseAdapter { // 이미지 플리퍼

        private final Context mContext;
        LayoutInflater inflater;

        public galleryAdapter(Context c) {
            mContext = c;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
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
                convertView = inflater.inflate(R.layout.item, parent, false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.items);
            imageView.setImageResource(galleryId.get(position));
            return convertView;
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    /*@Override
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
    }*/


    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("학과소개");
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("교수 및 연구");
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("학사안내");
        listDataHeader.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setIconName("교과안내");
        listDataHeader.add(item4);


        ExpandedMenuModel item5 = new ExpandedMenuModel();
        item5.setIconName("학생활동");
        listDataHeader.add(item5);

        ExpandedMenuModel item6 = new ExpandedMenuModel();
        item6.setIconName("정보통신 종합설계");
        listDataHeader.add(item6);

        ExpandedMenuModel item7 = new ExpandedMenuModel();
        item7.setIconName("정보마당");
        listDataHeader.add(item7);

        ExpandedMenuModel item8 = new ExpandedMenuModel();
        item8.setIconName("세미나실 예약");
        listDataHeader.add(item8);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("인사말");
        heading1.add("교육목표 및 연혁");
        heading1.add("교육 시설");
        heading1.add("졸업 후 진로");
        heading1.add("위치 및 연락처");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("교수 소개");
        heading2.add("연구실 소개");

        List<String> heading3 = new ArrayList<String>();
        heading3.add("학사일정");
        heading3.add("졸업요건");
        heading3.add("장학금 안내");

        List<String> heading4 = new ArrayList<String>();
        heading4.add("교육과정");
        heading4.add("ABEEK");
        heading4.add("이수체계도");

        List<String> heading5 = new ArrayList<String>();
        heading5.add("자유게시판");
        heading5.add("학생회");
        heading5.add("소모임");
        heading5.add("사진으로 보는 ICE");

        List<String> heading6 = new ArrayList<String>();
        heading6.add("공지사항");
        heading6.add("팀원모집");
        heading6.add("연도별 논문");

        List<String> heading7 = new ArrayList<String>();
        heading7.add("학과 공지사항");
        heading7.add("대학원 공지사항");
        heading7.add("FAQ");
        heading7.add("취업정보");

        List<String> heading8 = new ArrayList<String>();
        heading8.add("ICE Cafe");
        heading8.add("대학원생 세미나실");


        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
        listDataChild.put(listDataHeader.get(3), heading4);
        listDataChild.put(listDataHeader.get(4), heading5);
        listDataChild.put(listDataHeader.get(5), heading6);
        listDataChild.put(listDataHeader.get(6), heading7);
        listDataChild.put(listDataHeader.get(7), heading8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

}