package com.agileboot.common.enums;


import com.agileboot.common.enums.common.YesOrNoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicEnumUtilTest {

    @Test
    public void testFromValue() {

        YesOrNoEnum yes = BasicEnumUtil.fromValue(YesOrNoEnum.class, 1);
        YesOrNoEnum no = BasicEnumUtil.fromValue(YesOrNoEnum.class, 0);

        Assertions.assertEquals("是", yes.description());
        Assertions.assertEquals("否", no.description());

    }
}
