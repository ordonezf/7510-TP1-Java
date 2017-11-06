package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Entities.DataBase;
import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidDatabaseException;
import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidQuestionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterpreterTest {

    private String path;
    @Before
    public void setUp() throws Exception {
        path = "src/main/resources/family.db";
    }

    @Test
    public void InterpreterAnswerIsYesWhenQuestionIsInDbtest() throws InvalidQuestionException, IOException, InvalidDatabaseException {
        Interpreter i = new Interpreter(this.path);
        Assert.assertTrue(i.answer("varon(juan)").equals("Yes"));
    }

    @Test
    public void InterpreterAnswerIsNoWhenQuestionIsInDbtest() throws InvalidQuestionException, IOException, InvalidDatabaseException {
        Interpreter i = new Interpreter(this.path);
        Assert.assertTrue(i.answer("varon(bruno)").equals("No"));
    }

    @Test(expected = InvalidQuestionException.class)
    public void InterpreterThrowsExceptionWhenQuestionIsInvalidtest() throws InvalidQuestionException, IOException, InvalidDatabaseException {
        Interpreter i = new Interpreter(this.path);
        i.answer("varon(Bruno)");
    }
}
