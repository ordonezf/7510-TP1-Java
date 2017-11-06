package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Rule {

    private String name;
    private List<String> args;
    private List<Fact> conditions;

    public Rule(Matcher parsedRule) {
        this.name = parsedRule.group(0);
        this.args = Arrays.asList(parsedRule.group(1).split(", "));
        //parsedRule.forEach( (cond) -> this.conditions.add(new Fact(cond)));

    }
}


/*
var Rule = function (parsedRule) {

    this.name = parsedRule[0][1];
    this.args = parsedRule[0][2].split(', ');
    this.conditions = parsedRule.slice(1).map(fact => new Fact(fact));

    this.isEqual = function(query) {
        return (this.name === query.getName() && this.args.lenght === query.getArgs().lenght)
    }
}
 */