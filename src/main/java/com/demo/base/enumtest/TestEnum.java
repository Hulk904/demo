package com.demo.base.enumtest;

/**
 * Created by yangyuan on 2019/3/8.
 *
 * @author yangyuan
 * @date 2019/03/08
 */
public enum TestEnum {
    TEST1(1, "Test1", "原有枚举1"),
    TEST2(2, "Test2", "原有枚举2");

    /**
     * 序号
     */
    private Integer sort;
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    TestEnum(Integer sort, String code, String desc) {
        this.sort = sort;
        this.code = code;
        this.desc = desc;
    }

    public static TestEnum getByName(String value) {
        for (TestEnum testEnum : values()) {
            if (testEnum.toString().equals(value)) {
                return testEnum;
            }
        }
        return null;
    }

    public String toPrintString() {
        StringBuilder str = new StringBuilder();
        str.append("++++++++").append(name()).append("++++++++").append(System.getProperty("line.separator"));
        str.append("+ name: ").append(name()).append(System.getProperty("line.separator"));
        str.append("+ ordinal: ").append(ordinal()).append(System.getProperty("line.separator"));
        str.append("+ sort: ").append(getSort()).append(System.getProperty("line.separator"));
        str.append("+ code: ").append(getCode()).append(System.getProperty("line.separator"));
        str.append("+ desc: ").append(getDesc()).append(System.getProperty("line.separator"));
        str.append("++++++++").append(name()).append("++++++++").append(System.getProperty("line.separator"));
        return str.toString();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
