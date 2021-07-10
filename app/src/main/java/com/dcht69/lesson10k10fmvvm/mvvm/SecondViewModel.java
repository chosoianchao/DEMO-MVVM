package com.dcht69.lesson10k10fmvvm.mvvm;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class SecondViewModel extends ViewModel {
    private final MutableLiveData<Double> sum = new MutableLiveData<>(0.0);
    private final MutableLiveData<String> msg = new MutableLiveData<>(null);
    private final MutableLiveData<Boolean> isLangEn = new MutableLiveData<>(false);
    private final MediatorLiveData<String> result = new MediatorLiveData<>();

    public MediatorLiveData<String> getResult() {
        Observer<Object> excuteObserve = new Observer<Object>() {
            @Override
            public void onChanged(Object value) {
                if (isLangEn.getValue()) {
                    result.setValue("Result =" + sum.getValue());
                } else {
                    result.setValue("KQ =" + sum.getValue());
                }
            }
        };
        result.addSource(sum, excuteObserve);
        result.addSource(isLangEn, excuteObserve);
        return result;
    }

    public MutableLiveData<String> getMsg() {
        return msg;
    }

    public void calSum(String txtNumA, String txtNumB) {
        try {
            double a = Double.parseDouble(txtNumA);
            double b = Double.parseDouble(txtNumB);
            sum.setValue(a + b);

            //callBack.updateResult(sum);

        } catch (Exception e) {
            //callBack.notify("Error: " + e.getMessage());
            msg.setValue("Error" + e.getMessage());
        }
    }

    public void setLangEn(boolean isChecked) {
        isLangEn.setValue(isChecked);
    }
}
