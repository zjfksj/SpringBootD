package com.zj.entity;


/**
 * tb_ enterprise
 * @author 
 */
public class TbEnterprise{
    /**
     * 电商检验检疫备案编号
     */
    private String cbecodeinsp;

    /**
     * 电商名称
     */
    private String cbename;

    /**
     * 业务类型（进口，出口，进出口）
     */
    private String type;

    /**
     * 审核类型（新增，变更，注销）
     */
    private String auditType;

    /**
     * 审核状态（初审，复审)
     */
    private String stauts;

    /**
     * 单位联系人
     */
    private String person;

    /**
     * 创建时间
     */
    private String createTime;

    private static final long serialVersionUID = 1L;

    public String getCbecodeinsp() {
        return cbecodeinsp;
    }

    public void setCbecodeinsp(String cbecodeinsp) {
        this.cbecodeinsp = cbecodeinsp;
    }

    public String getCbename() {
        return cbename;
    }

    public void setCbename(String cbename) {
        this.cbename = cbename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbecodeinsp() == null) ? 0 : getCbecodeinsp().hashCode());
        result = prime * result + ((getCbename() == null) ? 0 : getCbename().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAuditType() == null) ? 0 : getAuditType().hashCode());
        result = prime * result + ((getStauts() == null) ? 0 : getStauts().hashCode());
        result = prime * result + ((getPerson() == null) ? 0 : getPerson().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbecodeinsp=").append(cbecodeinsp);
        sb.append(", cbename=").append(cbename);
        sb.append(", type=").append(type);
        sb.append(", auditType=").append(auditType);
        sb.append(", stauts=").append(stauts);
        sb.append(", person=").append(person);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}