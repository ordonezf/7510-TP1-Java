package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Fact {

    private String name;
    private List<String> args;

    public Fact(Matcher parsedFact) {
        this.name = parsedFact.group(0);
        this.args = Arrays.asList(parsedFact.group(1).split(", "));
    }

    public boolean isEqual(Question q) {
        return (this.name.equals(q.getName()) && this.args.containsAll(q.getArgs())
                && q.getArgs().containsAll(this.args));
    }
}
