/**
 *@copyright :Copyright @2018, Pinkitec ltd. All right reserved.
 */
package com.pinkitec.aps.foundation.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinkitec.aps.foundation.dao.ConsjtDao;
import com.pinkitec.aps.foundation.pojo.ConsjtInfo;
import com.pinkitec.core.dao.DneBaseServiceImp;
import com.pinkitec.core.page.PageFilterSet;
import com.pinkitec.core.page.PageResult;

/**
 * @author sandong.xiao
 */
 @Service
public class ConsjtService extends DneBaseServiceImp<ConsjtInfo>{
	
	@Autowired
	private ConsjtDao consjtDao;
	
	
	@Autowired
	private EntityManager em;
	

	//@Cacheable(value="ConsjtInfoCache", keyGenerator = "wiselyKeyGenerator")
	public ConsjtInfo getConsjtByKey(String consid){
		return consjtDao.findById(consid).orElse(null);
	}
	
	//@CacheEvict(value="ConsjtInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public ConsjtInfo addConsjt(ConsjtInfo consjt){
		return consjtDao.saveAndFlush(consjt);
	}
	
	//@CacheEvict(value="ConsjtInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public List<ConsjtInfo> addConsjtList(List<ConsjtInfo> consjtLsit){
		List<ConsjtInfo> result=new ArrayList<ConsjtInfo>();
		for (ConsjtInfo consjt:consjtLsit) {
			em.persist(consjt);
			result.add(consjt);
		}
		return result;
	}
	
	//@CacheEvict(value="ConsjtInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public ConsjtInfo deleteConsjt(ConsjtInfo consjt){
		consjtDao.delete(consjt);
		return consjt;
	}
	
	//@CacheEvict(value="ConsjtInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public ConsjtInfo updateConsjt(ConsjtInfo consjt){
		return consjtDao.saveAndFlush(consjt);
	}
	
	//@Cacheable(value="ConsjtInfoCache", keyGenerator = "wiselyKeyGenerator")
	public PageResult<ConsjtInfo> findHqlByFilter(PageFilterSet[] filterSets, Pageable pageable){
		return this.findHqlByFilter(ConsjtInfo.class, filterSets, pageable);
	}
}
