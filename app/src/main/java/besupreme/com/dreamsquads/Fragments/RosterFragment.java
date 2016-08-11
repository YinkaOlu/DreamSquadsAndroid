package besupreme.com.dreamsquads.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import besupreme.com.dreamsquads.Adaptors.RosterAdaptor;
import besupreme.com.dreamsquads.Models.Roster;
import besupreme.com.dreamsquads.R;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class RosterFragment extends Fragment {
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_roster,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView rosterList = (RecyclerView) getView().findViewById(R.id.rosterList);
        rosterList.setLayoutManager(linearLayoutManager);
        rosterList.setAdapter( new RosterAdaptor( Roster.roster, getContext()));

    }
}
