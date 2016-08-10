package besupreme.com.dreamsquads.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import besupreme.com.dreamsquads.R;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class SplashFragment extends Fragment {
    private TextView stat_check_title;
    private Button begin_button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash,container,false);
        return view;
    }

}
