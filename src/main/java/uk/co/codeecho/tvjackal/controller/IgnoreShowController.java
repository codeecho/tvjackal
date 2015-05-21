package uk.co.codeecho.tvjackal.controller;

import java.util.Map;
import uk.co.codeecho.mandrake.core.controller.AbstractController;
import uk.co.codeecho.mandrake.core.request.Request;
import uk.co.codeecho.mandrake.core.request.Response;
import uk.co.codeecho.tvjackal.model.User;

public class IgnoreShowController extends AbstractController{

    @Override
    public void handle(Request request, Response response, Map<String, Object> model) {
        User user = (User) request.getAttribute("user");
        user.addShowToIgnore(request.getParameter("show"));
    }

}
