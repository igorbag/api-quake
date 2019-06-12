package br.com.quake.parser.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Suite.SuiteClasses({
        QuakeInfoServiceTest.class,
        KillGameServiceTest.class,
        PlayerNameServiceTest.class,
        GameServiceTest.class
})
public class ApiApplicationTests {

    @Test
    public void contextLoads() {
    }

}
