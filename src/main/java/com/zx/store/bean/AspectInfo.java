package com.zx.store.bean;

import java.util.Date;

public class AspectInfo {
    private Date startTime;
    private Date endTime;
    private long time;
    private String jsonArgs;
    private String url;
    private String clazzName;
    private String methodName;
    private String jsonResult;

    public AspectInfo(){};

    public AspectInfo(Date startTime,Date endTime, long time, String jsonArgs, String url, String clazzName, String methodName, String jsonResult) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
        this.jsonArgs = jsonArgs;
        this.url = url;
        this.clazzName = clazzName;
        this.methodName = methodName;
        this.jsonResult = jsonResult;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getJsonArgs() {
        return jsonArgs;
    }

    public void setJsonArgs(String jsonArgs) {
        this.jsonArgs = jsonArgs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    @Override
    public String toString() {
        return "AspectInfo{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", time=" + time +
                ", jsonArgs='" + jsonArgs + '\'' +
                ", url='" + url + '\'' +
                ", clazzName='" + clazzName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", jsonResult='" + jsonResult + '\'' +
                '}';
    }
}
