package com.yh.mapper;

import java.util.List;

import com.yh.pojo.Logs;

public interface ClogsMapper {
	List<Logs> selectLogsByUid(int logUsId);
}
