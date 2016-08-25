package besupreme.com.dreamsquads.Adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import besupreme.com.dreamsquads.Models.Game;
import besupreme.com.dreamsquads.Models.Season;
import besupreme.com.dreamsquads.R;

/**
 * Created by yinka_000 on 2016-08-11.
 */
public class ResultAdaptor extends RecyclerView.Adapter<ResultAdaptor.ListViewHolder> {
    private Season mSeason;
    private Context mContext;

    public ResultAdaptor(Season season, Context context){
        mSeason = season;
        mContext = context;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_list_item, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        List<Entry> entries;
        LineDataSet dataSet;
        LineData lineData;
        int gameCount;


        switch (position){
            case 0:
                holder.statTitle.setText( mSeason.getPPGString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getPTS())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season PPG");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 1:
                holder.statTitle.setText( mSeason.getAPGString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getAssists())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season APG");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 2:
                holder.statTitle.setText( mSeason.getRPGString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getDRB()+game.getORB())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season RPG");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 3:
                holder.statTitle.setText( mSeason.getTOVString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getTurnovers())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season TOV");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 4:
                holder.statTitle.setText( mSeason.getFoulString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getFouls())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season Fouls");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 5:
                holder.statTitle.setText( mSeason.getBPGString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getBlocks())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season Blocks");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 6:
                holder.statTitle.setText( mSeason.getFGPerString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    if(game.getFGA() != 0){
                        entries.add(
                                new Entry(gameCount, game.getFGM()/game.getFGA())
                        );
                    }else{
                        entries.add(
                                new Entry(gameCount, 0)
                        );
                    }

                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season FG%");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 7:
                holder.statTitle.setText( mSeason.getMPGString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getMinutes())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season MPG");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 8:
                holder.statTitle.setText( mSeason.getStealsString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    entries.add(
                            new Entry(gameCount, game.getSteals())
                    );
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season Steals");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

            case 9:
                holder.statTitle.setText( mSeason.getThreePPERString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    if(game.getThrees_attempted() != 0){
                        entries.add(
                                new Entry(gameCount, game.getThrees_made()/game.getThrees_attempted() )
                        );
                    }
                    else{
                        entries.add(
                                new Entry(gameCount, 0 )
                        );
                    }
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season 3P%");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;
            case 10:
                holder.statTitle.setText( mSeason.getFTPERString() );

                entries = new ArrayList<Entry>();
                gameCount = 1;

                for(Game game : mSeason.getSeasonGames() ){
                    if(game.getThrees_attempted() != 0){
                        entries.add(
                                new Entry(gameCount, game.getFTM()/game.getFTA() )
                        );
                    }
                    else{
                        entries.add(
                                new Entry(gameCount, 0 )
                        );
                    }
                    gameCount++;
                }
                dataSet = new LineDataSet(entries,"Season FT%");
                dataSet.setLineWidth(5);

                lineData = new LineData(dataSet);

                holder.statLineChart.setDrawGridBackground(false);
                holder.statLineChart.setMaxVisibleValueCount(5);
                holder.statLineChart.setData(lineData);
                holder.statLineChart.invalidate();
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView statTitle;
        private LineChart statLineChart;

        public ListViewHolder(View itemView) {
            super(itemView);

            statLineChart = (LineChart) itemView.findViewById(R.id.result_line_chart);
            statTitle = (TextView) itemView.findViewById(R.id.stat_title);
        }
    }

}
