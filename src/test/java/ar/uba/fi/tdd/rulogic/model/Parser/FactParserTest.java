package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Fact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactParserTest {

    private FactParser fp;
    private String validSingleFact;
    private String validMultipleFact;
    private String invalidSingleFact;
    private String invalidMultipleFact;
    private String mayusFact;

    @Before
    public void setUp() throws Exception {
        this.fp = new FactParser();
        this.validSingleFact = "varon(bruce).";
        this.validMultipleFact = "hijo(bruce, thomas).";
        this.invalidSingleFact = "varon(bruce";
        this.invalidMultipleFact = "hijo(bruce thomas).";
        this.mayusFact = "batman(Bruce).";
    }

    @Test
    public void FactParserisValidWithSingleFactIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validSingleFact));
    }

    @Test
    public void FactParserisValidWithSingleFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidSingleFact));
    }

    @Test
    public void FactParserisValidWithMultipleFactIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validMultipleFact));
    }

    @Test
    public void FactParserisValidWithMultipleFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidMultipleFact));
    }

    @Test
    public void FactParserisValidWithMayusFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.mayusFact));
    }

    @Test
    public void FactParserparseReturnsFacttest() {
        Fact f = fp.parse(this.validSingleFact);
        Assert.assertTrue(f.getName().equals("varon") && f.getArgs().get(0).equals("bruce"));

    }
}
