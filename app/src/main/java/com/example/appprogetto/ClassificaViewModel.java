package com.example.appprogetto;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public class ClassificaViewModel extends AndroidViewModel {

    private ClassificaModel theModel;
    User user;
    List<String> help = new ArrayList<>();

    public ClassificaViewModel(@NonNull Application application) {
        super(application);
        theModel = new ClassificaModel();
    }

    public void setHelp(List<String> help) {
        this.help = help;
        theModel.simulateLoadData(help);
    }


    public int getContactsCount() {
        return theModel.getContactsCount();
    }

    public String getContact(int index) {
        return theModel.getContact(index);
    }
}
