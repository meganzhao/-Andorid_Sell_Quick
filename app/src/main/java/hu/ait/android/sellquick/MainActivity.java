package hu.ait.android.sellquick;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.ait.android.sellquick.adapter.RecyclerAdapter;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private TextView tvBook;
    private TextView tvElectronics;
    private TextView tvCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //FloatingActionButton fab =


        tvBook = findViewById(R.id.tvBook);
        tvBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoBookPage();
            }
        });

        tvElectronics = findViewById(R.id.tvElectronics);
        tvElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoElectronicsPage();
            }
        });

        tvCloth = findViewById(R.id.tvCloth);
        tvCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoClothPage();
            }
        });

        createNavigation();

    }

    private void gotoElectronicsPage() {
        Intent electro = new Intent(MainActivity.this, Electronics.class);
        startActivity(electro);
    }

    private void gotoClothPage() {
        Intent clothes = new Intent(MainActivity.this, Clothing.class);
        startActivity(clothes);
    }

    private void createNavigation() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.nav_clothes:
                                Intent clothes = new Intent(MainActivity.this, Clothing.class);
                                startActivity(clothes);
                                //createAlertDialog();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_books:
                                Intent books = new Intent(MainActivity.this, Books.class);
                                startActivity(books);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_music:
                                Intent music = new Intent(MainActivity.this, Music.class);
                                startActivity(music);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_electronics:
                                Intent electronics = new Intent(MainActivity.this, Electronics.class);
                                startActivity(electronics);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_items_list:
//                                Intent myitems = new Intent(MainActivity.this, MyitemsActivity.class);
//                                startActivity(myitems);
                                  Intent myitems1 = new Intent(MainActivity.this, MyitemsActivity1.class);
                                  startActivity(myitems1);
                                  drawerLayout.closeDrawer(GravityCompat.START);
                                  break;
                            case R.id.nav_signout:
                                signOut();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                        }
                        return false;                    }
                }
        );
    }

    private void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        // user is now signed out
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        finish();
                    }
                });
    }

    public void gotoBookPage(){
        Intent books = new Intent(MainActivity.this, Books.class);
        startActivity(books);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
