* ByteCraft_Techinical_Assessment Using Selenium and RESTAssured

* Using Selenium and RESTAssured is a assessment project to perform some GUI and API Tests using selenium and RESTAssured.

* Using Page Object Model design pattern

--These Test Automation Scripts built With :

-Java

-Maven

-Selenium

-RESTAssured

-TestNG

-Allure Reporting

-extent-spark.html

-Task Requirements :

Web GUI Test Automation:

******* Google Search*********

1- Navigate to "https://www.google.com/ncr"

2- Search for "selenium webdriver"

3- Check that the third result text contains "What is Selenium WebDriver?" Although test result contains Download (the third text)

*******Herokuapp********

1- Navigate to "https://the-internet.herokuapp.com/"

2- Click on "File Upload"

3- Upload any small image file

4- Check that the file has been uploaded successfully

*******Herokuapp********

1- Navigate to "https://the-internet.herokuapp.com/"

2- Click on "Dynamic Loading"

3- Click on "Example 2"

4- Click "Start"

5- Wait for loading to finish

6- Check that the text displayed is "Hello World!"

********API Test Automation********

1- Navigate to "https://alexwohlbruck.github.io/cat-facts/"

2- Use the relevant API endpoint to get one random cat fact

3- Check that the response "text" is not empty

Test Cases for GUI :

Test case: Test_Google_search

Test case: UploadTest

Test case: DynamicTest
--------------------------------------------------------------

Test Cases for API :

Test case: GetCatFact_checkBodyIsNotEmpty
