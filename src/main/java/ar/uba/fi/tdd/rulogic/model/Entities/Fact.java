package ar.uba.fi.tdd.rulogic.model.Entities;

import java.util.List;

public class Fact {

    private String name;
    private List<String> args;

    public Fact(String name, List<String> args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public List<String> getArgs() {
        return args;
    }

    public boolean isEqual(Fact q) {
        return (this.name.equals(q.getName()) && this.args.equals(q.getArgs()));
    }
}
