package uk.co.codeecho.tvjackal.route;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import biz.devspot.entity.framework.core.dao.EntityDao;
import biz.devspot.entity.framework.core.query.Query;
import uk.co.codeecho.mandrake.core.controller.impl.ClasspathAssetController;
import uk.co.codeecho.tvjackal.controller.IgnoreChannelController;
import uk.co.codeecho.tvjackal.controller.IgnoreShowController;
import uk.co.codeecho.tvjackal.controller.LoginFilter;
import uk.co.codeecho.tvjackal.controller.RecommendationsController;
import static uk.co.codeecho.mandrake.core.request.HttpMethod.*;
import uk.co.codeecho.mandrake.plugins.crust.controller.TransactionController;
import uk.co.codeecho.mandrake.plugins.crust.task.TransactionalTask;
import uk.co.codeecho.tvjackal.model.User;
import uk.co.codeecho.tvjackal.task.RetrieveRecommendationsTask;

public class Router extends uk.co.codeecho.mandrake.core.router.Router {

    public Router(EntityDao dao) {
        onLoad(new TransactionalTask() {

            @Override
            public void doRun() {
                if (EntityManagerFactory.getManager().find(User.class, new Query()).isEmpty()) {
                    User user = new User();
                }
            }
        });
        onLoad(new RetrieveRecommendationsTask(dao));
        register("login", new LoginFilter());
        route(GET, "/assets/.*").to(new ClasspathAssetController());
        route(GET, "/webjars/.*").to(new ClasspathAssetController());
        route(GET, "/").to("login").to(new RecommendationsController()).render("recommendations.jade");
        route(POST, "/ignoreChannel").to("login").to(new TransactionController()).to(new IgnoreChannelController()).response(204);
        route(POST, "/ignoreShow").to("login").to(new TransactionController()).to(new IgnoreShowController()).response(204);
        route(404).render("404.jade");
        route(GET, "/*").redirect("/");
        schedule("0 6 * * Mon", new RetrieveRecommendationsTask(dao));
    }

}
