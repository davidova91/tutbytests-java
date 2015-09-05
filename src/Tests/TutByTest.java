package Tests;

import Framework.TutByPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TutByTest {

    @Test
    public void search_results_count_is_in_allowed_range() {

        String findText = "специалист по тестированию";
        Integer maxCountPerPage = 20;
        Integer minCount = 0;

        TutByPage.open();
        TutByPage.goToWorkPage();
        TutByPage.searchText(findText);
        Integer result = TutByPage.checkCount(findText);
        System.out.print("retrieved " + result + " results. ");

        Assert.assertTrue("cannot be larger than max result count per page", result <= maxCountPerPage);
        Assert.assertTrue("cannot be less than 0", result >= minCount);
    }

    @After
    public void Clean() {

        TutByPage.close();
    }
}
