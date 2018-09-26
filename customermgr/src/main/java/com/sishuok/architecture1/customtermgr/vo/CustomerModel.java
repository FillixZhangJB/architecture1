package com.sishuok.architecture1.customtermgr.vo;

/**
 * Created by zjb on 2018/9/25.
 */
public class CustomerModel {
    private int uuid;
    private String pwd;
    private String customerId;
    private String showName;
    private String trueName;
    private String registerTime;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerModel)) return false;

        CustomerModel that = (CustomerModel) o;

        if (uuid != that.uuid) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (showName != null ? !showName.equals(that.showName) : that.showName != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        return registerTime != null ? registerTime.equals(that.registerTime) : that.registerTime == null;
    }

    @Override
    public int hashCode() {
        int result = uuid;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (showName != null ? showName.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uuid=" + uuid +
                ", pwd='" + pwd + '\'' +
                ", customerId='" + customerId + '\'' +
                ", showName='" + showName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
