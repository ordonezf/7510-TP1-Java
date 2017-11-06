package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Fact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactParserForRuleTest {

    private FactParserForRule fp;
    private String validSingleFact;
    private String validMultipleFact;
    private String invalidSingleFact;
    private String invalidMultipleFact;
    private String mayusFact;

    @Before
    public void setUp() throws Exception {
        this.fp = new FactParserForRule();
        this.validSingleFact = "varon(BRUCE).";
        this.validMultipleFact = "hijo(BRUCE, THOMAS).";
        this.invalidSingleFact = "varon(BRUCE";
        this.invalidMultipleFact = "hijo(BRUCE THOMAS).";
        this.mayusFact = "batman(BRUCe).";
    }

    @Test
    public void FactParserForRuleisValidWithSingleFactIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validSingleFact));
    }

    @Test
    public void FactParserForRuleisValidWithSingleFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidSingleFact));
    }

    @Test
    public void FactParserForRuleisValidWithMultipleFactIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validMultipleFact));
    }

    @Test
    public void FactParserForRuleisValidWithMultipleFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidMultipleFact));
    }

    @Test
    public void FactParserForRuleisValidWithMayusFactIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.mayusFact));
    }

    @Test
    public void FactParserForRuleparseReturnsFacttest() {
        Fact f = fp.parse(this.validSingleFact);
        Assert.assertTrue(f.getName().equals("varon") && f.getArgs().get(0).equals("BRUCE"));

    }
}