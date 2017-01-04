package com.ctrip.access.mapper;

import com.ctrip.access.pojo.SysConfig;
import java.util.List;

public interface SysConfigMapper {
    /**
     * 根据variable获取SysConfig
     * @param variable
     * @return
     */
    List<SysConfig> select(String variable);
}