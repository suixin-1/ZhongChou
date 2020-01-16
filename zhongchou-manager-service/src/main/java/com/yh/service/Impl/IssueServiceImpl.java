package com.yh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.IssueMapper;
import com.yh.pojo.Draft;
import com.yh.service.IssueService;

@Service
public class IssueServiceImpl  implements IssueService{
@Autowired
private IssueMapper issueMapper;


@Override
public boolean addProject(Draft d) {
	try {
		boolean i=issueMapper.insert(d);
		boolean i1=issueMapper.insert1(d);
		boolean i2=issueMapper.insert2(d);
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		/*if(i&&i1&&i2){
			return true;
		}else{
			return false;
		}	*/	
	} catch (Exception e) {
		
	}
	return true;
}

}
