package com.example.oyo.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GlideAdapter extends RecyclerView.Adapter<GlideAdapter.GlideViewHolder> {
    private User[] users;
    private Context context;
    String URL="http://newnation.sg/wp-content/uploads/random-pic-internet-22.jpg";
    public GlideAdapter(User[] users,Context context){
        this.users = users;
        this.context = context;
    }


    @NonNull
    @Override
    public GlideViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_view,viewGroup,false);
        GlideViewHolder vh = new GlideViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull GlideViewHolder glideViewHolder, int i) {
        User user = users[i];
        glideViewHolder.tv.setText(user.getId().toString());
        Glide.with(glideViewHolder.im.getContext()).load(URL).into(glideViewHolder.im);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public static class GlideViewHolder extends RecyclerView.ViewHolder{
        ImageView im;
        TextView tv;
        public GlideViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.userImage);
            tv=itemView.findViewById(R.id.userName);
        }
    }
}
