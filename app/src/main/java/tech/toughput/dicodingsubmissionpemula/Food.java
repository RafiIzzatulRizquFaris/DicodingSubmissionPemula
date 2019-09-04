package tech.toughput.dicodingsubmissionpemula;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS-X454Y on 25/05/2019.
 */

public class Food implements Parcelable {
    private String name, remarks, photo, judul, recipe, link;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getJudul() {
        return judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getRecipe() {
        return recipe;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public String getLink() {return link;}
    public void setLink(String link) {this.link = link;}


    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.judul);
        dest.writeString(this.recipe);
        dest.writeString(this.link);
    }
    public Food(){

    }

    private Food(Parcel in){
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.judul = in.readString();
        this.recipe = in.readString();
        this.link = in.readString();
    }
    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }
        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
