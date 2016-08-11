package besupreme.com.dreamsquads.Adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import besupreme.com.dreamsquads.Models.Teams;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class TeamLogoAdapter extends BaseAdapter{
    private Context mContext;
    public TeamLogoAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return Teams.TEAM_LOGOS.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if(view == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(18, 18, 18, 18);
        }
        else{
            imageView = (ImageView) view;
        }

        imageView.setImageResource(Teams.TEAM_LOGOS[i]);
        return imageView;
    }
}
