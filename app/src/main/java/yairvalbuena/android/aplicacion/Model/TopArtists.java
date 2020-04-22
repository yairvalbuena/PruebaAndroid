package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

public class TopArtists {

    public DataA topartists;

    @SerializedName("@attr")
    public  Info info;

    public DataA getArtist() {
        return topartists;
    }

    public void setArtist(DataA artist) {
        this.topartists = artist;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
