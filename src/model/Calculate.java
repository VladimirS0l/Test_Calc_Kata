package model;

public class Calculate {

    public void calculate(String expression){

        try{
            RomanConvert rc = new RomanConvert();

            String[] exprAction = {"+", "-", "/", "*"};
            String[] regexAction = {"\\+", "-", "/", "\\*"};
            int indexAction = -1;
            for (int i = 0; i < exprAction.length; i++) {
                if (expression.contains(exprAction[i])) {
                    indexAction = i;
                    break;
                }
            }
            if (indexAction == -1) {
                System.out.println("Строка не является математической операцией");
                return;
            } else if(expression.length() > 3){
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и\n" +
                        "один оператор (+, -, /, *)");
                return;
            }

            String[] data = expression.split(regexAction[indexAction]);
            if (rc.checkRomanNumber(data[0]) == rc.checkRomanNumber(data[1])) {
                int a, b;
                boolean checkRoman = rc.checkRomanNumber(data[0]);
                if (checkRoman) {
                    a = rc.romanToInt(data[0]);
                    b = rc.romanToInt(data[1]);
                    if (a < b){
                        System.out.println("В римской системе нет отрицательных чисел");
                        return;
                    }
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }

                int exprResult = 0;
                switch (exprAction[indexAction]) {
                    case "+":
                        exprResult = a + b;
                        break;
                    case "-":
                        exprResult = a - b;
                        break;
                    case "/":
                        if(b == 0){
                            System.out.println("Делить на ноль нельзя");
                            return;
                        }else{
                            exprResult = a / b;
                        }
                        break;

                    case "*":
                        exprResult = a * b;
                        break;
                    default:
                        System.out.println("Вы неверно ввели выражение, попробуйте еще раз");
                        break;
                }
                if (checkRoman) {
                    String str = rc.intToRoman(exprResult);
                    System.out.printf("Результат: %s", str);
                } else {
                    System.out.printf("Результат: %d", exprResult);
                }

            } else {
                System.out.println("Используются одновременно разные системы счисления");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

