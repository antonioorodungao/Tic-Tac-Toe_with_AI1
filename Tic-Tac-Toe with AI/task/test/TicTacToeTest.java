import org.hyperskill.hstest.v3.stage.MainMethodTest;
import org.hyperskill.hstest.v3.testcase.CheckResult;
import org.hyperskill.hstest.v3.testcase.TestCase;
import tictactoe.Main;

import java.util.List;
import java.util.stream.Collectors;

public class TicTacToeTest extends MainMethodTest {
    public TicTacToeTest() throws Exception {
        super(Main.class);
    }


    @Override
    public List<TestCase> generateTestCases() {
        return List.of(
            new TestCase()
                .setInput("")
        );
    }

    @Override
    public CheckResult check(String reply, Object clue) {

        List<String> lines = reply
            .lines()
            .map(String::strip)
            .filter(e -> e.length() > 0)
            .collect(Collectors.toList());

        if (lines.size() != 4) {
            return new CheckResult(false,
                "Output should contain exactly 4 lines");
        }

        String grid = lines.get(0) + lines.get(1) + lines.get(2);

        grid = grid.replaceAll("\\s+", "");

        if (grid.length() > 9) {
            return new CheckResult(false,
                "You need to output no more than 9 symbols");
        }

        if (grid.length() == 9) {
            return new CheckResult(false,
                "You should output a state that is not finished");
        }

        for (char c : grid.toCharArray()) {
            if (c != 'X' && c != 'O') {
                return new CheckResult(false,
                    "You need to output X and O symbols only not counting spaces");
            }
        }

        String lastLine = lines.get(3);

        if (! (lastLine.equals("X wins")
                || lastLine.equals("O wins")
                || lastLine.equals("Draw"))) {
            return new CheckResult(false,
                "The last line is incorrect");
        }

        return CheckResult.TRUE;
    }
}
