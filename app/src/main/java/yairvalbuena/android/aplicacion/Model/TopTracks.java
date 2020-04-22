package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

public class TopTracks {


    public Data tracks;

    @SerializedName("@attr")
    public  Info info;


    public Data getTrack() {
        return tracks;
    }

    public void setTrack(Data track) {
        this.tracks = track;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
