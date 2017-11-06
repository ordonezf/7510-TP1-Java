package ar.uba.fi.tdd.rulogic.model.Entities;

import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidDatabaseException;
import ar.uba.fi.tdd.rulogic.model.Parser.QuestionParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataBaseTest {

    private List<String> rawDB;
    @Before
    public void setUp() throws Exception {
        this.rawDB = new ArrayList<String>() {{
            add("varon(juan).");
            add("padre(pepe, juan).");
            add("hijo(X, Y) :- varon(X), padre(Y, X).");
        }};
    }

    @Test
    public void createValidDataBasetest() throws InvalidDatabaseException {
        DataBase db = new DataBase(this.rawDB);
        Assert.assertNotNull(db);
    }

    @Test
    public void DataBaseQuestionisTruetest() throws InvalidDatabaseException {
        DataBase db = new DataBase(this.rawDB);
        Question q = new QuestionParser().parse("varon(juan)");
        Assert.assertTrue(db.isTrue(q));
    }

    @Test
    public void DataBaseQuestionisFalsetest() throws InvalidDatabaseException {
        DataBase db = new DataBase(this.rawDB);
        Question q = new QuestionParser().parse("varon(pedro)");
        Assert.assertFalse(db.isTrue(q));
    }

    @Test
    public void DataBaseQuestionRuleisTruetest() throws InvalidDatabaseException {
        DataBase db = new DataBase(this.rawDB);
        Question q = new QuestionParser().parse("hijo(juan, pepe)");
        Assert.assertTrue(db.isTrue(q));
    }

    @Test
    public void DataBaseQuestionRuleisFalsetest() throws InvalidDatabaseException {
        DataBase db = new DataBase(this.rawDB);
        Question q = new QuestionParser().parse("hijo(juan, carlos)");
        Assert.assertFalse(db.isTrue(q));
    }
}
