package com.example.loginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import entities.UserEntity;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<UserEntity> mArrayListUsers = new ArrayList<>();

    public class UsersHolder extends RecyclerView.ViewHolder{

        ImageView mImageViewImage;
        TextView mTextViewName;
        TextView mTextViewSurname;
        TextView mTextViewMark;
        TextView mTextViewGpa;
        TextView mTextViewUniversity;
        TextView mTextViewFaculty;

        public UsersHolder(View itemView) {
            super(itemView);

            mImageViewImage = itemView.findViewById(R.id.imageview_item_recyclerview_user_image);
            mTextViewName = itemView.findViewById(R.id.textview_item_recyclerview_user_name);
            mTextViewSurname = itemView.findViewById(R.id.textview_item_recyclerview_user_surname);
            mTextViewMark = itemView.findViewById(R.id.textview_item_recyclerview_user_mark);
            mTextViewGpa = itemView.findViewById(R.id.textview_item_recyclerview_user_gpa);
            mTextViewUniversity = itemView.findViewById(R.id.textview_item_recyclerview_user_university);
            mTextViewFaculty = itemView.findViewById(R.id.textview_item_recyclerview_user_faculty);
        }
    }

    public UsersAdapter(Context context, ArrayList<UserEntity> mArrayListUsers){
        this.context = context;
        this.mArrayListUsers = mArrayListUsers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_recycleview_user, parent, false);
        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UsersHolder usersHolder = (UsersHolder)holder;

        Picasso.get().load(R.drawable.franklin).into(usersHolder.mImageViewImage);

        usersHolder.mTextViewName.setText(mArrayListUsers.get(position).getName());
        usersHolder.mTextViewSurname.setText(mArrayListUsers.get(position).getSurname());
        usersHolder.mTextViewMark.setText(Integer.toString(mArrayListUsers.get(position).getMark()));
        usersHolder.mTextViewGpa.setText(Float.toString(mArrayListUsers.get(position).getGPA()));
        usersHolder.mTextViewUniversity.setText(mArrayListUsers.get(position).getUniversity());
        usersHolder.mTextViewFaculty.setText(mArrayListUsers.get(position).getFaculty());
    }

    @Override
    public int getItemCount() {
        return mArrayListUsers.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mArrayListUsers.get(position).getName().length() > 0)
            return 1;
        else return 2;
    }
}