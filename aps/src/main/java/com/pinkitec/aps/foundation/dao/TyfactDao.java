/**
 *@copyright :Copyright @2018, Pinkitec ltd. All right reserved.
 */
package com.pinkitec.aps.foundation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinkitec.aps.foundation.pojo.TyfactInfo;

/**
 * @author sandong.xiao
 */
public interface TyfactDao extends JpaRepository<TyfactInfo, String> {
	
}
