package edu.ncsu.calorietracker.viewmodel;

import android.icu.text.AlphabeticIndex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> name;
    private MutableLiveData<Integer> weight;
    private MutableLiveData<String> weightText;
    private MutableLiveData<String> gender;
    private MutableLiveData<Integer> height;
    private MutableLiveData<String> heightText;
    private MutableLiveData<Integer> age;
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
    public void setWeight(int weightIn) {
        weight.setValue(weightIn);
        weightText.setValue("Weight: " + weight);
    }

    public LiveData<String> getGender() {return gender;}
    public void setGender(String text) {gender.setValue("Gender: " + text);}

    public LiveData<String> getHeight() {return heightText;}
    public void setHeight(int heightIn) {
        height.setValue(heightIn);
        heightText.setValue("Height: " + height);
    }

    public LiveData<String> getAge() {return ageText;}
    public void setAge(int ageIn) {
        age.setValue(ageIn);
        ageText.setValue("Age: " + age);
    }
}