package ar.uba.fi.tdd.rulogic.model.Parser;

public class QuestionParser extends FactParser {

    public QuestionParser(){
        this.regex_valid = "^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)$";
        this.regex_parse = "/^([a-z]+)\\(((?:[a-z]+, )*[a-z]+)\\)$/g";
    }
}
