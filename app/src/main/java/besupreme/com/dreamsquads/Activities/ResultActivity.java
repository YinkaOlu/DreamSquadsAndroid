package besupreme.com.dreamsquads.Activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import besupreme.com.dreamsquads.Models.Season;
import besupreme.com.dreamsquads.R;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = ResultActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent inputIntent = getIntent();
        Season season = inputIntent.getParcelableExtra("season_object");

        Log.i(TAG, season.getPPG()+"");
    }
}
