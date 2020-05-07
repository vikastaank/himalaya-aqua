package com.himalaya.aqua.aqua.core.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.himalaya.aqua.aqua.core.basic.ResultVO;

@RestControllerAdvice
public class WebRestControllerAdvice {
    public static final String RESPONSE_FAILURE = "FAILURE";

    @ExceptionHandler(HimalayaAquaException.class)
    public ResultVO<Object> handleNotFoundException(HimalayaAquaException ex) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setStatus(RESPONSE_FAILURE);
        resultVO.setStatusCode(500);
        resultVO.setStatusMsg(ex.getMessage());
        ex.printStackTrace();
        return resultVO;
    }

}