package br.com.quake.parser.api.service;

import br.com.quake.parser.api.data.local.Constants;
import io.reactivex.Flowable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadLogService {

    public List<String> getGamesLog() {

        List<String> listLog = new ArrayList<>();

        Flowable.using(
                () -> new BufferedReader(new FileReader(new ClassPathResource(Constants.GAMES_LOG_DATA_NAME).getFile())),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                reader -> reader.close()
        ).subscribe(listLog::add);

        return listLog;
    }
}
