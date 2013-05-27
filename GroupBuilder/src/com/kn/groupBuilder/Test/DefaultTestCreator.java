package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Storage.Pojo;

public class DefaultTestCreator {

    public final void startTests(final Pojo pojo) {

        new ArrayTest().testArrays(pojo);
        new SortingTest().testGroupLists(pojo.getGroupList());

    }
}
