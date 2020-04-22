package yairvalbuena.android.aplicacion.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yairvalbuena.android.aplicacion.Activities.DetalleArtistPage;
import yairvalbuena.android.aplicacion.Adapters.ArtistAdapter;
import yairvalbuena.android.aplicacion.Adapters.TrackAdapter;
import yairvalbuena.android.aplicacion.Cross.Constants;
import yairvalbuena.android.aplicacion.Interface.LastfmApi;
import yairvalbuena.android.aplicacion.Model.Artist;
import yairvalbuena.android.aplicacion.Model.Data;
import yairvalbuena.android.aplicacion.Model.TopArtists;
import yairvalbuena.android.aplicacion.Model.TopTracks;
import yairvalbuena.android.aplicacion.Model.Track;
import yairvalbuena.android.aplicacion.R;


public class TopArtistFragment extends Fragment implements ArtistAdapter.OnArtistListener {

    private RecyclerView recyclerView;
    private ArtistAdapter adapter;
    private List<Artist> artists;
    private List<Artist> artistClick;

    private Constants CONST;

    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_top_artist, container, false);

        return vista;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        artists = new ArrayList<>();
        adapter = new ArtistAdapter(artists,getActivity(),this);
        recyclerView = view.findViewById(R.id.recyclerViewA);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        getLArtist();
    }

    private void getLArtist(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();


        LastfmApi lastfmApi = retrofit.create(LastfmApi.class);

        Call<TopArtists> call = lastfmApi.getTopArtist(CONST.API_KEY,CONST.LIMIT_ARTIST);

        call.enqueue(new Callback<TopArtists>() {
            @Override
            public void onResponse(Call<TopArtists> call, Response<TopArtists> response) {
                artistClick = response.body().getArtist().getArtist();
                adapter.setData(response.body().getArtist().getArtist());
            }

            @Override
            public void onFailure(Call<TopArtists> call, Throwable t) {
                Log.d("TAG1", "Error: "+ t.getMessage());
            }
        });

    }

    @Override
    public void OnArtistClick(int position) {
        Artist artist = artistClick.get(position);
        Intent intent = new Intent(getContext(), DetalleArtistPage.class);
        intent.putExtra("ArtistName", artist.name);
        intent.putExtra("ArtistListeners", artist.listeners);
        intent.putExtra("ArtistImage", artist.getImage().get(3).url);
        startActivity(intent);
    }
}
