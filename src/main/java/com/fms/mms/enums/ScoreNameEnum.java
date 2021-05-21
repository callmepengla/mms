package com.fms.mms.enums;

/**
 * 课程名称枚举类型
 */
public enum ScoreNameEnum {
    YU_WEN(1067246875800000073L,"语文"),
    SHU_XUE(1067246875800000074L,"数学"),
    YING_YU(1067246875800000075L,"英语"),
    WU_LI(1067246875800000076L,"物理"),
    HUA_XUE(1067246875800000077L,"化学"),
    SHENG_WU(1067246875800000078L,"生物"),
    ZHENG_ZHI(1067246875800000079L,"政治"),
    LI_SHI(1067246875800000080L,"历史"),
    DI_LI(1067246875800000081L,"地理");

    public Long id;

    public String cn;

    ScoreNameEnum(Long id,String cn){
        this.id = id;
        this.cn = cn;
    }

    /**
     * 通过id获取课程名称
     * @param id
     * @return
     */
    public static String getCnById(Long id){
        ScoreNameEnum[] values = ScoreNameEnum.values();
        for (ScoreNameEnum value : values){
            if (value.id.equals(id)){
                return value.cn;
            }
        }
        return null;
    }
}
