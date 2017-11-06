package ar.uba.fi.tdd.rulogic.model.Entities;

import ar.uba.fi.tdd.rulogic.model.Exceptions.InvalidDatabaseException;
import ar.uba.fi.tdd.rulogic.model.Parser.FactParser;
import ar.uba.fi.tdd.rulogic.model.Parser.RuleParser;

import java.util.*;

public class DataBase {

    private List<Fact> facts = new ArrayList<Fact>();
    private List<Rule> rules = new ArrayList<Rule>();
    private FactParser fp = new FactParser();
    private RuleParser rp = new RuleParser();

    public DataBase(List<String> db) throws InvalidDatabaseException {
        for (String row : db) {
            if (this.fp.isValid(row)) {
                this.facts.add(this.fp.parse(row));
            } else if (this.rp.isValid(row)) {
                this.rules.add(this.rp.parse(row));
            } else {
                throw new InvalidDatabaseException("Error in:" + row);
            }
        }
    }

    public boolean isTrue(Question q) {
        return this.checkForFacts(q) || this.checkForRules(q);
    }

    private boolean checkForFacts(Fact q) {
        for (Fact fact : this.facts) {
            if (fact.isEqual(q)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForRules(Question q) {
        for (Rule rule : this.rules) {
            if (rule.isEqual(q)) {
                Map<String, String> merge = this.mergeArgs(rule, q);
                List<Fact> ruleFacts = rule.transformFacts(merge);
                if (ruleFacts.stream().allMatch(this::checkForFacts)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<String, String> mergeArgs(Rule rule, Question q) {
        Map<String, String> merge = new HashMap<String, String>();
        List<String> ra = rule.getArgs();
        List<String> qa = q.getArgs();
        for (int i = 0; i < qa.size(); i++) {
            merge.put(ra.get(i), qa.get(i));
        }
        return merge;
        }
}
