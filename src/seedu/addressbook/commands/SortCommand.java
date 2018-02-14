package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers sorted alphabetically by name.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().mutableListView();
        allPersons.sort(Comparator.comparing(c -> c.getName().toString()));
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
