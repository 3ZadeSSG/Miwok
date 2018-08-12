package com.example.android.miwok;

/**
 * Created by manug on 2/15/2018.
 */

public class Word {
    private String mWord; //miwok word
    private String eWord; //english word
    private int songID; //audio id
    private int id=NO_IMAGE_PROVIDED; //image id for the corresponding image
    public static final int NO_IMAGE_PROVIDED=-1;
    public Word(String e,String m,int s){
        mWord=m;
        eWord=e;
        songID=s;
    }
    public Word(String e,String m,int ids,int s){
        mWord=m;
        eWord=e;
        id=ids;
        songID=s;
    }
    public String getMiwokTranslation(){
        return mWord;
    }
    public String getDefaultTranslation(){
        return eWord;
    }
    public int getImageResourceID(){
        return id;
    }
    public boolean hasImage(){
        return id!=NO_IMAGE_PROVIDED;
    }
    public int getAudioID(){
        return songID;
    }
}
