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

import com.pinkitec.aps.foundation.dao.TyfactDao;
import com.pinkitec.aps.foundation.pojo.TyfactInfo;
import com.pinkitec.core.dao.DneBaseServiceImp;
import com.pinkitec.core.page.PageFilterSet;
import com.pinkitec.core.page.PageResult;

/**
 * @author sandong.xiao
 */
 @Service
public class TyfactService extends DneBaseServiceImp<TyfactInfo>{
	
	@Autowired
	private TyfactDao tyfactDao;
	
	
	@Autowired
	private EntityManager em;
	

	//@Cacheable(value="TyfactInfoCache", keyGenerator = "wiselyKeyGenerator")
	public TyfactInfo getTyfactByKey(String tyfaid){
		return tyfactDao.findById(tyfaid).orElse(null);
	}
	
	//@CacheEvict(value="TyfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public TyfactInfo addTyfact(TyfactInfo tyfact){
		return tyfactDao.saveAndFlush(tyfact);
	}
	
	//@CacheEvict(value="TyfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public List<TyfactInfo> addTyfactList(List<TyfactInfo> tyfactLsit){
		List<TyfactInfo> result=new ArrayList<TyfactInfo>();
		for (TyfactInfo tyfact:tyfactLsit) {
			em.persist(tyfact);
			result.add(tyfact);
		}
		return result;
	}
	
	//@CacheEvict(value="TyfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public TyfactInfo deleteTyfact(TyfactInfo tyfact){
		tyfactDao.delete(tyfact);
		return tyfact;
	}
	
	//@CacheEvict(value="TyfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public TyfactInfo updateTyfact(TyfactInfo tyfact){
		return tyfactDao.saveAndFlush(tyfact);
	}
	
	//@Cacheable(value="TyfactInfoCache", keyGenerator = "wiselyKeyGenerator")
	public PageResult<TyfactInfo> findHqlByFilter(PageFilterSet[] filterSets, Pageable pageable){
		return this.findHqlByFilter(TyfactInfo.class, filterSets, pageable);
	}
}
