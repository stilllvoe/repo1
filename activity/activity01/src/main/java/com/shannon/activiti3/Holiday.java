package com.shannon.activiti3;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: cm.w
 * @Date: 2019/6/11 21:13
 * @Description:
 */
public class Holiday implements Serializable{

    private String id;  //id
    private String holidayName; //请假申请人
    private Date startTime;   //请假开始时间
    private Date endTime; //请假结束时间
    private Float num; //请假天数
    private String reason;  //请假事由
    private String type;    //请假类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
