package pl.coderslab.model.POJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RoundsRunner {

    @Autowired
    RoundManager roundManager;

    @PostConstruct
    public void start() {
        new Thread(() -> {
            List<Round> rounds = roundManager.getRounds();
            for (Round round : rounds) {
//                try {
//                    TimeUnit.SECONDS.sleep(30);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                round.start();
                try {
                    round.getQueue().take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
