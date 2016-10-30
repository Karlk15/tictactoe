package WebGame;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

import business.layer.PlayService;

/**
 * Created by ArnarFreyr on 10/30/2016.
 */
public class WebGame implements SparkApplication{
    public static void main(String[] args){
        staticFileLocation("/public");
        SparkApplication webGame = new WebGame();

        webGame.init();

    }

    @Override
    public void init(){
        PlayService PS = new PlayService();
        get("/getBoard", (request, response) -> {
            response.status(100);
            return PS.getBoard();
        });

        get("/getPlayer", (request, response) ->{
           response.status(100);
            return PS.getPlayer();
        });

        post("/restart", (request, response) -> {
            PS.restartGame();
            response.status(100);
            return PS.getBoard();
        });
    }
}
