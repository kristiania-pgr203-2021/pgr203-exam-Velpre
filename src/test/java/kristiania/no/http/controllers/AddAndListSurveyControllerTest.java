package kristiania.no.http.controllers;

import kristiania.no.http.HttpMessage;
import kristiania.no.jdbc.TestData;
import kristiania.no.jdbc.survey.SurveyDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class AddAndListSurveyControllerTest {
    SurveyDao surveyDao = new SurveyDao(TestData.testDataSource());
    AddAndListSurveyController addAndListSurveyController = new AddAndListSurveyController(surveyDao);

    @Test
    void shouldListSurveys() throws SQLException {
        HttpMessage httpMessage = new HttpMessage("GET HTTP/1.1 200", "");
        HttpMessage response = addAndListSurveyController.handle(httpMessage);
        assertThat(response.messageBody).contains("<option value=1>Client Questionnaire</option>");
    }
}