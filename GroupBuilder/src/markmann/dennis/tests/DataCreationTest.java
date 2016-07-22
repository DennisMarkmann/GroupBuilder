package markmann.dennis.tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import markmann.dennis.groupBuilder.jobs.GroupCreator;
import markmann.dennis.groupBuilder.jobs.MemberCreator;
import markmann.dennis.groupBuilder.main.PropertyHandler;
import markmann.dennis.groupBuilder.storage.Pojo;

public class DataCreationTest extends TestCase {

    private MemberCreator creator;
    GroupCreator groupCreator;

    @Override
    @Before
    public void setUp() {
        final Pojo pojo = new Pojo();
        new PropertyHandler().getProperties(pojo);
        this.creator = new MemberCreator(pojo);
        this.groupCreator = new GroupCreator(pojo);
    }

    @Test
    public void testGroupCreation() {

        this.groupCreator.createGroup("Group1", "");
        this.groupCreator.createGroup("Group2", "");
        this.groupCreator.createGroup("Group3", "");
        this.groupCreator.createGroup("Group4", "");
        this.groupCreator.createGroup("Group5", "");
    }

    @Test
    public void testMemberCreation() {

        this.creator.createMember("Alissa", "Rauhe");
        this.creator.createMember("Björn", "Korella");
        this.creator.createMember("Christian", "Dose");
        this.creator.createMember("Christoph", "Bähr");
        this.creator.createMember("Christopher", "Ponitz");
        this.creator.createMember("Dennis", "Markmann");
        this.creator.createMember("Dennis", "Watzek");
        this.creator.createMember("Dimitri", "Majle");
        this.creator.createMember("Jendrik", "Witt");
        this.creator.createMember("Jochen", "Erchen");
        this.creator.createMember("Kai-Oliver", "Nießen");
        this.creator.createMember("Leonard", "Thoma");
        this.creator.createMember("Lisa", "Horwege");
        this.creator.createMember("Michelle", "Reichardt");
        this.creator.createMember("Mike", "Kudla");
        this.creator.createMember("Nico", "Stuzmann");
        this.creator.createMember("Oleg", "Scheltow");
        this.creator.createMember("Sebastian", "Wäbs");
        this.creator.createMember("Stefan", "Reismann");
        this.creator.createMember("Sven", "Tatter");
        this.creator.createMember("Thorben", "Nehls");
        this.creator.createMember("Timo", "Litzbarski");
        this.creator.createMember("Yasin", "Avcioglu");
    }

}
