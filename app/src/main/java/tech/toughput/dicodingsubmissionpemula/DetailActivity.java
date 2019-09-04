package tech.toughput.dicodingsubmissionpemula;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_REMARKS = "extra_remarks";
    public static final String EXTRA_JUDUL = "extra_judul";
    public static final String EXTRA_RECIPE = "extra_recipe";


    private void setActionBarTitle(String titleD){
        getSupportActionBar().setTitle(titleD);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nama, ket, judul, recipe;
        ImageView photo;

        setActionBarTitle("Recipe");

        Food food = getIntent().getParcelableExtra("fooD");

        nama = findViewById(R.id.Nama);
        ket = findViewById(R.id.Ket);
        photo = findViewById(R.id.Photo);
        judul = findViewById(R.id.Judul);
        recipe = findViewById(R.id.Recipe);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        nama.setText(name);

        String keterangan = getIntent().getStringExtra(EXTRA_REMARKS);
        ket.setText(keterangan);

        Glide.with(this)
                .load(food.getPhoto())
                .apply((new RequestOptions().override(300,300)))
                .into(photo);

        String jdl = getIntent().getStringExtra(EXTRA_JUDUL);
        judul.setText(jdl);

        String rcp = getIntent().getStringExtra(EXTRA_RECIPE);
        recipe.setText(rcp);
    }
}
