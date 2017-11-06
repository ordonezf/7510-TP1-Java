package ar.uba.fi.tdd.rulogic.model.Entities;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Question extends Fact{

    private String name;
    private List<String> args;

    public Question(String name, List<String> args) {
        super(name, args);
    }
}

