package com.trip.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局错误码（和接口文档完全一致）
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 基础状态码
    SUCCESS(200, "请求成功"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未登录或登录已过期"),
    FORBIDDEN(403, "权限不足"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),

    // 业务错误码
    CAPTCHA_ERROR(10001, "验证码错误"),
    USERNAME_PASSWORD_ERROR(10002, "用户名或密码错误"),
    ORDER_EXPIRED(10003, "订单已过期"),
    STOCK_NOT_ENOUGH(10004, "库存不足"),
    PAY_FAILED(10005, "支付失败"),
    REFUND_FAILED(10006, "退款失败");

    private final Integer code;
    private final String message;
}
