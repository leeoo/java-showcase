package com.lex.showcase.language_feature.enum_sample;

/**
 * 订单状态枚举
 */
public enum OrderStatus {
    SUCCESS("Y", "成功"),
    FAIL("F", "失败"),
    PART_SUCCESS("P", "部分成功"),
    UNPAID("U", "待支付"),
    PROCESSING("I", "处理中"),
    ACCEPTING("A", "已受理"),
    CANCELED("C", "已撤销"),
    CANCELING("G", "撤销中"),
    PAYING("A1", "划款中"),
    RECHARGING("A2", "充值中");

    private String value;
    private String desc;

    OrderStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getValue() {
        return this.value;
    }

    public static OrderStatus getByValue(String value) {
        if (value != null && !value.isEmpty()) {
            OrderStatus[] enums = values();
            OrderStatus[] var2 = enums;
            int var3 = enums.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                OrderStatus code = var2[var4];
                if (code.getValue().equals(value)) {
                    return code;
                }
            }

            return PROCESSING;
        } else {
            return PROCESSING;
        }
    }
}
