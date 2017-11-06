package ar.uba.fi.tdd.rulogic.model.Parser;

import ar.uba.fi.tdd.rulogic.model.Entities.Question;

import java.util.Arrays;
import java.util.List;

import static org.mentaregex.Regex.match;

public class QuestionParser extends FactParser {

    public QuestionParser(){
        this.regex_valid = "^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)$";
        this.regex_parse = "/^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)$/g";
    }

    public Question parse(String s) {
        String[] matches = match(s, this.regex_parse);
        List<String> args = Arrays.asList(matches[1].split(", "));
        return new Question(matches[0], args);
    }
}
