package ar.uba.fi.tdd.rulogic.model.Entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionTest {

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
    public void QuestionCreationNotNulltest() {
        Question f = new Question(this.name, this.args);
        Assert.assertNotNull(f);
    }

    @Test
    public void QuestionCreationInstanceOfQuestiontest() {
        Question f = new Question(this.name, this.args);
        Assert.assertTrue(f instanceof Question);
    }

    @Test
    public void QuestionGettersTest() {
        Question f = new Question(this.name, this.args);
        Assert.assertTrue(f.getName().equals(this.name));
        Assert.assertTrue(f.getArgs().equals(this.args));
    }

    @Test
    public void QuestionIsEqualReturnsTrueWhenEqualstest() {
        Question f = new Question(this.name, this.args);
        Question q = new Question(this.name, this.args);
        Assert.assertTrue(f.isEqual(q));
    }

    @Test
    public void QuestionIsEqualReturnsFalseWhenNotEqualstest() {
        Question f = new Question(this.name, this.args);
        Question q = new Question(this.otherName, this.args);
        Assert.assertFalse(f.isEqual(q));
    }
}
