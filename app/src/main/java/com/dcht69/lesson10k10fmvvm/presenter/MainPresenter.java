package com.dcht69.lesson10k10fmvvm.presenter;

public class MainPresenter {
    private double sum;
    private final OnMainCallBack callBack;

    public MainPresenter(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    public double getSum() {
        return sum;
    }

    public void calSum(String txtNumA, String txtNumB) {
        try {
            double a = Double.parseDouble(txtNumA);
            double b = Double.parseDouble(txtNumB);
            sum = a + b;

            callBack.updateResult(sum);


        } catch (Exception e) {
            callBack.notify("Error: " + e.getMessage());
        }
    }
}
