package nl.tsbakker.recyclerviewexampletwo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class TeamObjectAdapter extends RecyclerView.Adapter<TeamObjectViewHolder> {

//
// Name:    TeamObjectAdapter
// Purpose: Handle the Adpter, which means connect the datamodel to the Reccycleview
//          Connection to the Recyclerview is done via the ViewHolder.
//          The Adapter is called to create new items (in the form of ViewHolders).
//          Provides the viewholders with data.
//          Returns information about data (how many items…).
// Author:  Taco Bakker
// Date:    7-10-2018
//

    private Context context;
    public List<TeamObject> listTeamObject;

    //
    // Constructor
    //
    public TeamObjectAdapter(Context context, List<TeamObject> listTeamObject) {
        this.context = context;
        this.listTeamObject = listTeamObject;
    }


    @Override
    public TeamObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grid_team, parent, false);
        return new TeamObjectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TeamObjectViewHolder holder, final int position) {
        final TeamObject teamObject = listTeamObject.get(position);
        holder.TeamName.setText(teamObject.getmTeamName());
    }

    @Override
    public int getItemCount() {
        return listTeamObject.size();
    }


}
