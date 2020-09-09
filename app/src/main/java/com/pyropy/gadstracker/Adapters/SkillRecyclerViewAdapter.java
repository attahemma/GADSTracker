package com.pyropy.gadstracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pyropy.gadstracker.Models.HourLeaders;
import com.pyropy.gadstracker.Models.IQLeaders;
import com.pyropy.gadstracker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.MyViewHolder> {
    List<IQLeaders> leaders;
    Context mContext;

    public SkillRecyclerViewAdapter(Context context, List<IQLeaders> leaders){
        mContext = context;
        this.leaders = leaders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.skill_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IQLeaders uLeader = leaders.get(position);
        holder.bind(uLeader);
    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView badge;
        public TextView learnerName;
        public TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = (ImageView) itemView.findViewById(R.id.skill_badge);
            learnerName = (TextView) itemView.findViewById(R.id.skill_name);
            description = (TextView) itemView.findViewById(R.id.skill_description);
        }

        public void bind(IQLeaders uLeader){
            learnerName.setText(uLeader.getName());
            description.setText(uLeader.getScore() +" Skill IQ Score, "+uLeader.getCountry());
            showImage(uLeader.getBadgeUrl());
        }

        public void showImage(String url){
            if (url != null){
                //int width = Resources.getSystem().getDisplayMetrics().widthPixels - 10;
                Picasso.get().load(url).resize(128, 70).centerCrop().placeholder(R.drawable.top_learner).into(badge);
            }
        }
    }
}
