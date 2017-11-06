package ar.uba.fi.tdd.rulogic.model.Parser;

public class FactParserForRule extends FactParser {

    public FactParserForRule() {
        this.regex_parse = "([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\)";
        this.regex_valid = "^([a-z]+)\\(((?:[A-Z]+, )*[A-Z]+)\\)\\.$";
    }
}
