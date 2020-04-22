package yairvalbuena.android.aplicacion.Interface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import yairvalbuena.android.aplicacion.Model.Data;
import yairvalbuena.android.aplicacion.Model.TopArtists;
import yairvalbuena.android.aplicacion.Model.TopTracks;

public interface LastfmApi {

    @GET("2.0/?method=geo.gettoptracks&country=spain&format=json")
    Call<TopTracks> getTopTracks(@Query("api_key") String API_KEY, @Query("limit") String LIMIT );

    @GET("2.0/?method=geo.gettopartists&country=spain&format=json")
    Call<TopArtists> getTopArtist(@Query("api_key") String API_KEY, @Query("limit") String LIMIT );

}
