package br.com.quake.parser.api;

import br.com.quake.parser.api.service.QuakeInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuakeInfoServiceTest {

    @Autowired
    private QuakeInfoService quakeInfoService;

    @Test
    public void getGameInfoTest() {
        Assert.assertTrue(quakeInfoService.getGameInfo().size() > 0);
    }

    @Test
    public void getGameInfoByIdTest() {
        int id = 1;
        Assert.assertNotNull(quakeInfoService.getGameInfoById(id));
    }


    @Test
    public void setUpGameInformationsTest() {
        final List<String> gamesMatch = new ArrayList<>();
        final String teste = "0:00 ClientUserinfoChanged: 3 n\\Dono da Bola\\t\\3\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0";
        gamesMatch.add(teste);

        Assert.assertNotNull(quakeInfoService.setUpGameInformations(gamesMatch));
    }
}
