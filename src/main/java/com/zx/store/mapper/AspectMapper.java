package com.zx.store.mapper;

import com.zx.store.bean.AspectInfo;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
public interface AspectMapper {
    public void insertAspectInfo(long time, Date startTime,Date endTime, String jsonArgs, String jsonResult, String url, String clazzName, String methodName);
}
