package com.dzsw.wqh.protocol;

import com.dzsw.wqh.enumeration.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chen.haisheng
 * @create 2018-08-17 14:51
 **/
@Data
@Accessors(chain = true) //链式setter
@JsonInclude(JsonInclude.Include.NON_NULL) //不返回null
public  class ResultResponse
{
	private String code;

	private String message;

	private Object data;

	public ResultResponse() {
	}

	public ResultResponse(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static ResultResponse buildResponseData(ResultEnum resultEnum,Object data) {
		return new ResultResponse(resultEnum.getCode(), resultEnum.getMessage(), data);
	}

	public static ResultResponse buildResponse(ResultEnum resultEnum) {
		return buildResponseData(resultEnum, null);
	}
}