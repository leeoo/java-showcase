package com.lex.showcase.language_feature.enum_sample;

import org.apache.commons.lang.StringUtils;

public enum ApKind {

    APPLY_ACCOUNT("001", "开户"),
    CANCEL_ACCOUNT("002", "销户"),
    MODIFY_ACCOUNT("003", "账户信息修改"),
    APPLY_TRADE("022", "申购申请"),
    REDEEM("024", "赎回申请"),
    FORCE_REDEEM("142", "强制赎回"),
    QUICK_REDEEM("098", "快速过户"),
    ACK_APPLY_TRADE("122", "申购确认"),
    ACK_REDEEM("124", "赎回确认"),
    ACK_QUICK_REDEEM("198", "快速过户确认"),
    ACK_MELON("143", "分红确认"),
    APPLY_SUBSCRIB("020", "认购申请"),
    ACK_SUBSCRIB("120", "认购确认"),
    SUBSCRIB_RESULT("130", "认购结果"),
    FORCE_ADD("144", "强制调增"),
    FORCE_SUBTRACT("145", "强制调减"),
    FOUND_ROUND_UP("150", "基金清盘"),
    ACK_INCOME("DZ143", "垫资户收益"),
    DZ_FORCE_REDEEM("DZ142", "垫资户强赎"),
    OPEN_ACK_ACCOUNT("101", "开户确认"),
    CANCEL_ACK_ACCOUNT("102", "销户确认"),
    ADD_ACK_ACCOUNT("108", "增开交易帐号确认"),
    DISABLE_ACCOUNT("109", "撤销交易账户确认"),
    MODIFY_DEF_DIVIDEND_METHOD("029", "设置分红方式申请"),
    MODIFY_DEF_DIVIDEND_METHOD_CFM("129", "设置分红方式申请"),
    IPO_FAIL("149", "募集失败"),
    FROZEN_FUND_ACC("104", "基金账户冻结确认"),
    UNFROZEN_FUND_ACC("105", "基金账户解冻确认"),
    LOST_FUND_ACC("106", "挂失确认"),
    FIND_FUND_ACC("107", "解挂确认"),
    TRANSFER_GH("GH", "份额过户"),
    FROZEN("031", "基金份数冻结"),
    UN_FROZEN("032", "基金份数解冻"),
    FROZEN_FUND_VOL("131", "基金份数冻结确认"),
    UN_FROZEN_FUND_VOL("132", "基金份数解冻确认"),
    UN_TRADE_TRANSFER("133", "非交易过户确认"),
    UN_TRADE_TRANSFER_IN("134", "非交易过户转入确认"),
    UN_TRADE_TRANSFER_OUT("135", "非交易过户转出确认"),
    TRANSFER_QUTY("136", "基金转换确认"),
    TRANSFER_QUTY_IN("137", "基金转换转入确认"),
    TRANSFER_QUTY_OUT("138", "基金转换转出确认"),
    QY_DEPOSIT_IN("E01", "账户余额存入"),
    QY_QUICK_REEDM("E02", "账户余额取出"),
    APPLY_REGULAR_INVESTMENT("039", "定投申请"),
    ACK_REGULAR_INVESTMENT("139", "定投确认"),
    ACK_MODIFY_ACCOUNT("103", "账户信息修改确认"),
    APP_RIGHT("080", "确权申请"),
    ACK_RIGHT("180", "确权确认"),

    //非中登规定业务code
    ACK_FAIL_ACCESS_REFUND("233", "确认失败接入方退款"),
    TRADE_FAIL_ACCESS_REFUND("234", "实时发起失败接入方退款"),
    CHECK_FAIL_ACCESS_REFUND("235", "订单校验失败给接入方退款"),
    REVOKE_ORDER("999", "撤销订单(冲正)");


    private String code;
    private String label;

    ApKind(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static ApKind parse(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ApKind apKind : ApKind.values()) {
            if (StringUtils.equals(apKind.code, code.trim())) {
                return apKind;
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}

