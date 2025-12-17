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

import com.pinkitec.aps.foundation.pojo.ConsjtInfo;
import com.pinkitec.aps.foundation.service.ConsjtService;
import com.pinkitec.aps.remote.ConsjtHttp;
import com.pinkitec.aps.remote.ConsjtHttpInfo;
import com.pinkitec.core.http.DneHttpError;
import com.pinkitec.core.http.DneHttpResponse;

/**
 * @author sandong.xiao
 */
@RestController
public class ConsjtHttpImp implements ConsjtHttp {

	@Autowired
	private ConsjtService consjtService;

	@RequestMapping(value="/http/consjt/get")
	public DneHttpResponse<ConsjtHttpInfo> getConsjtByKey(@RequestParam("consid") String consid){
		return new DneHttpResponse<ConsjtHttpInfo>(transformObj(consjtService.getConsjtByKey(consid)));
	}
	
	@RequestMapping(value="/http/consjt/add")
	public DneHttpResponse<ConsjtHttpInfo> addConsjt(@RequestBody ConsjtHttpInfo consjt){
		return new DneHttpResponse<ConsjtHttpInfo>(transformObj(consjtService.addConsjt(transformObj(consjt))));
	}
	
	@RequestMapping(value="/http/consjt/addConsjtList")
	public DneHttpResponse<ConsjtHttpInfo> addConsjtList(@RequestBody List<ConsjtHttpInfo> consjtList){
		return new DneHttpResponse<ConsjtHttpInfo>(transformList(consjtService.addConsjtList(transformList_B(consjtList))));
	}
	
	@RequestMapping(value="/http/consjt/update")
	public DneHttpResponse<ConsjtHttpInfo> updateConsjt(@RequestBody ConsjtHttpInfo consjt){
		return new DneHttpResponse<ConsjtHttpInfo>(transformObj(consjtService.updateConsjt(transformObj(consjt))));
	}
	
	@RequestMapping(value="/http/consjt/delete")
	public DneHttpResponse<ConsjtHttpInfo> deleteConsjt(@RequestBody ConsjtHttpInfo consjt){
		return new DneHttpResponse<ConsjtHttpInfo>(transformObj(consjtService.deleteConsjt(transformObj(consjt))));
	}

	private java.util.List<ConsjtInfo> transformList_B(java.util.List<ConsjtHttpInfo> list){
		java.util.List<ConsjtInfo> result = new java.util.ArrayList<ConsjtInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(ConsjtHttpInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}

	
	private java.util.List<ConsjtHttpInfo> transformList(java.util.List<ConsjtInfo> list){
		java.util.List<ConsjtHttpInfo> result = new java.util.ArrayList<ConsjtHttpInfo>();
		if(list == null || list.size() < 1)
			return result;
		for(ConsjtInfo info : list){
			result.add(transformObj(info));
		}
		return result;
	}
	
	private ConsjtInfo transformObj(ConsjtHttpInfo httpInfo){
		if(httpInfo == null)
			return null;
			
		ConsjtInfo info = new ConsjtInfo();
		info.setConsid(httpInfo.getConsid());
	    info.setCompanycode(httpInfo.getCompanycode());
	    info.setOrtype(httpInfo.getOrtype()); // 车间订单类别属性(大货、样衣、高定)
	    info.setContyp(httpInfo.getContyp()); //工段类型(Cut裁剪、sewwing缝制、ironing整烫、pack包装、bale打包)
	    info.setPeriod(httpInfo.getPeriod()); // 周期（天）(默认0)
		info.setTxcon1(httpInfo.getTxcon1());
		info.setTxcon2(httpInfo.getTxcon2());
		info.setTxcon3(httpInfo.getTxcon3());
		info.setRemark(httpInfo.getRemark());
		info.setCretby(httpInfo.getCretby());
		info.setCrettm(httpInfo.getCrettm());
		info.setOprtby(httpInfo.getOprtby());
		info.setOprttm(httpInfo.getOprttm());
		return info;
	}
	
	private ConsjtHttpInfo transformObj(ConsjtInfo info){
		if(info == null)
			return null;
			
		ConsjtHttpInfo httpInfo = new ConsjtHttpInfo();
		httpInfo.setConsid(info.getConsid());
	    httpInfo.setCompanycode(info.getCompanycode());
	    httpInfo.setOrtype(info.getOrtype()); // 车间订单类别属性(大货、样衣、高定)
	    httpInfo.setContyp(info.getContyp()); //工段类型(Cut裁剪、sewwing缝制、ironing整烫、pack包装、bale打包)
	    httpInfo.setPeriod(info.getPeriod()); // 周期（天）(默认0)
		httpInfo.setTxcon1(info.getTxcon1());
		httpInfo.setTxcon2(info.getTxcon2());
		httpInfo.setTxcon3(info.getTxcon3());
		httpInfo.setRemark(info.getRemark());
		httpInfo.setCretby(info.getCretby());
		httpInfo.setCrettm(info.getCrettm());
		httpInfo.setOprtby(info.getOprtby());
		httpInfo.setOprttm(info.getOprttm());
		return httpInfo;
	}
	
	private DneHttpResponse<ConsjtHttpInfo> happenError(String errorCode, 
			String errorMsg, String presentationMsg){
		DneHttpResponse<ConsjtHttpInfo> response = new DneHttpResponse<ConsjtHttpInfo>();
		DneHttpError error = new DneHttpError();
		error.setErrorCode(errorCode);
		error.setErrorMsg(errorMsg);
		error.setPresentationMsg(presentationMsg);
		response.setError(error);
		return response;
	}

}
