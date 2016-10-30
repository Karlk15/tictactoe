package WebGame;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

/**
 * Created by ArnarFreyr on 10/30/2016.
 */
public class WebGame implements SparkApplication{
    public static void main(String[] args){
        get("/braaahhh", (req, res) -> "Hello World bits");
    }

    @Override
    public void init(){

    }
}
