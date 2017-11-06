package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Question;
import ar.uba.fi.tdd.rulogic.model.Entities.Rule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleParserTest {
    private RuleParser fp;
    private String validSingleRule;
    private String validMultipleRule;
    private String invalidSingleRule;
    private String invalidMultipleRule;
    private String mayusRule;

    @Before
    public void setUp() throws Exception {
        this.fp = new RuleParser();
        this.validSingleRule = "varon(BRUCE) :- x(BRUCE).";
        this.validMultipleRule = "hijo(BRUCE, THOMAS) :- varon(BRUCE), padre(THOMAS, BRUCE).";
        this.invalidSingleRule = "varon(BRUCE :- x(BRUCE).";
        this.invalidMultipleRule = "hijo(BRUCE THOMAS) :- varon(BRUCE), padre(THOMAS, BRUCE).";
        this.mayusRule = "varon(BRUCe) :- x(BRUcE).";
    }

    @Test
    public void RuleParserisValidWithSingleRuleIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validSingleRule));
    }

    @Test
    public void RuleParserisValidWithSingleRuleIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidSingleRule));
    }

    @Test
    public void RuleParserisValidWithMultipleRuleIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validMultipleRule));
    }

    @Test
    public void RuleParserisValidWithMultipleRuleIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidMultipleRule));
    }

    @Test
    public void RuleParserisValidWithMayusRuleIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.mayusRule));
    }

    @Test
    public void RuleParserparseReturnsRuletest() {
        Rule f = fp.parse(this.validSingleRule);
        List<String> l = new ArrayList<String>(){{add("bruce");}};
        Question q = new Question("varon", l);
        Assert.assertTrue(f.isEqual(q));
    }
}