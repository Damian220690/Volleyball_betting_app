package pl.coderslab.model.POJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.repositories.VolleyballTeamRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class RoundsRunner {

    @Autowired
    RoundManager roundManager;

    @PostConstruct
    public void start() {

        new Thread(() -> {

            System.out.println("Competition started");

            List<Round> rounds = roundManager.getRounds();

            for (Round round : rounds) {
                round.start();
                try {
                    round.getQueue().take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Competition finished");
        }).start();
    }
}
