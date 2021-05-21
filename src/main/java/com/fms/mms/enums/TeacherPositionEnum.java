package com.fms.mms.enums;

public enum TeacherPositionEnum {
    BAN_ZHUREN(1067246875800000087L,"班主任"),

    PU_TONG(1067246875800000088L,"普通任课老师");

    public Long id;

    public  String cn;

    TeacherPositionEnum(Long id, String cn){
        this.id = id;
        this.cn = cn;
    }

    /**
     * 通过id获取课程名称
     * @param id
     * @return
     */
    public static String getCnById(Long id){
        TeacherPositionEnum[] values = TeacherPositionEnum.values();
        for (TeacherPositionEnum value : values){
            if (value.id.equals(id)){
                return value.cn;
            }
        }
        return null;
    }
}
