package com.example.mitchelle.cohort7.models;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mitchelle on 9/1/16.
 */
public class Animal implements Parcelable {
    private String first_name;
    private String gender;
    private String About;
    private String email;
    private String picture;

    public Animal() {

    }

    public Animal( String first_name, String gender, String About, String email, String picture ) {
        this.first_name = first_name;
        this.gender = gender;
        this.About = About;
        this.email = email;
        this.picture = picture;
    }

    public Animal( Parcel source ) {
        first_name = source.readString();
        gender = source.readString();
        About = source.readString();
        email = source.readString();
        picture = source.readString();
    }

    public String getpicture() {
        return picture;
    }

    public void setpicture(String picture) {
        this.picture = picture;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String About) {
        this.About = About;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return first_name;
    }

    public void setName(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        applyDefaultValues();

        dest.writeString( first_name );
        dest.writeString( gender );
        dest.writeString( About );
        dest.writeString( email );
        dest.writeString( picture );
    }

    private void applyDefaultValues() {
        if( first_name == null )
            first_name = "";
        if( gender == null )
            gender = "";
        if( About == null )
            About = "";
        if( email == null )
            email = "";
        if( picture == null )
            picture = "";
    }

    public static Creator<Animal> CREATOR = new Creator<Animal>() {

        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal( source );
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}