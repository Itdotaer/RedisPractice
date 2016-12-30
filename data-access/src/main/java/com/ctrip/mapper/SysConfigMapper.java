package com.ctrip.mapper;

import com.ctrip.pojo.SysConfig;

import java.util.List;

public interface SysConfigMapper {
    List<SysConfig> select(String n);
}