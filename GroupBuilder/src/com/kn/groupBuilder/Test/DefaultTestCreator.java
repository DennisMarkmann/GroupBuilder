package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to start the default test operations. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class DefaultTestCreator {

    public final void startTests(final Pojo pojo) {

        new ArrayTest().testArrays(pojo);
        new SortingTest().testGroupLists(pojo.getGroupList());

    }
}
