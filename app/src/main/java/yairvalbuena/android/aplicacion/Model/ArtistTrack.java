package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

public class ArtistTrack {
    @SerializedName("name")
    public String name;

    public String getArtist() {
        return name;
    }

    public void setArtist(String artist) {
        this.name = artist;
    }
}
