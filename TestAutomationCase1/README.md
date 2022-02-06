## **N11 TEST AUTOMATION CASE 1**
### Test Case Details
Writing test automation code to obtain list of campaigns from campaigns page and writing the results into Excel.
### Test Steps
1. Open https://www.n11.com/kampanyalar page
2. Click on each category
3. Obtain list of campaigns in a separate Excel sheet for each category

### Technologies
- Java SDK 11
- Maven
- Cucumber
- Serenity BDD Framework

### How to Run
To run this project, download or clone the project. In the project directory run the following command to run the tests.
```
mvn clean verify
```

After the tests are completed campaigns are written into urlList.xlsx.

### Reporting
Reports that are obtained with Cucumber are located under the ***/target*** directory.  </br>
Reports provided by the Serenity framework are located under the ***/target/site/serenity*** directory. </br>

- serenity-summary.html report gives a summarized report
- index.html report provides a detailed report including screenshots for each test

