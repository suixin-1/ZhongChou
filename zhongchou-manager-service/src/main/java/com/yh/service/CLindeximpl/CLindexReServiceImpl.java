package com.yh.service.CLindeximpl;
/**
 * 前端首页实现类
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ProjectsMapper;
import com.yh.mapper.CLindexmapper.CLindexmapper;
import com.yh.pojo.Projects;
import com.yh.pojo.ProjectsExample;
import com.yh.pojo.ProjectsExample.Criteria;
import com.yh.pojo.CLindex.CLindexRe;
import com.yh.service.CLindex.CLindexReService;
@Service
public class CLindexReServiceImpl implements CLindexReService{
@Autowired
private CLindexmapper CLindexmapper;
@Autowired
private ProjectsMapper  projectsMapper;

@Override
public List<CLindexRe> selectCLindexRe(int r_ps_id) {

	return 	CLindexmapper.selectCLindexRe(r_ps_id);
}

@Override
public List<CLindexRe> selectCLindexRejj(int ps_type) {
	return 	CLindexmapper.selectCLindexRejj(ps_type);

}

@Override
public List<Projects> selectTypeExample(Projects example) {
	ProjectsExample example2 = new ProjectsExample();
	Criteria criteria = example2.createCriteria();
	criteria.andPsTypeEqualTo(example.getPsType());
	return projectsMapper.selectByExample(example2);
}

@Override
public List<Projects> selectParticulars(Projects example) {
	ProjectsExample example2 = new ProjectsExample();
	Criteria criteria = example2.createCriteria();
	criteria.andPsIdEqualTo(example.getPsId());
	//.selectByExample(example2)
	return projectsMapper.selectByExampleWithBLOBs(example2);
}


}
