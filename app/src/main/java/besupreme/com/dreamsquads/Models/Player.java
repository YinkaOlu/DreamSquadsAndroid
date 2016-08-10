package besupreme.com.dreamsquads.Models;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class Player {
    private String player_id;
    private String preNBA_team;
    private String draft_year;
    private String start_date;
    private String position;
    private int player_number;
    private String last_name;
    private String first_name;

    private int weight;
    private int height;

    private String birthDate;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int mWeight) {
        weight = mWeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int mHeight) {
        height = mHeight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String mBirthDate) {
        birthDate = mBirthDate;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String mPlayer_id) {
        player_id = mPlayer_id;
    }

    public String getPreNBA_team() {
        return preNBA_team;
    }

    public void setPreNBA_team(String mPreNBA_team) {
        preNBA_team = mPreNBA_team;
    }

    public String getDraft_year() {
        return draft_year;
    }

    public void setDraft_year(String mDraft_year) {
        draft_year = mDraft_year;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String mStart_date) {
        start_date = mStart_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String mPosition) {
        position = mPosition;
    }

    public int getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(int mPlayer_number) {
        player_number = mPlayer_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String mLast_name) {
        last_name = mLast_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String mFirst_name) {
        first_name = mFirst_name;
    }
}
