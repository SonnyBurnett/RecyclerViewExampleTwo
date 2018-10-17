package nl.tsbakker.recyclerviewexampletwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//
// Name:    MainActivity
// Purpose: Handle the MainActivity
// Author:  Taco Bakker
// Date:    7-10-2018
//
//
// Note a RecyclerView is a view that is used when a lot of data needs to be displayed
// that will likely not fit the screen
// And you can have a list with more complex elements
// An excellent article can be found here: https://medium.com/@thomassimonini/recyclerview-made-easy-16bf2e261694
//


public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public TeamObjectAdapter mAdapter;
    final List<TeamObject> mTeamObjects = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTeamObjects.add(new TeamObject("Ajax","Amsterdam"));
        mTeamObjects.add(new TeamObject("AZ","Alkmaar"));
        mTeamObjects.add(new TeamObject("PEK","Zwolle"));
        mTeamObjects.add(new TeamObject("PUK","Zwolle"));
        mTeamObjects.add(new TeamObject("PSF","Zwolle"));
        mTeamObjects.add(new TeamObject("Belgie","Zwolle"));
        mTeamObjects.add(new TeamObject("Weeeeeee","Zwolle"));

        recyclerView = findViewById(R.id.team_recyclerview);

        mAdapter = new TeamObjectAdapter(this, mTeamObjects);
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = (viewHolder.getAdapterPosition());
                final TeamObject teamObject = mTeamObjects.get(position);
                mTeamObjects.remove(position);
                mAdapter.notifyItemRemoved(position);
                Toast.makeText(MainActivity.this, "Deleted: " + teamObject.getmTeamName(), Toast.LENGTH_LONG).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
}
