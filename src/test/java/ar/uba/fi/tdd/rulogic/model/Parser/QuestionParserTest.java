package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuestionParserTest {
    private QuestionParser fp;
    private String validSingleQuestion;
    private String validMultipleQuestion;
    private String invalidSingleQuestion;
    private String invalidMultipleQuestion;
    private String mayusQuestion;

    @Before
    public void setUp() throws Exception {
        this.fp = new QuestionParser();
        this.validSingleQuestion = "varon(bruce)";
        this.validMultipleQuestion = "hijo(bruce, thomas)";
        this.invalidSingleQuestion = "varon(bruce).";
        this.invalidMultipleQuestion = "hijo(bruce thomas).";
        this.mayusQuestion = "batman(Bruce)";
    }

    @Test
    public void QuestionParserisValidWithSingleQuestionIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validSingleQuestion));
    }

    @Test
    public void QuestionParserisValidWithSingleQuestionIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidSingleQuestion));
    }

    @Test
    public void QuestionParserisValidWithMultipleQuestionIsTruetest() {
        Assert.assertTrue(this.fp.isValid(this.validMultipleQuestion));
    }

    @Test
    public void QuestionParserisValidWithMultipleQuestionIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.invalidMultipleQuestion));
    }

    @Test
    public void QuestionParserisValidWithMayusQuestionIsFalsetest() {
        Assert.assertFalse(this.fp.isValid(this.mayusQuestion));
    }

    @Test
    public void QuestionParserparseReturnsQuestiontest() {
        Question f = fp.parse(this.validSingleQuestion);
        Assert.assertTrue(f.getName().equals("varon") && f.getArgs().get(0).equals("bruce"));

    }
}
