package presenter;

import model.Calculate;
import view.View;

public class ToPresenter {
    private Calculate calc = new Calculate();

    public void doSomething(String userSelect){
        View input = new View();
        switch (userSelect) {
            case "1":
                //посмотреть всех людей
                calc.calculate(input.inputKey("Введите арифметическое выражение \n" +
                        "(вида a+b, a-b, a*b, a/b): \n"));
                break;
        }
    }



}
