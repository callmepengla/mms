package com.fms.mms.exception;

import com.fms.mms.utils.ResultCode;

public class MtsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    public MtsException(String msg){
        super(msg);
        this.code = ResultCode.ERROR;
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
