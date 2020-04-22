package yairvalbuena.android.aplicacion.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {

    @SerializedName("name")
    public String name;
    @SerializedName("listeners")
    public String listeners;
    @SerializedName("mbid")
    public String mbid;
    @SerializedName("url")
    public String url;
    @SerializedName("streamable")
    public boolean streamable;
    public List<ImageData> image;

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

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStreamable() {
        return streamable;
    }

    public void setStreamable(boolean streamable) {
        this.streamable = streamable;
    }
}
