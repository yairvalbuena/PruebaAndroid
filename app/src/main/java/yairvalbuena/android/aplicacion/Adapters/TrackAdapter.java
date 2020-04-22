package yairvalbuena.android.aplicacion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import yairvalbuena.android.aplicacion.Activities.DetallePage;
import yairvalbuena.android.aplicacion.Model.ImageData;
import yairvalbuena.android.aplicacion.Model.Track;
import yairvalbuena.android.aplicacion.R;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackAdapterHolder> {

    private List<Track> tracks;
    private Context context;
    private  OnTrackListener onTrackListener;

    public TrackAdapter(List<Track> tracks, Context pContext, OnTrackListener onTrackListener){
        this.context = pContext;
        this.tracks = tracks;
        this.onTrackListener = onTrackListener;
    }

    @NonNull
    @Override
    public TrackAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context)
                .inflate(R.layout.list_item_track,parent,false);
        return new TrackAdapterHolder(itemView, onTrackListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapterHolder holder, int position) {
        Track track = tracks.get(position);
        holder.trackName.setText(track.getName());
        int time = Integer.parseInt(track.getDuration());
        String minutos = Integer.toString((time)/60);
        String segundo = Integer.toString((time%60));
        holder.trackDuration.setText(minutos+":"+segundo);
        holder.trackListeners.setText(track.getListeners());
        holder.trackArtista.setText(track.getArtist().getArtist());

        ImageData x = track.getImage().get(2);
        Picasso.get().load(x.url).into(holder.imageTrack);


    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void setData(List<Track> tracks){
        this.tracks = tracks;
        notifyDataSetChanged();
    }


    public class TrackAdapterHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private TextView trackName;
        private TextView trackDuration;
        private TextView trackListeners;
        private TextView trackArtista;
        private ImageView imageTrack;

        OnTrackListener onTrackListener;

        public TrackAdapterHolder (@NonNull View itemView, OnTrackListener onTrackListener){
            super(itemView);
            trackName = itemView.findViewById(R.id.trackName);
            trackDuration = itemView.findViewById(R.id.trackDuration);
            trackListeners = itemView.findViewById(R.id.trackListeners);
            trackArtista = itemView.findViewById(R.id.trackArtista);
            imageTrack = itemView.findViewById(R.id.imageTrack);
            this.onTrackListener = onTrackListener;

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            onTrackListener.OnTrackClick(getAdapterPosition());
        }
    }


    public interface OnTrackListener {
        void OnTrackClick (int position);
    }

}
