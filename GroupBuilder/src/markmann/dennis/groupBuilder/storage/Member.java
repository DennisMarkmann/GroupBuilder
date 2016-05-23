package markmann.dennis.groupBuilder.storage;

/**
 * Member object. Contains various elements and is able to get assigned to groups.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class Member implements Comparable<Member> {

    private String firstName;
    private String lastName;
    private Group group;
    private String eMailAdress;

    public Member(final String firstName, final String lastName) {
        this(firstName, lastName, null);
    }

    public Member(final String firstName, final String lastName, final String eMailAdress) {
        this(firstName, lastName, eMailAdress, null);
    }

    public Member(final String firstName, final String lastName, final String eMailAdress, final Group group) {

        if (firstName == null) {
            // TODO throw exception
        }
        if (lastName == null) {
            // TODO throw exception
        }
        this.firstName = firstName;
        this.lastName = lastName;

        if (eMailAdress != null) {
            this.eMailAdress = eMailAdress;
        }
        if (group != null) {
            this.group = group;
        }

    }

    private String addSpace() {
        return " ";
    }

    @Override
    public final int compareTo(final Member member) {

        int result = this.getFirstName().compareTo(member.getFirstName());
        if (result == 0) {
            result = this.getLastName().compareTo(member.getLastName());
        }
        return result;
    }

    public final String getEMailAdress() {
        return this.eMailAdress;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public final Group getGroup() {
        return this.group;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setEMailAdress(final String eMailAdress) {
        this.eMailAdress = eMailAdress;
    }

    public final void setFirstName(final String name) {
        this.firstName = name;
    }

    public final void setGroup(final Group group) {
        this.group = group;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(firstName);
        sb.append(this.addSpace());
        sb.append(lastName);
        if (eMailAdress != null) {
            sb.append(this.addSpace());
            sb.append(eMailAdress);
        }
        if (group != null) {
            sb.append(this.addSpace());
            sb.append(group);
        }
        return sb.toString();
    }

}
