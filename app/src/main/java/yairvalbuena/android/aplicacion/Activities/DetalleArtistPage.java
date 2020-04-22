package yairvalbuena.android.aplicacion.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import yairvalbuena.android.aplicacion.R;

public class DetalleArtistPage extends AppCompatActivity {

    private TextView artistName;
    private TextView artisListeners;
    private ImageView artistiImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_artist_page);

        artistName = findViewById(R.id.ArtistNameDetail);
        artisListeners = findViewById(R.id.trackListenersArtistDetail);
        artistiImage = findViewById(R.id.imageArtistDetail);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String Name = bundle.getString("ArtistName");
            String Listeners = bundle.getString("ArtistListeners");
            String URL = bundle.getString("ArtistImage");
            artistName.setText(Name);
            artisListeners.setText(Listeners);
            Picasso.get().load(URL).into(artistiImage);
        }

    }
}
