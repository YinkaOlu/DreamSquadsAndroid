package besupreme.com.dreamsquads.Models;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class Team {
    private String mTeamID;
    private String mTeamName;
    private String mPrimaryColour;
    private String mSecondaryColour;
    private String mTertiaryColour;

    public String getTeamID() {
        return mTeamID;
    }

    public void setTeamID(String mTeamID) {
        this.mTeamID = mTeamID;
    }

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String mTeamName) {
        this.mTeamName = mTeamName;
    }

    public String getPrimaryColour() {
        return mPrimaryColour;
    }

    public void setPrimaryColour(String mPrimaryColour) {
        this.mPrimaryColour = mPrimaryColour;
    }

    public String getSecondaryColour() {
        return mSecondaryColour;
    }

    public void setSecondaryColour(String mSecondaryColour) {
        this.mSecondaryColour = mSecondaryColour;
    }

    public String getTertiaryColour() {
        return mTertiaryColour;
    }

    public void setTertiaryColour(String mTertiaryColour) {
        this.mTertiaryColour = mTertiaryColour;
    }
}
