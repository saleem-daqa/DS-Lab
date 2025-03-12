import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class Lab0 extends GridPane {
    static int[] count;

    public Lab0() {
        Label lb = new Label("Enter number to print from 1 --> n:");
        TextField tf = new TextField();
        Button printButton = new Button("Print");
        Label resultLabel = new Label();

        HBox hb = new HBox(10);
        hb.getChildren().addAll(lb, tf, printButton);
        hb.setAlignment(Pos.CENTER_LEFT);

        this.add(hb, 0, 0);
        this.add(resultLabel, 1, 0);

        printButton.setOnAction(e -> {
            try {
                int num = Integer.parseInt(tf.getText());
                String result = printNums(num);
                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("You should only enter numbers.");
            }
        });

        Label fibLb = new Label("Count Fibonacci numbers:");
        TextField fibTf = new TextField();
        Button fibBtn = new Button("Calculate Fibonacci");
        Label fibResultLabel = new Label();

        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(fibLb, fibTf, fibBtn, fibResultLabel);
        hb1.setAlignment(Pos.CENTER_LEFT);
        this.add(hb1, 0, 1);

        fibBtn.setOnAction(e -> {
            try {
                int fibNum = Integer.parseInt(fibTf.getText());
                count = new int[fibNum + 1];
                int fibResult = fib(fibNum);

                StringBuilder countResult = new StringBuilder();
                for (int i = 0; i <= fibNum; i++) {
                    countResult.append("fib(").append(i).append(") called ").append(count[i]).append(" times\n");
                }
                fibResultLabel.setText(countResult.toString());

            } catch (NumberFormatException ex) {
                fibResultLabel.setText("You should only enter numbers.");
            }
        });

        Label reverseLb = new Label("Enter string to reverse:");
        TextField reverseTf = new TextField();
        Button reverseBtn = new Button("Reverse String");
        Label reverseResultLabel = new Label();

        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(reverseLb, reverseTf, reverseBtn, reverseResultLabel);
        hb2.setAlignment(Pos.CENTER_LEFT);
        this.add(hb2, 0, 2);

        reverseBtn.setOnAction(e -> {
            try {
                String inputString = reverseTf.getText();
                String reversedString = reverse(inputString);
                reverseResultLabel.setText("Reversed String: " + reversedString);
            } catch (Exception ex) {
                reverseResultLabel.setText(ex.getMessage());
            }
        });

       
        Label digitLb = new Label("Return sum of digits:");
        TextField digitTf = new TextField();
        Button digitBtn = new Button("Calculate Digits");
        Label digitSumLb = new Label();

        HBox hb3 = new HBox(10);
        hb3.getChildren().addAll(digitLb, digitTf, digitBtn, digitSumLb);
        hb3.setAlignment(Pos.CENTER_LEFT);
        this.add(hb3, 0, 3);

        digitBtn.setOnAction(e -> {
            try {
                int num = Integer.parseInt(digitTf.getText());
                int result = sumToOneDigit(num);
                digitSumLb.setText("Single Digit Sum: " + result);
            } catch (NumberFormatException ex) {
                digitSumLb.setText("You should only enter numbers.");
            }
        });
    }

    private static String printNums(int n) {
        if (n == 1) {
            return "1";
        }
        return printNums(n - 1) + " " + n;
    }

    private static int fib(int n) {
        if (n == 0) {
            count[0]++;
            return 0;
        }
        if (n == 1) {
            count[1]++;
            return 1;
        }
        count[n]++;
        return fib(n - 1) + fib(n - 2);
    }

    public static String reverse(String s) {
        if (s == null)
            return "";
        return reverse(s, s.length() - 1);
    }

    private static String reverse(String s, int index) {
        if (index == -1)
            return "";
        return s.charAt(index) + reverse(s, index - 1);
    }

    private static int sumToOneDigit(int num) {
        if (num < 10) {
            return num;
        }
        return sumToOneDigit(sumDigits(num));
    }

    private static int sumDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10) + sumDigits(num / 10);
    }
}