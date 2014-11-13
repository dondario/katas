package calculator;

public class Calculator {
    public Integer add(String addString) {
        int total = 0;

        if (!addString.isEmpty()) {

            String delimiter = ",|\n";

            if (delimiterExistsIn(addString)) {
                delimiter = String.valueOf(addString.charAt(0));
                addString = addString.substring(2);
            }

            final String[] items = addString.split(delimiter);

            for (String item : items) {
                total = addValue(total, item);
            }

        }

        return total;
    }

    private boolean delimiterExistsIn(final String addString) {
        return !Character.isDigit(addString.charAt(0));
    }

    private int addValue(int total, final String item) {
        if (item.isEmpty()) {
            return 0;
        }

        return total + Integer.parseInt(item);
    }
}
