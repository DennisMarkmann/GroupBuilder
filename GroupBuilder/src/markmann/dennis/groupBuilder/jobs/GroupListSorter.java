package markmann.dennis.groupBuilder.jobs;

import java.util.ArrayList;

import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;

/**
 * Used to sort the GroupList. Sorts the Groups with fix size to the beginning, so that this will be prioritized before the
 * others. Important for building groups.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class GroupListSorter {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/GroupBuilder.log");

    final void sortArrayListForPriority(final Pojo pojo) {
        LOGGER.info("Sorting groupList.");

        boolean hasFixSize = false;
        final ArrayList<Group> groupList = pojo.getGroupList();
        final ArrayList<Group> tempGroupList = new ArrayList<Group>();

        for (final Group group : groupList) {
            hasFixSize = this.hasFixSize(group);

            if (!hasFixSize) {
                tempGroupList.add(group);
            }
        }

        for (final Group group : tempGroupList) {
            groupList.remove(group);
            groupList.add(group);
        }
        pojo.setGroupList(groupList);
    }

    private boolean hasFixSize(final Group group) {
        return group.getFixSize() != 0;
    }
}
