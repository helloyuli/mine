/**
 *@copyright :Copyright @2018, Pinkitec ltd. All right reserved.
 */
package com.pinkitec.aps.foundation.http;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinkitec.aps.foundation.pojo.TyfactInfo;
import com.pinkitec.aps.foundation.service.TyfactService;
import com.pinkitec.aps.remote.TyfactHttp;
import com.pinkitec.aps.remote.TyfactHttpInfo;
import com.pinkitec.core.http.DneHttpError;
import com.pinkitec.core.http.DneHttpResponse;

/**
 * @author sandong.xiao
 */
@RestController
public class TyfactHttpImp implements TyfactHttp {

	@Autowired
	private TyfactService tyfactService;

	@RequestMapping(value="/http/tyfact/get")
	public DneHttpResponse<TyfactHttpInfo> getTyfactByKey(@RequestParam("tyfaid") String tyfaid){
		return new DneHttpResponse<TyfactHttpInfo>(transformObj(tyfactService.getTyfactByKey( tyfaid)));
	}
	
	@RequestMapping(value="/http/tyfact/add")
	public DneHttpResponse<TyfactHttpInfo> addTyfact(@RequestBody TyfactHttpInfo tyfact){
		return new DneHttpResponse<TyfactHttpInfo>(transformObj(tyfactService.addTyfact(transformObj(tyfact))));
	}
	
	@RequestMapping(value="/http/tyfact/addTyfactList")
	public DneHttpResponse<TyfactHttpInfo> addTyfactList(@RequestBody List<TyfactHttpInfo> tyfactList){
		return new DneHttpResponse<TyfactHttpInfo>(transformList(tyfactService.addTyfactList(transformList_B(tyfactList))));
	}
	
	@RequestMapping(value="/http/tyfact/update")
	public DneHttpResponse<TyfactHttpInfo> updateTyfact(@RequestBody TyfactHttpInfo tyfact){
		return new DneHttpResponse<TyfactHttpInfo>(transformObj(tyfactService.updateTyfact(transformObj(tyfact))));
	}
	
	@RequestMapping(value="/http/tyfact/delete")
	public DneHttpResponse<TyfactHttpInfo> deleteTyfact(@RequestBody TyfactHttpInfo tyfact){
		return new DneHttpResponse<TyfactHttpInfo>(transformObj(tyfactService.deleteTyfact(transformObj(tyfact))));
	}

	private java.util.List<TyfactInfo> transformList_B(java.util.List<TyfactHttpInfo> list){
		java.util.List<TyfactInfo> result = new java.util.ArrayList<TyfactInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(TyfactHttpInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}

	
	private java.util.List<TyfactHttpInfo> transformList(java.util.List<TyfactInfo> list){
		java.util.List<TyfactHttpInfo> result = new java.util.ArrayList<TyfactHttpInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(TyfactInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}
	
	private TyfactInfo transformObj(TyfactHttpInfo httpInfo){
		if(httpInfo == null)
			return null;
			
		TyfactInfo info = new TyfactInfo();
		info.setTyfaid(httpInfo.getTyfaid());
	    info.setCompanycode(httpInfo.getCompanycode());
	    info.setTeuuid(httpInfo.getTeuuid());
	    info.setCrteno(httpInfo.getCrteno()); 
	    info.setCrtenm(httpInfo.getCrtenm()); 
	    info.setSxtype(httpInfo.getSxtype()); 
	    info.setFactor(httpInfo.getFactor());
		info.setTxtyf1(httpInfo.getTxtyf1());
		info.setTxtyf2(httpInfo.getTxtyf2());
		info.setTxtyf3(httpInfo.getTxtyf3());
		info.setRemark(httpInfo.getRemark());
		info.setCretby(httpInfo.getCretby());
		info.setCrettm(httpInfo.getCrettm());
		info.setOprtby(httpInfo.getOprtby());
		info.setOprttm(httpInfo.getOprttm());
		return info;
	}
	
	private TyfactHttpInfo transformObj(TyfactInfo info){
		if(info == null)
			return null;
			
		TyfactHttpInfo httpInfo = new TyfactHttpInfo();
		httpInfo.setTyfaid(info.getTyfaid());
	    httpInfo.setCompanycode(info.getCompanycode());
	    httpInfo.setTeuuid(info.getTeuuid());
	    httpInfo.setCrteno(info.getCrteno()); 
	    httpInfo.setCrtenm(info.getCrtenm()); 
	    httpInfo.setSxtype(info.getSxtype()); 
	    httpInfo.setFactor(info.getFactor());
		httpInfo.setTxtyf1(info.getTxtyf1());
		httpInfo.setTxtyf2(info.getTxtyf2());
		httpInfo.setTxtyf3(info.getTxtyf3());
		httpInfo.setRemark(info.getRemark());
		httpInfo.setCretby(info.getCretby());
		httpInfo.setCrettm(info.getCrettm());
		httpInfo.setOprtby(info.getOprtby());
		httpInfo.setOprttm(info.getOprttm());
		return httpInfo;
	}
	
	private DneHttpResponse<TyfactHttpInfo> happenError(String errorCode, 
			String errorMsg, String presentationMsg){
		DneHttpResponse<TyfactHttpInfo> response = new DneHttpResponse<TyfactHttpInfo>();
		DneHttpError error = new DneHttpError();
		error.setErrorCode(errorCode);
		error.setErrorMsg(errorMsg);
		error.setPresentationMsg(presentationMsg);
		response.setError(error);
		return response;
	}

}
