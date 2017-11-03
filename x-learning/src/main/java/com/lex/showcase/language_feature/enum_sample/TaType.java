package com.lex.showcase.language_feature.enum_sample;

import org.apache.commons.lang.StringUtils;

public enum TaType {

    NAN_FANG("01", "675", "南方", TaCategory.FDS),
    HUA_XIA("03", "675", "华夏", TaCategory.FDS),
    HUA_AN("04", "675", "华安", TaCategory.FDS),
    BOSERA_FDS("05", "675", "博时代销TA", TaCategory.FDS),
    PENG_HUA("06", "675", "鹏华", TaCategory.FDS),
    DA_CHENG("09", "675", "大成", TaCategory.FDS),
    YIFANGDA("11", "675", "易方达", TaCategory.FDS),
    YIN_HE("15", "675", "银河", TaCategory.FDS),
    ZHAO_SHANG("17", "675", "招商", TaCategory.FDS),
    YIN_HUA("18", "675", "银华", TaCategory.FDS),
    JIN_YING("21", "675", "金鹰", TaCategory.FDS),
    JING_DE("26", "675", "景顺长城 ", TaCategory.FDS),
    GUANG_FA("27", "675", "广发", TaCategory.FDS),
    SHEN_WAN("31", "675", "申万", TaCategory.FDS),
    NUO_AN("32", "675", "诺安", TaCategory.FDS),
    XING_YE("34", "675", "兴全", TaCategory.FDS),
    ZHONG_HAI("39", "675", "中海", TaCategory.FDS),
    TIAN_HONG("42", "675", "天弘", TaCategory.FDS),
    XIN_HUA("43", "675", "新华", TaCategory.FDS),
    HUA_TAI("46", "675", "华泰", TaCategory.FDS),
    GONG_YIN("48", "675", "工银", TaCategory.MFT0),
    XIN_CHENG("55", "675", "信诚", TaCategory.FDS),
    PING_AN("70", "675", "平安大华", TaCategory.FDS),
    GUO_JIN("76", "675", "国金", TaCategory.FDS),
    DE_BANG("77", "675", "德邦", TaCategory.FDS),
    INTEROTC("899", "221", "中证TA", TaCategory.OTC),
    ZHD_SHEN("98", "675", "中登深市", TaCategory.FDS),
    ZHD_HU("99", "675", "中登沪市", TaCategory.FDS),
//    HIGHEND("H9", "675", "华信资管TA", TaCategory.HIGHEND),
    BOSERA("ZX05", "675", "博时直销TA", TaCategory.DIRECT),;

    private String code;
    private String outerCode;
    private String label;
    private TaCategory category;

    TaType(String code, String outerCode, String label, TaCategory category) {
        this.code = code;
        this.outerCode = outerCode;
        this.label = label;
        this.category = category;
    }

    public static TaType parse(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (TaType ta : TaType.values()) {
            if (StringUtils.equalsIgnoreCase(ta.code, code)) {
                return ta;
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

    public String getOuterCode() {
        return outerCode;
    }

    public TaCategory getCategory() {
        return category;
    }

}

