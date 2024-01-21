package com.quintus.labs.datingapp.Introduction;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import androidx.core.app.ActivityOptionsCompat;
import androidx.compose.ui.platform.ComposeView;
import com.quintus.labs.datingapp.Login.Login;
import com.quintus.labs.datingapp.Login.RegisterBasicInfo;
import com.quintus.labs.datingapp.R;
import com.google.accompanist.pager.PagerState;
import com.quintus.labs.datingapp.introduction.ComposeUtils;

public class IntroductionMain extends AppCompatActivity {

    private Button signupButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_main);
        ComposeView composeView = findViewById(R.id.compose_view);
        PagerState pagerState = new PagerState(); // You might need to create this differently based on your implementation

        ComposeUtils.setContentForComposeView(composeView, pagerState);
        // Initialize buttons
        signupButton = findViewById(R.id.signup_button);
        loginButton = findViewById(R.id.login_button);

        // Animate buttons to fade in
        signupButton.animate().alpha(1f).setDuration(1000).setStartDelay(500).start();
        loginButton.animate().alpha(1f).setDuration(1000).setStartDelay(1000).start();

        // Set up click listeners for buttons
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailAddressEntryPage();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });
    }

    public void openLoginPage() {
        Intent intent = new Intent(this, Login.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

    public void openEmailAddressEntryPage() {
        Intent intent = new Intent(this, RegisterBasicInfo.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }
}
