package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }


    public List<Track> track;
}
