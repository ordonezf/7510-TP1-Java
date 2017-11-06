package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Question {
    private String name;
    private List<String> args;

    public Question(Matcher parsedQuery) {
        this.name = parsedQuery.group(0);
        this.args = Arrays.asList(parsedQuery.group(1).split(", "));
    }

    public String getName() {
        return name;
    }

    public List<String> getArgs() {
        return args;
    }
}

