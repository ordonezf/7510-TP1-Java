package ar.uba.fi.tdd.rulogic.model.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rule {

    private String name;
    private List<String> args;
    private List<Fact> facts;

    public Rule(String name, List<String> args, List<Fact> conditions) {
        this.name = name;
        this.args = args;
        this.facts = conditions;

    }

    public boolean isEqual(Question q) {
        return this.name.equals(q.getName()) && this.args.size() == q.getArgs().size();
    }

    public List<String> getArgs() {
        return args;
    }

    public List<Fact> transformFacts(Map<String, String> merge) {
        List<Fact> f = new ArrayList<Fact>();
        for (Fact fact : this.facts) {
            List<String> l = new ArrayList<String>();
            for (String s : fact.getArgs()) {
                l.add(merge.get(s));
            }
            f.add(new Fact(fact.getName(), l));
        }
        return f;
    }
}
