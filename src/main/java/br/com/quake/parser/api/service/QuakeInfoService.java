package br.com.quake.parser.api.service;

import br.com.quake.parser.api.data.local.Constants;
import io.reactivex.Flowable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class QuakeInfoService {

    private Flowable getGamesLog() {
        return Flowable.using(
                () -> new BufferedReader(new FileReader(new ClassPathResource(Constants.GAMES_LOG_DATA_NAME).getFile())),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                reader -> reader.close()
        );
    }

    public void process() {
        this.getGamesLog().subscribe(System.out::println);
    }
}
