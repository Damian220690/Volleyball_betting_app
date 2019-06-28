package pl.coderslab.model.POJO;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CouponsContainer {

    private HashMap<String, Double> winningsValue;

    CouponsContainer(){
        winningsValue = new HashMap<>();
    }

    public HashMap<String, Double> getWinningsValue() {
        return winningsValue;
    }

    public void setWinningsValue(HashMap<String, Double> winningsValue) {
        this.winningsValue = winningsValue;
    }
}
