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

import com.pinkitec.aps.foundation.pojo.MlfactInfo;
import com.pinkitec.aps.foundation.service.MlfactService;
import com.pinkitec.aps.remote.MlfactHttp;
import com.pinkitec.aps.remote.MlfactHttpInfo;
import com.pinkitec.core.http.DneHttpError;
import com.pinkitec.core.http.DneHttpResponse;

/**
 * @author sandong.xiao
 */
@RestController
public class MlfactHttpImp implements MlfactHttp {

	@Autowired
	private MlfactService mlfactService;

	@RequestMapping(value="/http/mlfact/get")
	public DneHttpResponse<MlfactHttpInfo> getMlfactByKey(@RequestParam("mluuid") String mluuid){
		return new DneHttpResponse<MlfactHttpInfo>(transformObj(mlfactService.getMlfactByKey( mluuid)));
	}
	
	@RequestMapping(value="/http/mlfact/add")
	public DneHttpResponse<MlfactHttpInfo> addMlfact(@RequestBody MlfactHttpInfo mlfact){
		return new DneHttpResponse<MlfactHttpInfo>(transformObj(mlfactService.addMlfact(transformObj(mlfact))));
	}
	
	@RequestMapping(value="/http/mlfact/addMlfactList")
	public DneHttpResponse<MlfactHttpInfo> addMlfactList(@RequestBody List<MlfactHttpInfo> mlfactList){
		return new DneHttpResponse<MlfactHttpInfo>(transformList(mlfactService.addMlfactList(transformList_B(mlfactList))));
	}
	
	@RequestMapping(value="/http/mlfact/update")
	public DneHttpResponse<MlfactHttpInfo> updateMlfact(@RequestBody MlfactHttpInfo mlfact){
		return new DneHttpResponse<MlfactHttpInfo>(transformObj(mlfactService.updateMlfact(transformObj(mlfact))));
	}
	
	@RequestMapping(value="/http/mlfact/delete")
	public DneHttpResponse<MlfactHttpInfo> deleteMlfact(@RequestBody MlfactHttpInfo mlfact){
		return new DneHttpResponse<MlfactHttpInfo>(transformObj(mlfactService.deleteMlfact(transformObj(mlfact))));
	}

	private java.util.List<MlfactInfo> transformList_B(java.util.List<MlfactHttpInfo> list){
		java.util.List<MlfactInfo> result = new java.util.ArrayList<MlfactInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(MlfactHttpInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}

	
	private java.util.List<MlfactHttpInfo> transformList(java.util.List<MlfactInfo> list){
		java.util.List<MlfactHttpInfo> result = new java.util.ArrayList<MlfactHttpInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(MlfactInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}
	
	private MlfactInfo transformObj(MlfactHttpInfo httpInfo){
		if(httpInfo == null)
			return null;
			
		MlfactInfo info = new MlfactInfo();
		info.setMluuid(httpInfo.getMluuid());
	    info.setCompanycode(httpInfo.getCompanycode());
	    info.setMtlmid(httpInfo.getMtlmid());
	    info.setSkuno(httpInfo.getSkuno()); 
	    info.setSkunam(httpInfo.getSkunam()); 
	    info.setSxtype(httpInfo.getSxtype()); 
	    info.setFactor(httpInfo.getFactor());
		info.setTxmlf1(httpInfo.getTxmlf1());
		info.setTxmlf2(httpInfo.getTxmlf2());
		info.setTxmlf3(httpInfo.getTxmlf3());
		info.setRemark(httpInfo.getRemark());
		info.setCretby(httpInfo.getCretby());
		info.setCrettm(httpInfo.getCrettm());
		info.setOprtby(httpInfo.getOprtby());
		info.setOprttm(httpInfo.getOprttm());
		return info;
	}
	
	private MlfactHttpInfo transformObj(MlfactInfo info){
		if(info == null)
			return null;
			
		MlfactHttpInfo httpInfo = new MlfactHttpInfo();
		httpInfo.setMluuid(info.getMluuid());
	    httpInfo.setCompanycode(info.getCompanycode());
	    httpInfo.setMtlmid(info.getMtlmid());
	    httpInfo.setSkuno(info.getSkuno()); 
	    httpInfo.setSkunam(info.getSkunam()); 
	    httpInfo.setSxtype(info.getSxtype()); 
	    httpInfo.setFactor(info.getFactor());
		httpInfo.setTxmlf1(info.getTxmlf1());
		httpInfo.setTxmlf2(info.getTxmlf2());
		httpInfo.setTxmlf3(info.getTxmlf3());
		httpInfo.setRemark(info.getRemark());
		httpInfo.setCretby(info.getCretby());
		httpInfo.setCrettm(info.getCrettm());
		httpInfo.setOprtby(info.getOprtby());
		httpInfo.setOprttm(info.getOprttm());
		return httpInfo;
	}
	
	private DneHttpResponse<MlfactHttpInfo> happenError(String errorCode, 
			String errorMsg, String presentationMsg){
		DneHttpResponse<MlfactHttpInfo> response = new DneHttpResponse<MlfactHttpInfo>();
		DneHttpError error = new DneHttpError();
		error.setErrorCode(errorCode);
		error.setErrorMsg(errorMsg);
		error.setPresentationMsg(presentationMsg);
		response.setError(error);
		return response;
	}

}
