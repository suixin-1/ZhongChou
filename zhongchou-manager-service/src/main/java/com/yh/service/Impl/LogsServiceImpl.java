package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.ClogsMapper;
import com.yh.mapper.LogsMapper;
import com.yh.mapper.UserMapper;
import com.yh.pojo.Logs;
import com.yh.pojo.LogsExample;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
import com.yh.service.LogsService;
/**
 * 用户日志实现类
 * @author 陈家亮
 *
 */
@Service
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsMapper logsMapper;
	
	@Autowired
	private ClogsMapper clogsMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	
	//用户日志列表
	@Override
	public List<Logs> selectLogsAll() {
		LogsExample example = new LogsExample();
		List<Logs> list = logsMapper.selectByExample(example);
		return list;
	}
	@Override
	public List<Logs> selectLogsByUid(int logUsId) {
		List<Logs> selectLogsByUid = clogsMapper.selectLogsByUid(logUsId);
		return selectLogsByUid;
	}
	
	
	
	//添加
	@Override
	public int addLogs(Logs logs) {
		int insertLogs = logsMapper.insert(logs);
		return insertLogs;
	}

	

	//根据id查询用户日志信息
	@Override
	public Logs selectLogsById(Integer logId) {
		Logs selectLogsById = logsMapper.selectByPrimaryKey(logId);
		return selectLogsById;
	}

	//根据id查询用户信息
	@Override
	public User selectUserById(Integer usId) {
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(usId);
		return selectByPrimaryKey;
	}
	//修改
	@Override
	public int updateLogs(Logs logs) {
		int updateLogs = logsMapper.updateByPrimaryKeySelective(logs);
		return updateLogs;
	}


	//删除
	@Override
	public zhongchouResult delteteLogs(Integer logId) {
	
		int deleteLogs = logsMapper.deleteByPrimaryKey(logId);
		
		if(deleteLogs>0){
			return zhongchouResult.build(200, "删除成功");
		}
		
		return zhongchouResult.build(500, "删除失败");
	}
	



	





	

	

	
	
	

}
