package markmann.dennis.groupBuilder.test;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to start the default test operations. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class DefaultTestCreator {

    public final void startTests(final Pojo pojo) {

        new ArrayTest().testArrays(pojo);
        new SortingTest().testGroupLists(pojo.getGroupList());

    }
}
