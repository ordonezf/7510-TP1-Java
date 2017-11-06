package ar.uba.fi.tdd.rulogic.model.Entities;

import ar.uba.fi.tdd.rulogic.model.Entities.Fact;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Rule {

    private String name;
    private List<String> args;
    private List<Fact> conditions;

    public Rule(String name, List<String> args, List<Fact> conditions) {
        this.name = name;
        this.args = args;
        this.conditions = conditions;

    }

    public boolean isEqual(Question q) {
        return this.name.equals(q.getName()) && this.args.size() == q.getArgs().size();
    }
}
