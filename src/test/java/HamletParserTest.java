import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        this.hamletParser.changeAllStringOccurrences("Hamlet", "Leon");
        this.hamletText = this.hamletParser.getHamletData();
        boolean actual = this.hamletText.toUpperCase().contains("LEON");
        Assert.assertTrue(actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        this.hamletParser.changeAllStringOccurrences("Horatio", "TARIQ");
        this.hamletText = this.hamletParser.getHamletData();
        boolean actual = this.hamletText.toUpperCase().contains("TARIQ");
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHoratio() {
        boolean actual = this.hamletText.toUpperCase().contains("HORATIO");
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        boolean actual = this.hamletText.toUpperCase().contains("HAMLET");
        Assert.assertTrue(actual);
    }
}