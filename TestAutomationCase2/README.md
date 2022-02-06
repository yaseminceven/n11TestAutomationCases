## **N11 TEST AUTOMATION CASE 2**
### **Test Case Details**
With only one user read 15 products URL from csv file and them to cart. While adding the cart check if the product price is under 100. If it is expensive than 100 don't add them into cart. </br>
After adding 10 items into cart try to make payment without login. Enter the user information and go to the payment page.
### **Test Steps**
1. Read the csv file that contains product information and URL
2. Check if the price of the product is less than 100
3. If the price is lower than 100 add product to cart
4. Click on the payment button
5. Continue payment without login
6. Enter user information
7. Go to the payment page

### **Technologies**
- Jmeter

### **How to Run**
To run this project, download the n11_products.csv file and place it in the same directory as the jmx file. And run the jmx file.</br>
**Note:** If it gives an error and the csv file shows the third column numbers as scientific notation convert the third column into number format without the decimals.

### **Reporting**
Results are written into the ***apache-jmeter-x.x.x/bin/logfiles/results.xml*** file.  </br>
Also if any errors are encountered logs are will written into the ***apache-jmeter-x.x.x/bin/logfiles/errors.xml*** file.


