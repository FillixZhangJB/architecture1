package com.sishuok.architecture1.customtermgr.vo;

import com.sishuok.architecture1.common.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by zjb on 2018/9/25.
 */
@Table(name = "tbl_customer")
public class CustomerModel extends BaseModel{
    @Id
    @Version
    @Column(name = "uuId")
    private String uuId;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "customerId")
    private String customerId;
    @Column(name = "showName")
    private String showName;
    @Column(name = "trueName")
    private String trueName;
    @Column(name = "registerTime")
    private String registerTime;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
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

        if (uuId != that.uuId) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (showName != null ? !showName.equals(that.showName) : that.showName != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        return registerTime != null ? registerTime.equals(that.registerTime) : that.registerTime == null;
    }

    @Override
    public int hashCode() {
        int result = uuId != null ? uuId.hashCode() : 0;
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
                "uuId=" + uuId +
                ", pwd='" + pwd + '\'' +
                ", customerId='" + customerId + '\'' +
                ", showName='" + showName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
