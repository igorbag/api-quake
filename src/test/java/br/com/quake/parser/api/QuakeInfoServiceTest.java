package br.com.quake.parser.api;

import br.com.quake.parser.api.service.QuakeInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuakeInfoServiceTest {

    @Autowired
    private QuakeInfoService quakeInfoService;

    @Test
    public void getGameInfoTest() {
        Assert.assertTrue(quakeInfoService.getGameInfo().size() > 0);
    }
}
