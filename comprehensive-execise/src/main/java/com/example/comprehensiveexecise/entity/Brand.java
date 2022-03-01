package com.example.comprehensiveexecise.entity;

public class Brand {
    private Integer id;
    private String brandname;
    private String businessname;
    private Integer order1;
    private String detailinfo;
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public String getDetailinfo() {
        return detailinfo;
    }

    public void setDetailinfo(String detailinfo) {
        this.detailinfo = detailinfo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandname='" + brandname + '\'' +
                ", businessname='" + businessname + '\'' +
                ", order1=" + order1 +
                ", detailinfo='" + detailinfo + '\'' +
                ", status=" + status +
                '}';
    }
}
