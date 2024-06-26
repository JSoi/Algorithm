package tool;

public class Assertions {
    public static void check(Object result, Object expected) throws Exception {
        boolean classEquals = result.getClass().equals(expected.getClass());
        if (!classEquals) {
            notEquals(result, expected);
            return;
        }
        if (!result.equals(expected)) {
            notEquals(result, expected);
        } else {
            passed(result);
        }
    }

    public static void notEquals(Object result, Object expected) {
        System.out.printf("\uD83D\uDD34 RESULT - [%s] EXPECTED - [%s]%n", result, expected);
    }

    public static void passed(Object result) {
        System.out.printf("\uD83D\uDFE2 RESULT - [%s] PASSED%n", result);
    }
}
