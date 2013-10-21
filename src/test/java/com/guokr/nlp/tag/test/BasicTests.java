package com.guokr.nlp.tag.test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.guokr.nlp.tag.__TAG__;

@RunWith(JUnit4.class)
public class BasicTests {

    @Test
    public void testTag() throws Exception {
        String tagText = __TAG__.INSTANCE.tag("这是个测试");
        assertEquals("这#PN 是#VC 个#M 测试#NN", tagText);
    }

}
