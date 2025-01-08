package Test_API;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class CatFactTests {


    @Test
    public void GetCatFact_checkBodyIsNotEmpty() {
        given().
                contentType("JSON").
                when().
                get("https://alexwohlbruck.github.io/cat-facts/").
                then().
                assertThat().
                statusCode(200).
                body("text", notNullValue()).
                log().body();
                Assert.assertFalse("Text".isEmpty());
    }
}

