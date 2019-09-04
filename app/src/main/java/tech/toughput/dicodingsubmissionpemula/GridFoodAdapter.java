package tech.toughput.dicodingsubmissionpemula;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by ASUS-X454Y on 26/05/2019.
 */

public class GridFoodAdapter extends RecyclerView.Adapter<GridFoodAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Food> listFood;

    public GridFoodAdapter(Context context) {
        this.context = context;
    }


    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public GridFoodAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_food, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridFoodAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListFood().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListFood().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
