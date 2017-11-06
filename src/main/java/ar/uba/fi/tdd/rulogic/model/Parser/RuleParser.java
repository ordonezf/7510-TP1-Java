package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Fact;
import ar.uba.fi.tdd.rulogic.model.Entities.Rule;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mentaregex.Regex.match;

public class RuleParser {

    public boolean isValid(String s) {
        Pattern r = Pattern.compile("^([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\) :- (([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\)[, \\.]+)+$");
        Matcher m = r.matcher(s);
        return m.find();
    }
    public Rule parse(String s) {
        String fp = Arrays.asList(s.split(" :- ")).get(0);
        String sp = Arrays.asList(s.split(" :- ")).get(1);

        String regex_fp = "/^([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\)$/g";
        String[] matches = match(fp, regex_fp);
        String name = matches[0];
        List<String> args = Arrays.asList(matches[1].split(", "));

        Pattern pr = Pattern.compile("([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\)");
        Matcher m = pr.matcher(sp);
        FactParserForRule fpp = new FactParserForRule();
        List<Fact> conditions = new ArrayList<Fact>();
        while (m.find()) {
            conditions.add(fpp.parse(m.group(0)));
        }
        return new Rule(name, args, conditions);
    }
}
