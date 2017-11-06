package ar.uba.fi.tdd.rulogic.model.Entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleTest {

    private String name;
    private String otherName;
    private List<String> args;
    private Fact f;
    private List<Fact> facts;

    @Before
    public void setUp() throws Exception {
        this.name = "method";
        this.otherName = "method2";
        this.args = new ArrayList<String>() {{
            add("arg1");
            add("arg2");
            add("arg3");
        }};

        f = new Fact(this.name, this.args);
        facts = new ArrayList<Fact>() {{add(f);}};
    }

    @Test
    public void RuleCreationNotNulltest() {
        Rule f = new Rule(this.name, this.args, this.facts);
        Assert.assertNotNull(f);
    }

    @Test
    public void RuleCreationInstanceOfRuletest() {
        Rule f = new Rule(this.name, this.args, this.facts);
        Assert.assertTrue(f instanceof Rule);
    }

    @Test
    public void RuleIsEqualReturnsTrueWhenEqualstest() {
        Rule f = new Rule(this.name, this.args, this.facts);
        Question q = new Question(this.name, this.args);
        Assert.assertTrue(f.isEqual(q));
    }

    @Test
    public void RuleIsEqualReturnsFalseWhenNotEqualstest() {
        Rule f = new Rule(this.name, this.args, this.facts);
        Question q = new Question(this.otherName, this.args);
        Assert.assertFalse(f.isEqual(q));
    }
}
