package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.model.Entities.DataBase;
import ar.uba.fi.tdd.rulogic.model.Entities.Question;
import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidDatabaseException;
import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidQuestionException;
import ar.uba.fi.tdd.rulogic.model.Parser.QuestionParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Interpreter {

    private DataBase db;
    private QuestionParser qp = new QuestionParser();

    public Interpreter(String path_to_db) throws InvalidDatabaseException, IOException {
        List<String> rawDB = new ArrayList<String>();
        Stream<String> stream = null;

        stream = Files.lines(Paths.get(path_to_db));
        rawDB = stream.collect(Collectors.toList());

        this.db = new DataBase(rawDB);
    }

    public String answer(String s) throws InvalidQuestionException {
        if (qp.isValid(s)) {
            return db.isTrue(qp.parse(s)) ? "Yes" : "No";
        } else {
            throw new InvalidQuestionException(s);
        }
    }
}
