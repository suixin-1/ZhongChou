package com.yh.service.CLindex;

import java.util.List;

import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import com.yh.pojo.CLindex.CLindexRe;

public interface CLindexReService {

	
	/**
	 * 查询所有数据
	 * 
	 * @return
	 */
	List<CLindexRe>	selectCLindexRe(int r_ps_id);
	/**
	 * 查询即将开始的所有数据
	 * 
	 * @return
	 */
	List<CLindexRe> selectCLindexRejj(int ps_type);
	
	List<Projects> selectTypeExample(Projects example);
	
	List<Projects> selectParticulars(Projects example);
}
