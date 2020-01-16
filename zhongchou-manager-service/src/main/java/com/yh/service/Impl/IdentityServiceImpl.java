package com.yh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.CidentityMapper;
import com.yh.mapper.IdentityMapper;
import com.yh.pojo.Identity;
import com.yh.pojo.IdentityExample;
import com.yh.pojo.zhongchouResult;
import com.yh.pojo.IdentityExample.Criteria;
import com.yh.service.identity.IdentityService;

/**
 * 实名审核实现类
 * 
 * @author 陈家亮
 *
 */
@Service
public class IdentityServiceImpl implements IdentityService {

	@Autowired
	private IdentityMapper identityMapper;
	
	@Autowired
	private CidentityMapper cidentityMapper;

	// 查询列表
	@Override
	public List<Identity> selectAllIdentity() {
		IdentityExample example = new IdentityExample();
		List<Identity> selectByExample = identityMapper.selectByExample(example);
		return selectByExample;
	}

	// 详情
	@Override
	public Identity selectIdentityById(Integer usIdentityId) {
		Identity selectByPrimaryKey = identityMapper.selectByPrimaryKey(usIdentityId);
		return selectByPrimaryKey;
	}
    //根据用户ID更新用户状态
	@Override
	public int updateUser(int usId) {
		int updateUser = cidentityMapper.updateUser(usId);
		return updateUser;
	}

	// 删除
	@Override
	public zhongchouResult delteteIdentity(Integer usIdentityId) {
		int delteteIdentitys = identityMapper.deleteByPrimaryKey(usIdentityId);

		if (delteteIdentitys > 0) {
			return zhongchouResult.build(200, "删除成功");
		}

		return zhongchouResult.build(500, "删除失败");
	}

	
	//根据用户ID查询实名审核信息
	@Override
	public Identity selectByUsId(int usId) {
		Identity selectByUsId = cidentityMapper.selectByUsId(usId);
		return selectByUsId;
	}

	//根据用户ID删除一条信息
	@Override
	public int deleteIdentitys(int usId) {
		int deleteIdentity = cidentityMapper.deleteIdentity(usId);
		/*if (deleteIdentity > 0) {
			return zhongchouResult.build(200, "删除成功");
		}

		return zhongchouResult.build(500, "删除失败");
	}*/
		return deleteIdentity;
	}

	@Override
	public Identity selectByUsId(Integer usId) {
		IdentityExample example = new IdentityExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsIdEqualTo(usId);
		List<Identity> list = identityMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer insertIdentityAll(Identity identity) {
		int i = identityMapper.insertSelective(identity);
		return i;
	}

}
