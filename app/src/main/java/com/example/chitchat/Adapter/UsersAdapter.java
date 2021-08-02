package com.example.chitchat.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chitchat.Activities.ChatActivity;
import com.example.chitchat.Activities.MainActivity;
import com.example.chitchat.R;
import com.example.chitchat.Models.User;
import com.example.chitchat.databinding.RowConversationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    MainActivity context;
    ArrayList<User> users;

    public UsersAdapter(MainActivity context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @NotNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_conversation, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UsersAdapter.UsersViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.username.setText(user.getName());
        Glide.with(context).load(user.getProfileImage())
                .placeholder(R.drawable.avatar)
                .into(holder.binding.profile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("uid" , user.getUid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        RowConversationBinding binding;

        public UsersViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding = RowConversationBinding.bind(itemView);      //All id(s) will accessible inside the adapter.
        }
    }
}

