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
import yairvalbuena.android.aplicacion.Activities.DetallePage;
import yairvalbuena.android.aplicacion.Adapters.TrackAdapter;
import yairvalbuena.android.aplicacion.Cross.Constants;
import yairvalbuena.android.aplicacion.Interface.LastfmApi;
import yairvalbuena.android.aplicacion.Model.Data;
import yairvalbuena.android.aplicacion.Model.TopTracks;
import yairvalbuena.android.aplicacion.Model.Track;
import yairvalbuena.android.aplicacion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopTracksFragment extends Fragment implements TrackAdapter.OnTrackListener {

    public TopTracksFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private TrackAdapter adapter;
    private List<Track> tracks;
    private List<Track> clicktrack;

    private Constants CONST;


    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_top_tracks, container, false);


        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tracks = new ArrayList<>();
        adapter = new TrackAdapter(tracks,getActivity(), this);
        recyclerView = view.findViewById(R.id.recyclerViewT);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        getLTracks();
    }

    private void getLTracks(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();


        LastfmApi lastfmApi = retrofit.create(LastfmApi.class);

        Call<TopTracks> call = lastfmApi.getTopTracks(CONST.API_KEY,CONST.LIMIT_TRACKS);

        call.enqueue(new Callback<TopTracks>() {
            @Override
            public void onResponse(Call<TopTracks> call, Response<TopTracks> response) {
                clicktrack = response.body().getTrack().getTrack();
                adapter.setData(response.body().getTrack().getTrack());
            }

            @Override
            public void onFailure(Call<TopTracks> call, Throwable t) {
                Log.d("TAG1", "Error: "+ t.getMessage());
            }
        });

    }

    @Override
    public void OnTrackClick(int position) {
        Track track = clicktrack.get(position);
        Intent intent = new Intent(getContext(), DetallePage.class);
        intent.putExtra("TrackName", track.name);
        intent.putExtra("TracDuration", track.duration);
        intent.putExtra("TrackListeners", track.listeners);
        intent.putExtra("TrackArtista", track.artist.getArtist());
        intent.putExtra("TrackImage", track.getImage().get(3).url);
        startActivity(intent);
    }
}
