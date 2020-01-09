package com.yh.mapper.CLindexmapper;
/**
 * 前端首页  dao接口
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yh.pojo.CLindex.CLindexRe;

public interface CLindexmapper {
/**
 * 查询所有数据
 * 
 * @return
 */
List<CLindexRe>	selectCLindexRe(@Param("r_ps_id")int r_ps_id);
List<CLindexRe> selectCLindexRejj(@Param("ps_type")int ps_type);
	
}
