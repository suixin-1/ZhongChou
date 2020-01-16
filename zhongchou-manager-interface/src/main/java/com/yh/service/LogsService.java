package com.yh.service;

import java.util.List;

import com.yh.pojo.Logs;
import com.yh.pojo.LogsExample;
import com.yh.pojo.User;
import com.yh.pojo.zhongchouResult;
/**
 * 用户日志Service
 * @author 陈家亮
 * 
 */
public interface LogsService {
	
   //查询列表
   List<Logs> selectLogsAll();
   //根据用户id模糊查询
   List<Logs> selectLogsByUid(int logUsId);
   
   //根据id查询用户日志信息
   Logs selectLogsById(Integer logId);
   //根据id查询用户信息
   User selectUserById(Integer usId);
   //添加
   int addLogs(Logs logs);
   
   //详情/修改
   int updateLogs(Logs logs);
   
   //删除
   zhongchouResult delteteLogs(Integer logId);

}
