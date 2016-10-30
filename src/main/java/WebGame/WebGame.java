package WebGame;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

/**
 * Created by ArnarFreyr on 10/30/2016.
 */
public class WebGame implements SparkApplication{
    public static void main(String[] args){
        get("/hello", (req, res) -> "Hello World");
    }

    @Override
    public void init(){

    }
}
