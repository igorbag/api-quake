package br.com.quake.parser.api.service;

import io.reactivex.Flowable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class QuakeInfoService {

    private Flowable getGamesLog() {
        return Flowable.using(
                () -> new BufferedReader(new FileReader(new ClassPathResource("games.log").getFile())),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                reader -> reader.close()
        );
    }

    public void process() {
        this.getGamesLog().subscribe(System.out::println);
    }
}
