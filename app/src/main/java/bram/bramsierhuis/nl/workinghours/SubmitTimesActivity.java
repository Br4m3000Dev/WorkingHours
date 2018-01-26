package bram.bramsierhuis.nl.workinghours;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubmitTimesActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.nv1) NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_times);
        ButterKnife.bind(this);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationListeners();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void navigationListeners() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.nav_account:
                        onMyAccountClick();
                        return true;

                    case R.id.nav_settings:
                        onSettingsClick();
                        return true;

                    case R.id.nav_logout:
                        onLogoutClick();
                        return true;

                    default:
                        return true;
                }
            }
        });
    }

    private void onMyAccountClick(){
        Toast.makeText(SubmitTimesActivity.this, "Account Selected", Toast.LENGTH_SHORT).show();
    }

    private void onSettingsClick(){
        Toast.makeText(SubmitTimesActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
    }

    private void onLogoutClick(){
        Toast.makeText(SubmitTimesActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
    }

}
