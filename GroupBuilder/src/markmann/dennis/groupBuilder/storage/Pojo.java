package markmann.dennis.groupBuilder.storage;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Storage of the application. Contains various elements and is reached through the whole program. Most of the content can be
 * saved via XML files.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class Pojo {

    private ArrayList<Member> memberList = new ArrayList<Member>();;
    private ArrayList<Group> groupList = new ArrayList<Group>();
    private final String[] languageList = { "English", "German" };
    // private final String[] languageList = { "English", "German" };
    private final String[] formatList = { "XML", "TXT" };
    private final Settings settings = new Settings();
    private ResourceBundle languageBundle;
    private boolean error;
    private static Pojo instance;

    public Pojo() {
        instance = this;
    }

    public final ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    public final void setMemberList(final ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public final void setGroupList(final ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public final ArrayList<Group> getGroupList() {
        return this.groupList;
    }

    public final String[] getLanguageList() {
        return this.languageList;
    }

    public final String[] getFormatList() {
        return this.formatList;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    public final Group getGroupByName(final String name) {
        for (final Group group : this.groupList) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public final Member getMemberByName(final String firstName, final String lastName) {
        for (final Member member : this.memberList) {
            if (member.getFirstName().equals(firstName) && member.getLastName().equals(lastName)) {
                return member;
            }
        }
        return null;
    }

    public final String[] getGroupListAsArray() {

        final String[] groupListArray = new String[this.groupList.size() + 1];
        groupListArray[0] = "";
        for (int i = 1; i < groupListArray.length; i++) {
            groupListArray[i] = this.groupList.get(i - 1).getName();
        }
        return groupListArray;
    }

    public final String getTranslation(final String string) {
        return this.languageBundle.getString(string);
    }

    public final void setLanguageBundle(final ResourceBundle languageBundle) {
        this.languageBundle = languageBundle;
    }

    public static Pojo getPojo() {
        return instance;
    }

    public final boolean hasError() {
        return this.error;
    }

    public final void setError(final boolean error) {
        this.error = error;
    }
}
