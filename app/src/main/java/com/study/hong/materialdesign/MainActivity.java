package com.study.hong.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.study.hong.materialdesign.adapter.PersonAdapter;
import com.study.hong.materialdesign.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer_layout;
    private NavigationView nav_view;
    private FloatingActionButton fab;
    private Person[] mPerson = {new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header),new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header),new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header), new Person("路飞", R.drawable.ic_haizeiwang), new Person("小猫", R.drawable.ic_header)};
    private List<Person> person = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        nav_view = findViewById(R.id.nav_view);
        fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        //这里是getSupportActionBar，不是getActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.img_menu);
        }
        nav_view.setCheckedItem(R.id.nav_call);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer_layout.closeDrawers();
                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "data added", Snackbar.LENGTH_SHORT).setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "data restored", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        initPerson();

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new PersonAdapter(getApplicationContext(), person);
        mRecyclerView.setAdapter(adapter);
    }

    private void initPerson() {
        person.clear();
        for (int i = 0; i < mPerson.length; i++) {
            person.add(mPerson[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.back:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawer_layout.openDrawer(GravityCompat.START);
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

}
