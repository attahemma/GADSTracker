package com.pyropy.gadstracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pyropy.gadstracker.Models.HourLeaders;
import com.pyropy.gadstracker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HourRecyclerViewAdapter extends RecyclerView.Adapter<HourRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<HourLeaders> mHourLeaders;

    public HourRecyclerViewAdapter(Context context, List<HourLeaders> leaders){
        mContext = context;
        mHourLeaders = leaders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.hour_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HourLeaders uLeader = mHourLeaders.get(position);
        holder.bind(uLeader);
    }

    @Override
    public int getItemCount() {
        return mHourLeaders.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView badge;
        public TextView learnerName;
        public TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = (ImageView) itemView.findViewById(R.id.hour_badge);
            learnerName = (TextView) itemView.findViewById(R.id.hour_name);
            description = (TextView) itemView.findViewById(R.id.hour_description);

        }

        public void bind(HourLeaders uLeader){
            learnerName.setText(uLeader.getName());
            description.setText(uLeader.getHours() +" Learning hours, "+uLeader.getCountry());
            showImage(uLeader.getBadgeUrl());
        }

        public void showImage(String url){
            if (url != null){
                //int width = Resources.getSystem().getDisplayMetrics().widthPixels - 10;
                Picasso.get().load(url).resize(80, 80).centerCrop().placeholder(R.drawable.top_learner).into(badge);
            }
        }
    }
}
