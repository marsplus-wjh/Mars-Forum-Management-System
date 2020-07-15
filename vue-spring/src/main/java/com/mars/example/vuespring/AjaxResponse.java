package com.mars.example.vuespring;

import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;
    private int code; //200, 400, 500
    private String message;
    private Object data;

    public AjaxResponse(){}

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setIsok(true);
        ajaxResponse.setMessage("Success!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    public static AjaxResponse serverDown(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(500);
        ajaxResponse.setIsok(false);
        ajaxResponse.setMessage("Internal Server Failure!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
