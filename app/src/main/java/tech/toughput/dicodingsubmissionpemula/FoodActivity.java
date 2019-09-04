package tech.toughput.dicodingsubmissionpemula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static tech.toughput.dicodingsubmissionpemula.DetailActivity.EXTRA_JUDUL;
import static tech.toughput.dicodingsubmissionpemula.DetailActivity.EXTRA_NAME;
import static tech.toughput.dicodingsubmissionpemula.DetailActivity.EXTRA_RECIPE;
import static tech.toughput.dicodingsubmissionpemula.DetailActivity.EXTRA_REMARKS;

public class FoodActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    private ArrayList<Food> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
    String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Traditional Food (CardView)");
            list.addAll(FoodData.getListData());
            showRecyclerCardView();
            mode = R.id.action_cardview;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<? extends Food> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    public void showSelectedFood(Food food) {

        Intent intent = new Intent(FoodActivity.this, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, food.getName());
        intent.putExtra(EXTRA_REMARKS, food.getRemarks());
        intent.putExtra("fooD", food);
        intent.putExtra(EXTRA_JUDUL, food.getJudul());
        intent.putExtra(EXTRA_RECIPE, food.getRecipe());
        startActivity(intent);

        Toast.makeText(this, "Loading " + food.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListFoodAdapter listFoodAdapter = new ListFoodAdapter(this);
        listFoodAdapter.setListFood(list);
        rvCategory.setAdapter(listFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridFoodAdapter gridFoodAdapter = new GridFoodAdapter(this);
        gridFoodAdapter.setListFood(list);
        rvCategory.setAdapter(gridFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewFoodAdapter cardViewFoodAdapter = new CardViewFoodAdapter(this);
        cardViewFoodAdapter.setListFood(list);
        rvCategory.setAdapter(cardViewFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedFood(list.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Traditional Food (ListView)";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Traditional Food (GridView)";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Traditional Food (CardView)";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, title);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
