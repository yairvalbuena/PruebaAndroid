package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {



    @SerializedName("name")
    public String name;
    @SerializedName("duration")
    public String duration;
    @SerializedName("listeners")
    public String listeners;

    public ArtistTrack artist;

    public List<ImageData> image;


    public ArtistTrack getArtist() {
        return artist;
    }

    public void setArtist(ArtistTrack artist) {
        this.artist = artist;
    }

    public List<ImageData> getImage() {
        return image;
    }

    public void setImage(List<ImageData> image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }






}
