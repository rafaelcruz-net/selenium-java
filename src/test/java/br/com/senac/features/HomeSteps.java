package br.com.senac.features;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class HomeSteps {

    private String testUrl;
    private WebDriver driver;
    WebElement searchText;
    WebElement searchBtn;

    @Dado("^que desejo entrar no Blog$")
    public void que_desejo_entrar_no_Blog() {

        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");

        testUrl = "https://rafaelcruz.azurewebsites.net";
    }

    @Quando("^quando abrir o browser$")
    public void quando_abrir_o_browser() {
        driver = new ChromeDriver();
        driver.get(testUrl);
    }

    @Entao("^devera aparecer a Home$")
    public void devera_aparecer_a_Home() {
        assertTrue("The page title should be chagned as expected",
        (new WebDriverWait(driver, 5))
                .until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getTitle().equals("Rafael Cruz");
                    }
                })
        );
    }


    @E("^digitar '(.*?)' no campo de busca$")
    public void digitar_no_campo_de_busca(String searchTerm) {
        this.searchText = driver.findElement(By.className("search-field"));
        searchText.sendKeys(searchTerm);
    }

    @E("^clicar no botao pesquisar$")
    public void clicar_no_botao_pesquisar() {
        searchBtn = driver.findElement(By.className("search-submit"));
        searchBtn.click();
    }

    @E("^devera aparecer o resultado de busca$")
    public void devera_aparecer_o_resultado_de_busca() {
        assertTrue("Search Result",
                (new WebDriverWait(driver, 5))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                WebElement result = d.findElement(By.className("page-title"));
                                return result.getText().contains("OAUTH");      
                            }
                        })
        );      
    }
    

    @After
    public void after() {
        driver.quit();
    }

}