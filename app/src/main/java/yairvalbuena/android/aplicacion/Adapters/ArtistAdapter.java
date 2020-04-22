package yairvalbuena.android.aplicacion.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import yairvalbuena.android.aplicacion.Model.Artist;
import yairvalbuena.android.aplicacion.Model.ImageData;
import yairvalbuena.android.aplicacion.Model.Track;
import yairvalbuena.android.aplicacion.R;


public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistAdapterHolder> {

    private List<Artist> artists;
    private Context context;
    private OnArtistListener onArtistListener;

    public ArtistAdapter(List<Artist> artists, Context pContext, OnArtistListener onArtistListener){
        this.context = pContext;
        this.artists = artists;
        this.onArtistListener = onArtistListener;
    }

    @NonNull
    @Override
    public ArtistAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context)
                .inflate(R.layout.list_item_artist,parent,false);
        return new ArtistAdapterHolder(itemView, onArtistListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapterHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.artistName.setText(artist.getName());
        holder.artistListeners.setText(artist.getListeners());
        ImageData x = artist.getImage().get(2);
        Picasso.get().load(x.url).into(holder.artistImage);


    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setData(List<Artist> artists ){
        this.artists = artists;
        notifyDataSetChanged();
    }


    public class ArtistAdapterHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private TextView artistName;
        private TextView artistListeners;
        private ImageView artistImage;
        OnArtistListener onArtistListener;

        public ArtistAdapterHolder (@NonNull View itemView, OnArtistListener onArtistListener){
            super(itemView);
            artistName = itemView.findViewById(R.id.artistName);
            artistListeners = itemView.findViewById(R.id.artistListeners);
            artistImage = itemView.findViewById(R.id.imageArtist);
            this.onArtistListener = onArtistListener;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onArtistListener.OnArtistClick(getAdapterPosition());
        }
    }

    public interface  OnArtistListener {
        void OnArtistClick(int position);
    }

}
