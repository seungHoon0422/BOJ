import java.util.*;

/**
 * PCCP 3. 수식 복원하기
 *
 * 수식의 형태는 2가지로 픽스
 * a + b = c
 * a - b = c
 *
 * " "를 기준으로 split해서 a,b,c 와 +, - 값을 얻는다.
 */
class Solution {

    List<Expression> expressionList = new ArrayList<>();

    public String[] solution(String[] expressions) {

        for (String expression : expressions) {
            expressionList.add(new Expression(expression));
        }

        List<Integer> possibleNumber = new ArrayList<>();

        for(int i=2; i<=9; i++) {
            if(isRightExpression(expressionList, i)) {
                possibleNumber.add(i);
            }
        }
        System.out.println("possibleNumber = " + Arrays.toString(possibleNumber.toArray()));
        return calculateAnswer(possibleNumber, expressionList);
    }

    private boolean isRightExpression(List<Expression> expressionList, int number) {

        for (Expression expression : expressionList) {

            int convertA = convertByNumber(expression.a, number);
            int convertB = convertByNumber(expression.b, number);
            int convertC = expression.containX ? -2 : convertByNumber(expression.c, number);

            // X가 포함되어있는 경우
            if(convertA == -1 || convertB == -1)  return false;
            if(convertC == -2) continue;
            if(convertC == -1) return false;

            if("+".equals(expression.op)) {
                if(convertA + convertB != convertC) return false;
            } else if("-".equals(expression.op)) {
                if(convertA - convertB != convertC) return false;
            }
        }

        return true;
    }

    private int convertByNumber(String target, int number) {

        target = new StringBuilder(target).reverse().toString();
        String[] split = target.split("");

        int returnValue = 0;
        for(int i=0; i<split.length; i++) {
            int targetNumber = Integer.parseInt(split[i]);
            if(targetNumber >= number) return -1;
            if(i == 0) returnValue = targetNumber;
            else {
                returnValue += targetNumber * (int) Math.pow(number, i);
            }
        }

        return returnValue;
    }

    private String[] calculateAnswer(List<Integer> possibleNumber, List<Expression> expressionList) {

        List<String> answerList = new ArrayList<>();
        String convertX;
        for (Expression expression : expressionList) {
            if(!expression.containX) continue;

            convertX = "?";

            boolean notOne = false;
            for (Integer number : possibleNumber) {
                String convertXByNumber = findXByNumber(expression, number);
                if("?".equals(convertX)) convertX = convertXByNumber;
                else if(!convertX.equals(convertXByNumber)) {
                        notOne = true;
                        break;
                }
            }
            if(notOne) convertX = "?";
            answerList.add(expression.completeAnswer(convertX));
        }
        String[] answer = new String[answerList.size()];
        answer = answerList.toArray(answer);

        return answer;
    }

    private String findXByNumber(Expression expression, Integer number) {
//            System.out.println("expression.toString() = " + expression.toString());

        int convertA = convertByNumber(expression.a, number);
        int convertB = convertByNumber(expression.b, number);
        int x = "+".equals(expression.op) ? convertA + convertB : convertA - convertB;
        if(x == 0) return "0";
        String returnvalue = "";
        while(x > 0) {
            returnvalue = x%number + returnvalue;
            x /= number;
        }
        return returnvalue;
    }

    public static class Expression {
        String expression;
        String a,b,c;
        String op;
        boolean containX;

        public Expression(String expression) {
            this.expression = expression;
            String[] splitExpression = expression.split(" ");
            this.a = splitExpression[0];
            this.b = splitExpression[2];
            this.c = splitExpression[4];
            this.op = splitExpression[1];
            if("X".equals(this.c)) this.containX = true;
        }

        @Override
        public String toString() {
            return "Expression{" +
                    "expression='" + expression + '\'' +
                    ", a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    ", c='" + c + '\'' +
                    ", op='" + op + '\'' +
                    ", containX=" + containX +
                    '}';
        }

        public String completeAnswer(String convertX) {
            return a + " " + op + " " + b +  " = " + convertX;
        }
    }


}