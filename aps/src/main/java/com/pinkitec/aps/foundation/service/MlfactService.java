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

import com.pinkitec.aps.foundation.dao.MlfactDao;
import com.pinkitec.aps.foundation.pojo.MlfactInfo;
import com.pinkitec.core.dao.DneBaseServiceImp;
import com.pinkitec.core.page.PageFilterSet;
import com.pinkitec.core.page.PageResult;

/**
 * @author sandong.xiao
 */
 @Service
public class MlfactService extends DneBaseServiceImp<MlfactInfo>{
	
	@Autowired
	private MlfactDao mlfactDao;
	
	
	@Autowired
	private EntityManager em;
	

	//@Cacheable(value="MlfactInfoCache", keyGenerator = "wiselyKeyGenerator")
	public MlfactInfo getMlfactByKey(String mluuid){
		return mlfactDao.findById(mluuid).orElse(null);
	}
	
	//@CacheEvict(value="MlfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public MlfactInfo addMlfact(MlfactInfo mlfact){
		return mlfactDao.saveAndFlush(mlfact);
	}
	
	//@CacheEvict(value="MlfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public List<MlfactInfo> addMlfactList(List<MlfactInfo> mlfactLsit){
		List<MlfactInfo> result=new ArrayList<MlfactInfo>();
		for (MlfactInfo mlfact:mlfactLsit) {
			em.persist(mlfact);
			result.add(mlfact);
		}
		return result;
	}
	
	//@CacheEvict(value="MlfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public MlfactInfo deleteMlfact(MlfactInfo mlfact){
		mlfactDao.delete(mlfact);
		return mlfact;
	}
	
	//@CacheEvict(value="MlfactInfoCache", allEntries=true)
	@Modifying
	@Transactional
	public MlfactInfo updateMlfact(MlfactInfo mlfact){
		return mlfactDao.saveAndFlush(mlfact);
	}
	
	//@Cacheable(value="MlfactInfoCache", keyGenerator = "wiselyKeyGenerator")
	public PageResult<MlfactInfo> findHqlByFilter(PageFilterSet[] filterSets, Pageable pageable){
		return this.findHqlByFilter(MlfactInfo.class, filterSets, pageable);
	}
}
