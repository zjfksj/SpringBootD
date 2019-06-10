package com.zj.entity;

/**
 * tb_qing
 * @author 
 */
public class TbQing{
    /**
     * 清单编号
     */
    private String qingNo;

    /**
     * 订单编号
     */
    private String ordersNo;

    /**
     * 运单编号
     */
    private String waybillNo;

    /**
     * 支付单号
     */
    private String payNo;

    /**
     * 状态(0.退单1.人工审单2.负面清单3.查验4.禁止处境初审5.禁止处境复审6.禁止处境7.放行)
     */
    private String stauts;

    /**
     * 创建时间
     */
    private String createTime;
    
    private Stauts st;
    
    private TbOrders tbOrders;
    private TbPay tbPay;
    private TbWaybill tbWaybill;
    

    private static final long serialVersionUID = 1L;

    public TbPay getTbPay() {
		return tbPay;
	}

	public void setTbPay(TbPay tbPay) {
		this.tbPay = tbPay;
	}

	public TbWaybill getTbWaybill() {
		return tbWaybill;
	}

	public void setTbWaybill(TbWaybill tbWaybill) {
		this.tbWaybill = tbWaybill;
	}

	public TbOrders getTbOrders() {
		return tbOrders;
	}

	public void setTbOrders(TbOrders tbOrders) {
		this.tbOrders = tbOrders;
	}

	public String getQingNo() {
        return qingNo;
    }

    public void setQingNo(String qingNo) {
        this.qingNo = qingNo;
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public Stauts getSt() {
		return st;
	}

	public void setSt(Stauts st) {
		this.st = st;
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
        TbQing other = (TbQing) that;
        return (this.getQingNo() == null ? other.getQingNo() == null : this.getQingNo().equals(other.getQingNo()))
            && (this.getOrdersNo() == null ? other.getOrdersNo() == null : this.getOrdersNo().equals(other.getOrdersNo()))
            && (this.getWaybillNo() == null ? other.getWaybillNo() == null : this.getWaybillNo().equals(other.getWaybillNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getStauts() == null ? other.getStauts() == null : this.getStauts().equals(other.getStauts()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQingNo() == null) ? 0 : getQingNo().hashCode());
        result = prime * result + ((getOrdersNo() == null) ? 0 : getOrdersNo().hashCode());
        result = prime * result + ((getWaybillNo() == null) ? 0 : getWaybillNo().hashCode());
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getStauts() == null) ? 0 : getStauts().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qingNo=").append(qingNo);
        sb.append(", ordersNo=").append(ordersNo);
        sb.append(", waybillNo=").append(waybillNo);
        sb.append(", payNo=").append(payNo);
        sb.append(", stauts=").append(stauts);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}