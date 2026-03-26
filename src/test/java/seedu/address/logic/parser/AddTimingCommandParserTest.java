package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

public class AddTimingCommandParserTest {

    private AddTimingCommandParser parser = new AddTimingCommandParser();

    @Test
    public void parse_missingFields_failure() {
        // missing both min/ and sec/
        assertParseFailure(parser, "1", "Missing required fields: min/ sec/");

        // missing sec/
        assertParseFailure(parser, "1 min/10", "Missing required fields: min/ sec/");
    }

    @Test
    public void parse_invalidValues_failure() {
        // negative minutes
        assertParseFailure(parser, "1 min/-1 sec/30", "Invalid minutes: must be a non-negative integer");

        // seconds out of range
        assertParseFailure(parser, "1 min/10 sec/60", "Invalid seconds: must be between 0 and 59.99");

        // zero total time
        assertParseFailure(parser, "1 min/0 sec/0", "Invalid timing: total time must be greater than 0");
    }
}
