package br.com.quake.parser.api.data.local;

public final class Constants {
    public static final String GAMES_LOG_DATA_NAME = "games.log";
    public static final String INIT_GAME = "InitGame";
    public static final String CLIENT_USER_INFO = "ClientUserinfoChanged";
    public static final String END_GAME = "ShutdownGame";
    public static final String N_DELIMITER = "n" + "\\";
    public static final String T_DELIMITER = "\\" + "t";
    public static final String BY_DELIMITER = "by";
    public static final String KILL_PATTERN = "Kill";
    public static final String KILLED_PATTERN = " killed";
    public static final String GAME = "game_";
    public static final String WORLD = "world";

    public static String SWAGGER_NAME_PROJECT = "API Quake Parser";
    public static String SWAGGER_NAME_DESCRIPTION = "API responsavel por ler o arquivo de log do Quake 3 e expor em serviços";
    public static String SWAGGER_API_VERSION = "1.0.0";
    public static String SWAGGER_API_LICENSE = "Apache License Version 2.0";
    public static String SWAGGER_API_LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    public static String PROJECT_BASE_PACKAGE_NAME = "br.com.quake.parser.api";

}
