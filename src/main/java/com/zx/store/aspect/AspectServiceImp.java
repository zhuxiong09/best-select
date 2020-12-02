package com.zx.store.aspect;
import com.zx.store.bean.AspectInfo;
import com.zx.store.mapper.AspectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AspectServiceImp implements AspectService {

    @Autowired
    AspectMapper aspectMapper;

    @Override
    public void insertAspectInfo(AspectInfo aspectInfo) {
         aspectMapper.insertAspectInfo(aspectInfo.getTime(),
                 aspectInfo.getStartTime(),
                 aspectInfo.getEndTime(),
                 aspectInfo.getJsonArgs(),
                 aspectInfo.getJsonResult(),
                 aspectInfo.getUrl(),
                 aspectInfo.getClazzName(),
                 aspectInfo.getMethodName());
    }
}