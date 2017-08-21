package kr.inha.inti.iceapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KDH on 2017-08-08.
 */

public class DiagramActivity extends AppCompatActivity {
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagram);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        final ActionBar ab = getSupportActionBar();
        /* to set the menu icon image*/
        ab.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
        ab.setDisplayHomeAsUpEnabled(true);

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
                        finish();
                    }
                    else if(i1==1) // 교육목표 및 연혁
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13505"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 교육 시설
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13110"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==3) // 졸업 후 진로
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13928"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==4) // 위치 및 연락처
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13114"));

                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 연구실 소개
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=122"));

                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 졸업 요건
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=50"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 장학금 안내
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr/mbshome/mbs/kr/subview.do?id=kr_050802000000"));

                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // ABEEK
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=45"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 이수체계도
                    {
                        Intent intent = new Intent(getApplicationContext(),DiagramActivity.class);
                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 학생회
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14288"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 소모임
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14290"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==3) // 사진으로 보는 ICE
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=14267"));

                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 팀원모집
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13861"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 연도별 논문
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13857"));

                        startActivity(intent);
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 대학원 공지사항
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13853"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // FAQ
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=12972"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==3) // 취업정보
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ice.inha.ac.kr/?page_id=13128"));

                        startActivity(intent);
                        finish();
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
                        finish();
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
                        finish();
                    }
                    else if(i1==1) // 포털
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://portal.inha.ac.kr"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==2) // 수강신청
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sugang.inha.ac.kr"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==3) // 입학처
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://admission.inha.ac.kr"));

                        startActivity(intent);
                        finish();
                    }
                    else if(i1==4) // ABEEK
                    {
                        Toast.makeText(getApplicationContext(), "웹 브라우저로 이동합니다.",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://abeek.inha.ac.kr"));

                        startActivity(intent);
                        finish();
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else
            finish();
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
