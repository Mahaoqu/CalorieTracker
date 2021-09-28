package edu.ncsu.calorietracker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> name;
    private MutableLiveData<String> weight;
    private MutableLiveData<String> weightText;
    private MutableLiveData<String> gender;
    private MutableLiveData<String> height;
    private MutableLiveData<String> heightText;
    private MutableLiveData<String> age;
    private MutableLiveData<String> ageText;

    public NotificationsViewModel() {
        name = new MutableLiveData<>();
        weight = new MutableLiveData<>();
        weightText = new MutableLiveData<>();
        gender = new MutableLiveData<>();
        height = new MutableLiveData<>();
        heightText = new MutableLiveData<>();
        age = new MutableLiveData<>();
        ageText = new MutableLiveData<>();
    }

    public LiveData<String> getName() {return name;}
    public void setName(String text) {name.setValue("Name: " + text);}

    public LiveData<String> getWeight() {return weightText;}
    public void setWeight(String weightIn) {
        weightText.setValue("Weight: " + weightIn);
    }

    public LiveData<String> getGender() {return gender;}
    public void setGender(String text) {gender.setValue("Gender: " + text);}

    public LiveData<String> getHeight() {return heightText;}
    public void setHeight(String heightIn) {
        heightText.setValue("Height: " + heightIn);
    }

    public LiveData<String> getAge() {return ageText;}
    public void setAge(String ageIn) {
        ageText.setValue("Age: " + ageIn);
    }
}