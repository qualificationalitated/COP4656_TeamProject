package com.cop4656.concerttickets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.cop4656.concerttickets.repo.ConcertRepository;

// MainActivity class extending AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Reference to the ConcertRepository
    private ConcertRepository concertRepo;

    // Method called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main);

        // Find the NavHostFragment in the layout
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        // Check if the NavHostFragment is not null
        if (navHostFragment != null){
            // Get the NavController from the NavHostFragment
            NavController navController = navHostFragment.getNavController();

            // Create an AppBarConfiguration using the navigation graph
            AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(navController.getGraph()).build();

            // Set up the ActionBar with the NavController and AppBarConfiguration
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        }
    }
    // Method called when the Up button is pressed in the action bar
    @Override
    public boolean onSupportNavigateUp() {
        // Find the NavController using the NavHostFragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Navigate up or call the default behavior
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}