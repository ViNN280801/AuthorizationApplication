package com.example.loginapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import entities.UserEntity;

public class UsersListActivity extends AppCompatActivity implements UserActivityContract.View {

    UsersAdapter mUserAdapterUsers;
    RecyclerView mRecyclerViewUsers;
    LinearLayoutManager mLinearManagerVerticalUsers;

    ArrayList<UserEntity> mArrayListUsers = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        initializeViews();
        initializeArray();
        initializeAdapter();
    }

    @Override
    public void initializeViews(){
        mRecyclerViewUsers = findViewById(R.id.activity_users_list);
    }

    @Override
    public void initializeAdapter(){
        mUserAdapterUsers = new UsersAdapter(this, mArrayListUsers);
        mLinearManagerVerticalUsers = new LinearLayoutManager(this);
        mRecyclerViewUsers.setLayoutManager(mLinearManagerVerticalUsers);
        mRecyclerViewUsers.setAdapter(mUserAdapterUsers);
    }

    @Override
    public void initializeArray(){
        for(int i = 0; i < 100; i++){
            UserEntity userEntity = new UserEntity();

            userEntity.setName("Benjamin");
            userEntity.setSurname("Franklin");
            userEntity.setAddress("Milk Street");
            userEntity.setGPA(1);
            userEntity.setMark(1);
            userEntity.setFaculty("Diplomacy");
            userEntity.setUniversity("University of Pennsylvania");
            userEntity.setCountry("USA");

            mArrayListUsers.add(userEntity);

            if(i % 10 == 0){
                userEntity.setName("");
                userEntity.setBannerImage("https://2.imimg.com/data2/IS/TN/MY-2561564/advertisement-designing-services-500x500.jpg");
                userEntity.setBannerTitle("The angus third pounder... get yours today!");
            }
        }
    }
}