package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteTimingCommand;

public class DeleteTimingCommandParserTest {

    private DeleteTimingCommandParser parser = new DeleteTimingCommandParser();

    @Test
    public void parse_missingArguments_failure() {
        // only one argument
        assertParseFailure(parser, "1",
                String.format("Invalid command format: %s", DeleteTimingCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArguments_failure() {
        // non-numeric arguments
        assertParseFailure(parser, "a b",
                String.format("Invalid command format: %s", DeleteTimingCommand.MESSAGE_USAGE));

        // too many arguments
        assertParseFailure(parser, "1 2 3",
                String.format("Invalid command format: %s", DeleteTimingCommand.MESSAGE_USAGE));
    }
}
