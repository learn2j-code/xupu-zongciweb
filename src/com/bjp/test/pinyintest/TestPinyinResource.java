package com.bjp.test.pinyintest;

import org.junit.Assert;
import org.junit.Test;

import com.bjp.util.jpinyin.PinyinResource;

public class TestPinyinResource {

    @Test
    public void testPinyinResource() {
        Assert.assertTrue(PinyinResource.getChineseResource().size() > 0);
        Assert.assertTrue(PinyinResource.getMutilPinyinResource().size() > 0);
        Assert.assertTrue(PinyinResource.getPinyinResource().size() > 0);
    }
}
