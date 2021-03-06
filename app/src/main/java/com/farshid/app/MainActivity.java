package com.farshid.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListPopupWindow;

import com.mentionedittext.model.MentionModel;
import com.mentionedittext.view.widget.MentionableEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MentionableEditText mentionableEditText;
    private ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MentionModel> inputList = new ArrayList<>();
        inputList.add(new MentionModel("Amir", null));
        inputList.add(new MentionModel("AmirMohsen", null));
        inputList.add(new MentionModel("AmirHosein", null));
        inputList.add(new MentionModel("Amin", null));
        inputList.add(new MentionModel("Hamed", null));
        inputList.add(new MentionModel("Manizheh", null));
        inputList.add(new MentionModel("Farshid", null));
        inputList.add(new MentionModel("Sajad", null));
        inputList.add(new MentionModel("Faeze", null));
        inputList.add(new MentionModel("Rezvan", null));

        mentionableEditText = (MentionableEditText) findViewById(R.id.editText);
        mentionableEditText.setInputList(inputList);
   }
}
