package com.example.loginapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    CheckBox mColorChangeCheckBox, mScaleChangeCheckBox, mChangeImageCheckBox;
    Button mButtonConfirmingChanges;
    ImageView mImageToModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initializeView();
    }

    public void initializeView(){
        mColorChangeCheckBox = findViewById(R.id.checkbox_image_activity_change_color);
        mScaleChangeCheckBox = findViewById(R.id.checkbox_image_activity_change_scale);
        mChangeImageCheckBox = findViewById(R.id.checkbox_image_activity_change_image);
        mImageToModify = findViewById(R.id.imageview_image_activity_image_to_modify);
        mButtonConfirmingChanges = findViewById(R.id.button_image_activity_confirm_changes);
        mChangeCheckBoxes.onClick(mButtonConfirmingChanges);
    }

    View.OnClickListener mChangeCheckBoxes = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mColorChangeCheckBox.isChecked() == true)
                mImageToModify.setColorFilter(1);
            if (mColorChangeCheckBox.isChecked() == false)
                mImageToModify.setColorFilter(0);
            if (mScaleChangeCheckBox.isChecked() == true)
                mImageToModify.setScaleType(ImageView.ScaleType.CENTER);
            if (mScaleChangeCheckBox.isChecked() == false)
                mImageToModify.setScaleType(ImageView.ScaleType.MATRIX);
            if (mChangeImageCheckBox.isChecked() == true)
                mImageToModify.setImageResource(R.drawable.icon);
            if (mChangeImageCheckBox.isChecked() == false)
                mImageToModify.setImageResource(R.mipmap.ic_launcher_round);
        }
    };
}
