package kristiania.no.http.controllers;

import kristiania.no.http.HttpMessage;
import kristiania.no.jdbc.user.User;
import kristiania.no.jdbc.user.UserDao;

import java.sql.SQLException;


public class ListUsersController implements HttpController {
    private final UserDao userDao;

    public ListUsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public HttpMessage handle(HttpMessage request) throws SQLException {
        String responseText = "";

        for (User user : userDao.listAll()) {
            responseText += "<option value=" + user.getId() + ">" + user.getUserName() + "</option>";
        }


                /*
                if(requestTarget.equals("/takeSurvey.html")){

                    for (User user : userDao.listAll()) {

                        if (user.getId() == 1) {
                            System.out.println("test");
                            responseText += "";

                        } else {
                            String responseText1 = "";
                            for (User user1 : userDao.listAll()) {

                                responseText1 += "<option value=" + user1.getId() + ">" + user1.getUserName() + "</option>";
                            }

                        }
                    }
                }else {
                    /*
                    for (User user : userDao.listAll()) {
                        responseText += "<option value=" + user.getId() + ">" + user.getUserName() + "</option>";
                    }

                     */
        return new HttpMessage("HTTP/1.1 200", responseText);
    }
}

