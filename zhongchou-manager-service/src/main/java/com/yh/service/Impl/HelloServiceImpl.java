package com.yh.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.FundingMapper;
import com.yh.pojo.Funding;
import com.yh.pojo.FundingExample;
import com.yh.service.HelloService;
@Service
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	private FundingMapper fundingMapper;
	@Override
	public void selectFundingAll() {
		//System.out.println("iuytrewdfgh");
	}

}
