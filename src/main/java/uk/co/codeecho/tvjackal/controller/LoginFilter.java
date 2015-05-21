package uk.co.codeecho.tvjackal.controller;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import biz.devspot.entity.framework.core.query.Query;
import java.util.Map;
import uk.co.codeecho.mandrake.core.controller.AbstractController;
import uk.co.codeecho.mandrake.core.request.Request;
import uk.co.codeecho.mandrake.core.request.Response;
import uk.co.codeecho.tvjackal.model.User;

public class LoginFilter extends AbstractController{

    @Override
    public void handle(Request request, Response response, Map<String, Object> model) {
        User user = EntityManagerFactory.getManager().find(User.class, new Query()).get(0);
        request.setAttribute("user", user);
    }

}
