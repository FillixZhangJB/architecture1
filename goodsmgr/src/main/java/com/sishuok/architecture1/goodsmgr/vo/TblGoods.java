package com.sishuok.architecture1.goodsmgr.vo;

import javax.persistence.*;

@Table(name = "tbl_goods")
public class TblGoods {
    @Id
    private String uuid;

    private String name;

    @Column(name = "imgPath")
    private String imgpath;

    private String description;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return imgPath
     */
    public String getImgpath() {
        return imgpath;
    }

    /**
     * @param imgpath
     */
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}