package ar.uba.fi.tdd.rulogic.model.Entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FactTest {

    private String name;
    private String otherName;
    private List<String> args;
    @Before
    public void setUp() throws Exception {
        this.name = "method";
        this.otherName = "method2";
        this.args = new ArrayList<String>() {{
            add("arg1");
            add("arg2");
            add("arg3");
        }};
    }

    @Test
    public void FactCreationNotNulltest() {
        Fact f = new Fact(this.name, this.args);
        Assert.assertNotNull(f);
    }

    @Test
    public void FactCreationInstanceOfFacttest() {
        Fact f = new Fact(this.name, this.args);
        Assert.assertTrue(f instanceof Fact);
    }

    @Test
    public void FactGettersTest() {
        Fact f = new Fact(this.name, this.args);
        Assert.assertTrue(f.getName().equals(this.name));
        Assert.assertTrue(f.getArgs().equals(this.args));
    }

    @Test
    public void FactIsEqualReturnsTrueWhenEqualstest() {
        Fact f = new Fact(this.name, this.args);
        Fact q = new Fact(this.name, this.args);
        Assert.assertTrue(f.isEqual(q));
    }

    @Test
    public void FactIsEqualReturnsFalseWhenNotEqualstest() {
        Fact f = new Fact(this.name, this.args);
        Fact q = new Fact(this.otherName, this.args);
        Assert.assertFalse(f.isEqual(q));
    }
}
