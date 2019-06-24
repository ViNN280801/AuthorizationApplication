package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_TEXT;

public class SecondActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        SecondActivityContract.View,
        RadioGroup.OnCheckedChangeListener {

    Switch mVisibilitySwitch, mChangeInputTypeForEditTextSwitch;
    CheckBox mCheckBoxText;
    RadioGroup mRadioGroup;
    TextView mTextView;

    EditText mEditTextForChangeInputType;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initializeViews();
        initializeListeners();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void initializeListeners(){
        mCheckBoxText.setOnCheckedChangeListener(this);
        mVisibilitySwitch.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void initializeViews(){
        mTextView = findViewById(R.id.textview_second_activity_hint);
        mRadioGroup = findViewById(R.id.radiogroup_second_activity_choose_text);
        mCheckBoxText = findViewById(R.id.checkbox_second_activity_deny_hide);
        mVisibilitySwitch = findViewById(R.id.switch_second_activity_hide_views);
    }

    @Override
    public Animation initializeAnimation() {
        Animation goneAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_gone);

        return goneAnimation;
    }

    @Override
    public void startGoneAnimation() {
        mRadioGroup.startAnimation(initializeAnimation());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean booleanState) {
        switch (compoundButton.getId()){
            case R.id.switch_second_activity_hide_views:
                if(booleanState) {
                    mRadioGroup.setVisibility(View.GONE);
                    if(mCheckBoxText.isChecked())
                        mTextView.setVisibility(View.VISIBLE);
                    else mTextView.setVisibility(View.GONE);
                    mTextView.setVisibility(View.GONE);
                    mCheckBoxText.setVisibility(View.GONE);
                }
                else {
                    mRadioGroup.setVisibility(View.VISIBLE);
                    mTextView.setVisibility(View.VISIBLE);
                    mCheckBoxText.setVisibility(View.VISIBLE);
                }
                mRadioGroup.setVisibility(View.GONE);
                break;
            case R.id.checkbox_second_activity_deny_hide:
                break;
        }

        mEditTextForChangeInputType = findViewById(R.id.edittext_second_activity_text_for_change);

        switch (compoundButton.getId()) {
            case R.id.switch_second_activity_change_input_type:
                if (mEditTextForChangeInputType.getText().equals(" ") || mEditTextForChangeInputType.getText().equals(null)) {
                    mEditTextForChangeInputType.setText(" ");
                    if (booleanState)
                        mEditTextForChangeInputType.setInputType(TYPE_CLASS_NUMBER);
                    else mEditTextForChangeInputType.setInputType(TYPE_CLASS_TEXT);
                }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch(checkedId){
            case R.id.radiobutton_second_activity_random_text:
                Intent transitionToAuthorization = new Intent(this, MainActivity.class);
                startActivity(transitionToAuthorization);
                break;
            case R.id.radiobutton_second_activity_advertisement_text:
                Intent transitionToImageActivity = new Intent(this, MainActivity.class);
                startActivity(transitionToImageActivity);
                break;
        }
    }

    public void onClickPhoto(View view) {
        Intent mIntentForCameraAccess = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    }
}
