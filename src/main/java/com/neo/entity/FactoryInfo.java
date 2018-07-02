package com.neo.entity;

/**
 * Created by Administrator on 2017/12/9.
 */
public class FactoryInfo extends  Factory{


    private String factoryDataNo;
    private String factoryId;
    private String dataTime;
    private String enterPressure;
    private String leavePressure;
    private String enterTemperature;
    private String leaveTemperature;
    private String waterOpen;
    private String plusPressure;
    private String horizontalVibration;
    private String verticalVibration;
    private String millCurrent;
    private String feedVolume;




    public String getFactoryDataNo() {
        return factoryDataNo;
    }

    public void setFactoryDataNo(String factoryDataNo) {
        this.factoryDataNo = factoryDataNo;
    }

    @Override
    public String getFactoryId() {
        return factoryId;
    }

    @Override
    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getEnterPressure() {
        return enterPressure;
    }

    public void setEnterPressure(String enterPressure) {
        this.enterPressure = enterPressure;
    }

    public String getLeavePressure() {
        return leavePressure;
    }

    public void setLeavePressure(String leavePressure) {
        this.leavePressure = leavePressure;
    }

    public String getEnterTemperature() {
        return enterTemperature;
    }

    public void setEnterTemperature(String enterTemperature) {
        this.enterTemperature = enterTemperature;
    }

    public String getLeaveTemperature() {
        return leaveTemperature;
    }

    public void setLeaveTemperature(String leaveTemperature) {
        this.leaveTemperature = leaveTemperature;
    }

    public String getWaterOpen() {
        return waterOpen;
    }

    public void setWaterOpen(String waterOpen) {
        this.waterOpen = waterOpen;
    }

    public String getPlusPressure() {
        return plusPressure;
    }

    public void setPlusPressure(String plusPressure) {
        this.plusPressure = plusPressure;
    }

    public String getHorizontalVibration() {
        return horizontalVibration;
    }

    public void setHorizontalVibration(String horizontalVibration) {
        this.horizontalVibration = horizontalVibration;
    }

    public String getVerticalVibration() {
        return verticalVibration;
    }

    public void setVerticalVibration(String verticalVibration) {
        this.verticalVibration = verticalVibration;
    }

    public String getMillCurrent() {
        return millCurrent;
    }

    public void setMillCurrent(String millCurrent) {
        this.millCurrent = millCurrent;
    }

    public String getFeedVolume() {
        return feedVolume;
    }

    public void setFeedVolume(String feedVolume) {
        this.feedVolume = feedVolume;
    }
}
