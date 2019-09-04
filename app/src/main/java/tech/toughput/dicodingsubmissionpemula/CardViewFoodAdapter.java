package tech.toughput.dicodingsubmissionpemula;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;


public class CardViewFoodAdapter extends RecyclerView.Adapter<CardViewFoodAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Food> listFood;

    private ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public CardViewFoodAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_food, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Food f = getListFood().get(i);

        Glide.with(context)
                .load(f.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(f.getName());
        cardViewViewHolder.tvRemarks.setText(f.getRemarks());
        cardViewViewHolder.btnCopy.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Salin Resep " + getListFood().get(position).getName(), Toast.LENGTH_SHORT).show();
                ClipboardManager myclipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                ClipData Clip= ClipData.newPlainText("Source", getListFood().get(position).getLink());
                myclipboard.setPrimaryClip(Clip);
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListFood().get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getListFood().get(position).getLink());
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Share This"));
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListFood().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnCopy, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnCopy = itemView.findViewById(R.id.btn_set_copy);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
