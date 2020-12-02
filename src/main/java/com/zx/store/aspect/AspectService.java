package com.zx.store.aspect;

import com.zx.store.bean.AspectInfo;
import org.springframework.stereotype.Service;

@Service
public interface AspectService {
    public void insertAspectInfo(AspectInfo aspectInfo);
}
