package com.zj.entity;

import java.util.List;

/**
 * tb_orders
 * @author 
 */
public class TbOrders{
    /**
     * 订单编号
     */
    private String ordersNo;

    /**
     * 电商名称
     */
    private String cbename;

    /**
     * 电商检验检疫备案编号
     */
    private String cbecodeinsp;

    /**
     * 商品数量
     */
    private Integer goodsNumber;

    /**
     * 下单人
     */
    private String userName;

    /**
     * 订单总金额
     */
    private Float totalMoney;

    /**
     * 创建时间
     */
    private String createTime;
    
    private TbOrdersdetails tbOrdersdetails;

    private static final long serialVersionUID = 1L; 

	public TbOrdersdetails getTbOrdersdetails() {
		return tbOrdersdetails;
	}

	public void setTbOrdersdetails(TbOrdersdetails tbOrdersdetails) {
		this.tbOrdersdetails = tbOrdersdetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }

    public String getCbename() {
        return cbename;
    }

    public void setCbename(String cbename) {
        this.cbename = cbename;
    }

    public String getCbecodeinsp() {
        return cbecodeinsp;
    }

    public void setCbecodeinsp(String cbecodeinsp) {
        this.cbecodeinsp = cbecodeinsp;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbOrders other = (TbOrders) that;
        return (this.getOrdersNo() == null ? other.getOrdersNo() == null : this.getOrdersNo().equals(other.getOrdersNo()))
            && (this.getCbename() == null ? other.getCbename() == null : this.getCbename().equals(other.getCbename()))
            && (this.getCbecodeinsp() == null ? other.getCbecodeinsp() == null : this.getCbecodeinsp().equals(other.getCbecodeinsp()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTotalMoney() == null ? other.getTotalMoney() == null : this.getTotalMoney().equals(other.getTotalMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrdersNo() == null) ? 0 : getOrdersNo().hashCode());
        result = prime * result + ((getCbename() == null) ? 0 : getCbename().hashCode());
        result = prime * result + ((getCbecodeinsp() == null) ? 0 : getCbecodeinsp().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTotalMoney() == null) ? 0 : getTotalMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "TbOrders [ordersNo=" + ordersNo + ", cbename=" + cbename + ", cbecodeinsp=" + cbecodeinsp
				+ ", goodsNumber=" + goodsNumber + ", userName=" + userName + ", totalMoney=" + totalMoney
				+ ", createTime=" + createTime + ", tbOrdersdetails=" + tbOrdersdetails + "]";
	}

}