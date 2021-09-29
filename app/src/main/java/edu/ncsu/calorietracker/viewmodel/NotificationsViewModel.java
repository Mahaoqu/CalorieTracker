package edu.ncsu.calorietracker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> name;
    private MutableLiveData<String> weight;
    private MutableLiveData<String> gender;
    private MutableLiveData<String> height;
    private MutableLiveData<String> age;

    public NotificationsViewModel() {
        name = new MutableLiveData<>();
        weight = new MutableLiveData<>();
        gender = new MutableLiveData<>();
        height = new MutableLiveData<>();
        age = new MutableLiveData<>();
    }

    public LiveData<String> getName() {return name;}
    public void setName(String text) {name.setValue("Name: " + text);}

    public LiveData<String> getWeight() {return weight;}
    public void setWeight(String weightIn) {
        weight.setValue("Weight: " + weightIn + "kg");
    }

    public LiveData<String> getGender() {return gender;}
    public void setGender(String text) {gender.setValue("Gender: " + text);}

    public LiveData<String> getHeight() {return height;}
    public void setHeight(String heightIn) {
        height.setValue("Height: " + heightIn + "cm");
    }

    public LiveData<String> getAge() {return age;}
    public void setAge(String ageIn) {
        age.setValue("Age: " + ageIn);
    }
}