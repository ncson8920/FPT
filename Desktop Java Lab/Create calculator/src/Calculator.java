
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Calculator {

    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private final JTextField text;
    private int operator;
    private BigDecimal memory = new BigDecimal("0");
    ;
    private boolean reset;
    private boolean backSpace;

    public Calculator(JTextField text) {
        this.text = text;
        operator = -1;
        memory = new BigDecimal("0");
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void pressNumber(JButton btn) {
        BigDecimal temp = new BigDecimal("0");
        String value = btn.getText();
        if (reset) {
            text.setText("0");
            reset = false;
        }
        if (text.getText().length() < 20) {
            temp = new BigDecimal(text.getText() + value);
            if (text.getText().startsWith("-")&& temp.doubleValue()==0) {
                text.setText("-" + temp.toPlainString());
            } else {
                text.setText(temp.toPlainString());
            }
        }
        backSpace = true;
    }

    public void pressDot() {
        if (reset) {
            text.setText("0");
            reset = false;
        }
        if (!text.getText().contains(".")) {
            text.setText(text.getText() + ".");
        }
        backSpace = true;
    }

    public BigDecimal getValue() {
        String value = text.getText();
        BigDecimal temp = new BigDecimal(value);
        return temp;
    }

    public void pressClear() {
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");
        operator = -1;
        backSpace = false;
        text.setText("0");
    }

    public void calculate() {
        try {
            if (!reset) {
                if (operator == -1) {
                    firstNum = getValue();
                } else {
                    secondNum = getValue();
                    switch (operator) {
                        case 1:
                            firstNum = firstNum.add(secondNum);
                            break;
                        case 2:
                            firstNum = firstNum.subtract(secondNum);
                            break;
                        case 3:
                            firstNum = firstNum.multiply(secondNum);
                            break;
                        case 4:
                            double result = firstNum.doubleValue() / secondNum.doubleValue();
                            firstNum = new BigDecimal(result + "");
                            break;
                    }
                }
                text.setText(firstNum.stripTrailingZeros().toPlainString());
                reset = true;
                backSpace = false;
            }
        } catch (Exception e) {
            reset = true;
            text.setText("ERROR");
        }

    }

    public void pressResult() {
        if (!text.getText().equals("ERROR")) {
            calculate();
            backSpace = false;
            operator = -1;
        } else {
            text.setText(firstNum + "");
        }

    }

    public void pressNegate() {
        try {
            if (text.getText().startsWith("-")) {
                text.setText(text.getText().replace("-", ""));
            } else {
                text.setText("-" + text.getText());
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        backSpace=true;
    }

    public void pressSqrt() {
        try {
            pressResult();
            BigDecimal result = getValue();
            if (result.doubleValue() >= 0) {
                double a = Math.sqrt(result.doubleValue());
                BigDecimal rs = new BigDecimal(a + "");
                text.setText(rs.stripTrailingZeros().toPlainString());
            } else {
                text.setText("ERROR");
            }
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressPercent() {
        try {
            pressResult();
            BigDecimal result = new BigDecimal((getValue().doubleValue() / 100) + "");
            text.setText(result.stripTrailingZeros().toPlainString());
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressInvert() {
        if (!text.getText().equals("ERROR")) {
            pressResult();
            double result = getValue().doubleValue();
            if (result != 0) {
                BigDecimal value = new BigDecimal((1 / result) + "");
                text.setText(value.stripTrailingZeros().toPlainString());
            } else {
                text.setText("ERROR");
            }
        } else {
            text.setText("ERROR");
            reset = true;
        }
    }

    public void pressMC() {
        memory = new BigDecimal("0");
    }

    public void pressMR() {
        text.setText(memory + "");
        reset = true;
        backSpace = false;
    }

    public void pressMAdd() {
        try {
            memory = memory.add(getValue());
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void pressMSub() {
        try {
            memory = memory.add(getValue().negate());
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    public void backSpace() {
        
            String txt = text.getText();
            if (txt.equalsIgnoreCase("ERROR")) {
                backSpace = false;
            }
            if (backSpace) {
                txt = txt.substring(0, txt.length() - 1);
                if (txt.equalsIgnoreCase("-") || txt.length() == 0) {
                    txt = "0";
                }else{
                    BigDecimal temp = new BigDecimal(txt);
                    if(temp.doubleValue()==0){
                        txt = "0";
                    }
                }
                text.setText(txt);
            }
            if (txt.equals("0")) {
                backSpace = false;
            }
        
    }
}
