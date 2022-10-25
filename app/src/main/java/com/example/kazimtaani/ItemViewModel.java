package com.example.kazimtaani;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<ClipData.Item> selectedItem= new
            MutableLiveData<ClipData.Item>();
   public Void selectItem(ClipData.Item item){
       selectedItem.setValue(item);
       return null;
   }
    public LiveData<ClipData.Item> getSelectedItem() {
        return selectedItem;
    }


}
