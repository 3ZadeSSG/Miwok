package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manugond on 2/15/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourseID;
    public WordAdapter(Activity context, ArrayList<Word>arr,int colorID){
        super(context,0,arr);
        mColorResourseID=colorID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word translator = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(translator.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(translator.getDefaultTranslation());

        ImageView imageView=listItemView.findViewById(R.id.image);
        if(translator.hasImage()){

            imageView.setImageResource(translator.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        View textContainer=listItemView.findViewById(R.id.text_container);
        int color =ContextCompat.getColor(getContext(),mColorResourseID);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
