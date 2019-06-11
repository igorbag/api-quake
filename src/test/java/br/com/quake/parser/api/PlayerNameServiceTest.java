package br.com.quake.parser.api;

import br.com.quake.parser.api.service.PlayerNameService;
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
public class PlayerNameServiceTest {

    @Autowired
    private PlayerNameService playerNameService;

    @Test
    public void getPlayersNameTest() {
        List<String> games = new ArrayList<>();
        String game = "ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\xian/default\\hmodel\\xian/default\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0";
        games.add(game);


        Assert.assertNotNull(playerNameService.getPlayersName(games));
    }
}