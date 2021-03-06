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
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import android.widget.ToggleButton;


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
        ImageButton professor = (ImageButton) findViewById(R.id.button_professor);
        ImageButton notice = (ImageButton) findViewById(R.id.button_notice);
        ImageButton callendar = (ImageButton) findViewById(R.id.button_callendar);
        ImageButton board = (ImageButton) findViewById(R.id.button_board);
        ImageButton process = (ImageButton) findViewById(R.id.button_process);
        ImageButton graduation = (ImageButton) findViewById(R.id.button_graduation);
        ImageButton job = (ImageButton) findViewById(R.id.button_job);
        ImageButton semina = (ImageButton) findViewById(R.id.button_semina_room);
        ImageButton call = (ImageButton) findViewById(R.id.button_call);
        Button personal = (Button) findViewById(R.id.personal_information);
        Button email = (Button) findViewById(R.id.email_refusion);
        Button multiMedia = (Button) findViewById(R.id.multi_media);

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
                if(i==0) // 학과소개
                {
                    if(i1==0) // 인사말
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=6"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 교육목표 및 연혁
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13505"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 교육 시설
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13110"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==3) // 졸업 후 진로
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13928"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==4) // 위치 및 연락처
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13114"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==1) // 교수 및 연구
                {
                    if(i1==0) // 교수 소개
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=71"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 연구실 소개
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=122"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==2) // 학사안내
                {
                    if(i1==0) // 학사일정
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14481"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 졸업 요건
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=50"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 장학금 안내
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr/mbshome/mbs/kr/subview.do?id=kr_050802000000"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==3) // 교과안내
                {
                    if(i1==0) // 교육과정
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=7"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // ABEEK
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=45"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 이수체계도
                    {
                        Intent intent = new Intent(getApplicationContext(),DiagramActivity.class);
                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==4) // 학생활동
                {
                    if(i1==0) // 자유게시판
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14182"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 학생회
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14288"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 소모임
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14290"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==3) // 사진으로 보는 ICE
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14267"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==5) // 정보통신 종합설계
                {
                    if(i1==0) // 공지사항
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13859"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 팀원모집
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13861"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 연도별 논문
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13857"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==6) // 정보마당
                {
                    if(i1==0) // 학과 공지사항
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13136"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 대학원 공지사항
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13853"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // FAQ
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=12972"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==3) // 취업정보
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13128"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                }
                else if(i==7) // 세미나실 예약
                {
                    if(i1==0) // ICE CAFE -> 이건 로그인 여부를 확인해야 함.
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13416"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) //  대학원생 세미나실
                    {

                    }
                }
                else if(i==8) // 관련사이트
                {
                    if(i1==0) // 인하대학교
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.inha.ac.kr"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==1) // 포털
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://portal.inha.ac.kr"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==2) // 수강신청
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sugang.inha.ac.kr"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==3) // 입학처
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admission.inha.ac.kr"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                    }
                    else if(i1==4) // ABEEK
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://abeek.inha.ac.kr"));

                        startActivity(intent);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        Button pcVersion = (Button)findViewById(R.id.button_pcVersion);
        pcVersion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr"));

                startActivity(intent);
            }
        });

        final ToggleButton loginout = (ToggleButton) this.findViewById(R.id.toggle_login);
        loginout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(loginout.isChecked()) {
                    // 인증이 성공하면 텍스트가 바뀌도록 하고 그렇지 않으면 그대로 둔다.
                    Intent intent = new Intent(getApplicationContext(),VerifyActivity.class);
                    startActivity(intent);

                    // loginout.setChecked(false); 를 사용하면 된다.

                }

                else{

                    // 로그아웃은 실패할 경우가 없으므로 로그아웃 처리 후 로그인으로 바꾸어 준다.
                    loginout.setText("로그인");
                }
            }
        });

        professor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=71"));

                startActivity(intent);
            }
        });

        notice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13136"));

                startActivity(intent);
            }
        });

        callendar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14481"));

                startActivity(intent);
            }
        });

        board.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14182"));

                startActivity(intent);
            }
        });

        process.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=7"));

                startActivity(intent);
            }
        });

        graduation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13859"));

                startActivity(intent);
            }
        });

        job.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13128"));

                startActivity(intent);
            }
        });

        semina.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13416"));

                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13114"));

                startActivity(intent);
            }
        });

        personal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr/mbshome/mbs/kr/subview.do?id=kr_070100000000"));

                startActivity(intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr/mbshome/mbs/kr/subview.do?id=kr_070200000000"));

                startActivity(intent);
            }
        });

        multiMedia.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr/mbshome/mbs/kr/subview.do?id=kr_070300000000"));

                startActivity(intent);
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } //onCreate 끝

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

        ExpandedMenuModel item9 = new ExpandedMenuModel();
        item9.setIconName("관련 사이트");
        listDataHeader.add(item9);

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

        List<String> heading9 = new ArrayList<String>();
        heading9.add("인하대학교");
        heading9.add("인하포털 시스템");
        heading9.add("수강신청");
        heading9.add("입학처");
        heading9.add("ABEEK");

        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
        listDataChild.put(listDataHeader.get(3), heading4);
        listDataChild.put(listDataHeader.get(4), heading5);
        listDataChild.put(listDataHeader.get(5), heading6);
        listDataChild.put(listDataHeader.get(6), heading7);
        listDataChild.put(listDataHeader.get(7), heading8);
        listDataChild.put(listDataHeader.get(8), heading9);
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