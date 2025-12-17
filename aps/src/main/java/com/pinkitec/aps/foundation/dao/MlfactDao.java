/**
 *@copyright :Copyright @2018, Pinkitec ltd. All right reserved.
 */
package com.pinkitec.aps.foundation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinkitec.aps.foundation.pojo.MlfactInfo;

/**
 * @author sandong.xiao
 */
public interface MlfactDao extends JpaRepository<MlfactInfo, String> {
	
}
