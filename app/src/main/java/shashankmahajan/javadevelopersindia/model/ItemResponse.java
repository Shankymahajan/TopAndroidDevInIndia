package shashankmahajan.javadevelopersindia.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashankmahajan on 27/03/17.
 */

public class ItemResponse  {

    @SerializedName("items")
    @Expose
    private List<Item> items ;

    public List<Item> getItems(){
        return items;
    }
    public void setItems(List<Item> items){
        this.items = items;
    }


}
