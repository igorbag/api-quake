package br.com.quake.parser.api;

import br.com.quake.parser.api.service.KillInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KillGameServiceTest {

    private static final String mockLog = "2:37 Kill: 3 2 10: Isgalamido killed Dono da Bola by MOD_RAILGUN";
    @Autowired
    private KillInfoService killInfoService;

    @Test
    public void noKillPlayersTest() {
        final List<String> players = new ArrayList<>();
        final List<String> lines = new ArrayList<>();
        final Map kills = killInfoService.getKills(players, lines);
        lines.add("info-test");

        Assert.assertTrue(kills.isEmpty());
    }


    @Test
    public void noPlayersTest() {
        final List<String> players = new ArrayList<>();
        final List<String> lines = new ArrayList<>();
        final Map kills = killInfoService.getKills(players, lines);

        Assert.assertTrue(kills.isEmpty());
    }



    @Test
    public void playerAwayFromKeyboardTest() {
        final List<String> players = new ArrayList<>();
        final List<String> lines = new ArrayList<>();
        players.add("no-player");
        lines.add(mockLog);
        final Map kills = killInfoService.getKills(players, lines);
        Assert.assertEquals(0, kills.get("no-player"));
    }


    @Test
    public void playerWhenKilledAnotherPlayerTest() {
        final List<String> players = new ArrayList<>();
        final List<String> lines = new ArrayList<>();
        players.add("Igor");
        lines.add(mockLog);
        final Map kills = killInfoService.getKills(players, lines);
        Assert.assertFalse(kills.isEmpty());
    }
}