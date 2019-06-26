package com.example.loginapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        public void bind(UserEntity entity){
            Picasso.get().load(R.drawable.franklin).into(mImageViewImage);

            mTextViewName.setText(entity.getName());
            mTextViewSurname.setText(entity.getSurname());
            mTextViewMark.setText(entity.getMark());
            mTextViewGpa.setText(entity.getGPA());
            mTextViewUniversity.setText(entity.getUniversity());
            mTextViewFaculty.setText(entity.getFaculty());
        }
    }

    public UsersAdapter(Context context, ArrayList<UserEntity> mArrayListUsers){
        this.context = context;
        this.mArrayListUsers = mArrayListUsers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_user_recycleview_user, parent, false);
            return new UsersHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_advertisement_users_list, parent, false);
            return new AdvertisementHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 1){
            ((UsersHolder)holder).bind(mArrayListUsers.get(position));
        }
        else{
            ((AdvertisementHolder)holder).bind(mArrayListUsers.get(position));
        }
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_from_left);
        holder.itemView.setAnimation(animation);
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

    public class AdvertisementHolder extends RecyclerView.ViewHolder{

        ImageView mImageViewBanner;
        TextView mTextViewAdvertisementText;

        public AdvertisementHolder(View itemView) {
            super(itemView);

            mImageViewBanner = itemView.findViewById(R.id.item_advertisement_users_list_advertisement_banner);
            mTextViewAdvertisementText = itemView.findViewById(R.id.item_advertisement_users_list_advertisement_text);
        }

        public void bind(UserEntity entity){
            Picasso.get().load("https://2.imimg.com/data2/IS/TN/MY-2561564/advertisement-designing-services-500x500.jpg").into(mImageViewBanner);
            mTextViewAdvertisementText.setText(entity.getBannerTitle());
        }
    }
}