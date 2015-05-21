package uk.co.codeecho.tvjackal.route;

import uk.co.codeecho.tvjackal.controller.IgnoreChannelController;
import uk.co.codeecho.tvjackal.controller.IgnoreShowController;
import uk.co.codeecho.tvjackal.controller.LoginFilter;
import uk.co.codeecho.tvjackal.controller.RecommendationsController;
import uk.co.codeecho.mandrake.core.controller.impl.TransactionController;
import static uk.co.codeecho.mandrake.core.request.HttpMethod.*;
import uk.co.codeecho.mandrake.core.request.Response;
import uk.co.codeecho.mandrake.core.task.TransactionalTask;
import uk.co.codeecho.tvjackal.model.Recommendations;
import uk.co.codeecho.tvjackal.model.User;
import uk.co.codeecho.tvjackal.task.RetrieveRecommendationsTask;

public class Router extends uk.co.codeecho.mandrake.core.router.Router{

    public Router() {
        onLoad(new TransactionalTask() {

            @Override
            public void doRun() {
                User user = new User();
            }
        });
        onLoad(new RetrieveRecommendationsTask());
        register("login", new LoginFilter());
        route(GET, "/test1").response(Response.ok("It Works!").build());
        route(GET, "/test2").response("It Works");
        route(GET, "/test3").response(new Recommendations(null, null, null)).json();
        route(GET, "/test3").response(new Recommendations(null, null, null)).text();
        route(GET, "/test3").response(new Recommendations(null, null, null)).format("json");
        route(GET, "/").to("login").to(new RecommendationsController()).render("recommendations.jade");
        route(POST, "/ignoreChannel").to("login").to(new TransactionController()).to(new IgnoreChannelController()).response(204);
        route(POST, "/ignoreShow").to("login").to(new TransactionController()).to(new IgnoreShowController()).response(204);
        route(404).render("404.jade");
        route(Exception.class).response(Response.status(500).body("Internal Server Error").build());
        route(GET, "/*").redirect("/");
        schedule("0 6 * * Mon", new RetrieveRecommendationsTask());
    }

}
