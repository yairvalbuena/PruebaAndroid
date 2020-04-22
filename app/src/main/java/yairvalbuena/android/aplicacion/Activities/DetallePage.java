package yairvalbuena.android.aplicacion.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import yairvalbuena.android.aplicacion.R;

public class DetallePage extends AppCompatActivity {

    private TextView trackName;
    private TextView trackDuration;
    private TextView trackListeners;
    private TextView trackArtist;
    private ImageView trackImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_page);

        trackName = findViewById(R.id.trackNameDetail);
        trackDuration = findViewById(R.id.trackDurationDetail);
        trackListeners = findViewById(R.id.trackListenersDetail);
        trackArtist = findViewById(R.id.trackArtistaDetail);
        trackImage = findViewById(R.id.imageTrackDetail);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
           String Name = bundle.getString("TrackName");
            String Duration = bundle.getString("TracDuration");
            String Listeners = bundle.getString("TrackListeners");
            String Artist = bundle.getString("TrackArtista");
            String URL = bundle.getString("TrackImage");
            trackName.setText(Name);
            trackDuration.setText(Duration);
            trackListeners.setText(Listeners);
            trackArtist.setText(Artist);
            Picasso.get().load(URL).into(trackImage);
        }

    }
}
