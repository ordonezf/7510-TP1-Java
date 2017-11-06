package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Fact;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mentaregex.Regex.match;

public class FactParser {
    String regex_valid = "^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)\\.$";
    String regex_parse = "/^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)\\.$/g";

    public boolean isValid(String s) {
        Pattern r = Pattern.compile(this.regex_valid);
        Matcher m = r.matcher(s);
        return m.find();
    }
    public Fact parse(String s) {
        String[] matches = match(s, this.regex_parse);
        List<String> args = Arrays.asList(matches[1].split(", "));
        return new Fact(matches[0], args);
    }
}
