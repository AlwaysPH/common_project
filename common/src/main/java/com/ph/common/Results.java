package com.ph.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ApiModel("通用返回对象")
public class Results<T> implements Serializable {

    private static final long serialVersionUID = -6692996061747678681L;

    @ApiModelProperty(notes = "状态码：'0'-正常，'-1'-异常")
    private String resultCode;

    @ApiModelProperty(notes = "提示信息")
    private String resultMessage;

    @ApiModelProperty(notes = "当前系统时间戳（毫秒）")
    private long time;

    @ApiModelProperty(notes = "数据")
    private T content;

    @ApiModelProperty(notes = "分页数据")
    private PageResult pageResult;

    public static <T> Results<T> create(String code, String msg, T content, PageResult pageResult) {
        return new Results<>(code, msg, System.currentTimeMillis(), content, pageResult);
    }

    public static <T> Results<T> succeed(T content, IPage ipage){
        PageResult pageResult = PageResult.create(ipage);
        return new Results<T>(ResultConstant.SUCCESS_CODE.getValue(), ResultConstant.SUCCESS_MESSAGE.getValue(), System.currentTimeMillis(), content, pageResult);
    }

    public static <T> Results<T> succeed(String msg, T content) {
        return create(ResultConstant.SUCCESS_CODE.getValue(), msg, content, null);
    }

    public static <T> Results<T> succeed(T content) {
        return succeed(ResultConstant.SUCCESS_MESSAGE.getValue(), content);
    }

    public static <T> Results<T> succeed(String msg, T content, PageResult pageResult) {
        return create(ResultConstant.SUCCESS_CODE.getValue(), msg, content, pageResult);
    }

    public static <T> Results<T> succeed(T content, PageResult pageResult) {
        return create(ResultConstant.SUCCESS_CODE.getValue(), ResultConstant.SUCCESS_MESSAGE.getValue(), content, pageResult);
    }

    public static <T> Results<T> succeed(String msg) {
        return succeed(msg, (T) null);
    }

    public static <T> Results<T> succeed() {
        return succeed(ResultConstant.SUCCESS_MESSAGE.getValue());
    }

    public static <T> Results<T> failed(String msg) {
        return create(ResultConstant.FAILURE_CODE.getValue(), msg, null, null);
    }

    public static <T> Results<T> failed() {
        return failed(ResultConstant.FAILURE_MESSAGE.getValue());
    }

    public static <T> boolean isSucceed(Results<T> results) {
        return results != null && ResultConstant.SUCCESS_CODE.getValue().equals(results.getResultCode());
    }

    /**
     * 返回码+提示消息的枚举
     */
    private enum ResultConstant {
        /**
         * 成功返回码
         */
        SUCCESS_CODE("0"),

        /**
         * 成功返回提示消息
         */
        SUCCESS_MESSAGE("success"),

        /**
         * 失败返回码
         */
        FAILURE_CODE("-1"),

        /**
         * 失败返回提示消息
         */
        FAILURE_MESSAGE("failure");

        private final String value;

        ResultConstant(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
