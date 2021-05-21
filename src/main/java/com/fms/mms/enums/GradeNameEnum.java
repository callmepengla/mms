package com.fms.mms.enums;

/**
 * 年级名称枚举类型
 */
public enum GradeNameEnum {

    GAO_YI(1067246875800000083L,"高一"),

    GAO_ER(1067246875800000084L,"高二"),

    GAO_SAN(1067246875800000085L,"高三");

    public Long id;

    public String cn;

    GradeNameEnum(Long id, String cn){
        this.id = id;
        this.cn = cn;
    }

    /**
     * 根据id获取年级名称
     * @param id
     * @return
     */
    public static String getCnById(Long id){
        GradeNameEnum[] values = GradeNameEnum.values();
        for (GradeNameEnum value : values){
            if (value.id.equals(id)){
                return value.cn;
            }
        }
        return null;
    }
}
