# api-quake

### Configuração ###

****

API responsavel por
expor arquivo games.log que é gerado pelo servidor de quake 3 arena. Ele registra todas as informações dos jogos, quando um jogo começa, quando termina, quem matou quem, quem morreu pq caiu no vazio, quem morreu machucado, entre outros.
s  
  ### Exemplo do arquivo de log

       21:42 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT
   
   O player "Isgalamido" morreu pois estava ferido e caiu de uma altura que o matou.
 
       2:22 Kill: 3 2 10: Isgalamido killed Dono da Bola by MOD_RAILGUN
   
   O player "Isgalamido" matou o player Dono da Bola usando a arma Railgun.
   
  ### Regras
1. Quando o `<world>` mata o player ele perde -1 kill.
2. `<world>` não é um player e não deve aparecer na lista de players e nem no dicionário de kills.
3. `total_kills` são os kills dos games, isso inclui mortes do `<world>`.
  
  #### Retorno
  ```
    "game_1": {
           "totalKills": 2,
           "players": [
               "Isgalamido",
               "Dono da Bola",
               "Mocinha",
               "Zeh"
           ],
           "kills": {
               "Dono da Bola": 0,
               "Mocinha": -2,
               "Isgalamido": 2,
               "Zeh": 0
           }
       }
  ```
  
  #### Endpoints
   - http://localhost:8080/game
   - http://localhost:8080/game/{id}
  
  ### Documentacao com Swagger
   - http://localhost:8080/swagger-ui.html
  ### Ambiente
  1. git clone https://github.com/igorbag/api-quake.git 
  4. Executar o comando mvn spring-boot:run
  5. Após a aplicação subir, acesse a URL http://localhost:8080/game/
  
  ### Tecnologias utilizadas
  1. Java
  2. Spring Boot
  3. Maven
  3. Testes com JUnit
  4. RxJava
  5. Lombok
  6. Swagger