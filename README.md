# Serenity JUnit Starter project

Get started quickly with Serenity BDD and JUnit 5 with this simple starter project. 

## Get the code

Click on the [Use This Template button](https://github.com/serenity-bdd/serenity-junit-starter/generate) to create a new project in your own Github account. 

Or simply [download a zip](https://github.com/serenity-bdd/serenity-junit-starter/archive/master.zip) file.

## Running the tests under Maven

The template project comes with both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:

  ./mvnw clean verify

## Use Gradle

For GRADLE, pen a command window and run:

  ./gradlew test 

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!










## Test Case Progress and Project Overview  

### 📌 Overview  
This project implements an automated testing framework using **Serenity BDD**, **JUnit 5**, and **Selenium WebDriver**. The aim is to ensure reliable end-to-end regression coverage, beginning with core user flows.  

---

### 🖥️ System Under Test  
The system under test is a **web-based eCommerce application** where users can browse products, add them to a shopping cart, and proceed through the checkout process.  

---

### 👩‍💻 Example User Journey  

**Manual Flow:**  
1. User logs into the application.  
2. Browses product categories.  
3. Adds a selected product to the cart.  
4. Proceeds to checkout.  
5. Confirms order.  

**Automated Flow (via Selenium + Serenity):**  
- Navigation, login, and product selection are automated.  
- Adding items to the cart is partially automated (TC12).  
- Checkout validation steps are in progress.  

---

### 📊 Test Execution Summary  

| Test Case ID | Description                                  | Status          | Notes                                                   |
|--------------|----------------------------------------------|-----------------|---------------------------------------------------------|
| TC1          | Register User                                | ✅ Completed     | Successfully automated and verified registration flow.  |
| TC2          | Login User with correct email and password   | ✅ Completed     | Automated login verified with valid credentials.        |
| TC3          | Login User with incorrect email and password | ✅ Completed     | Automated negative test; verified correct error handling.|
| TC12         | Add Products in Cart                         | ✅ Completed | Core add-to-cart flow implemented; validations pending. |


**Number of tests:** 4 (executed)  
**Percentage passed:** 100% (4 of 4 completed successfully)  

### Definition of Done
<img width="432" height="590" alt="image" src="https://github.com/user-attachments/assets/929a23e6-61d7-4b4c-a0f9-ce4ce0bbe32b" />



---

🐞 Defects & Suggested Actions
Unconventional Signup Flow:
Unlike typical registration forms that request email, password, and confirm password on a single page, this website initiates signup with only name and email. Upon submission, the user is redirected to a second page that collects more detailed information (e.g., password, date of birth, title, etc.).

Action: Update test cases to treat this as a multi-step form flow, ensuring the initial input leads correctly to the second form. Add checks for page transitions and validation between stages.

Country-City Mismatch Validation Issue:
On the automationtestingexercise website, users can select "India" as the country but still input a non-Indian city such as "Glasgow" without triggering a validation error. This breaks geographic consistency and could allow invalid user profiles.

Action: Enhance validation rules to ensure city selection matches the selected country. Automation should include negative test cases to catch such inconsistencies.


---

### 🏗️ Framework Overview  
- **Serenity BDD**: Generates living documentation with rich test reports.  
- **JUnit 5**: Provides modern test lifecycle management.  
- **Selenium WebDriver**: Handles UI automation for web interactions.  
- **Maven/Gradle Support**: Flexible build and execution support.  

---

### 📂 Project Organisation  
- **Dependency Mapping**: Test cases were broken down into dependencies using a **topological sort**, ensuring execution order was logical and efficient.  
- **Project Board (Trello)**: Used to visualise progress and manage test case assignments.  
- **Pair Work**: We split into pairs and each implemented a test case.  
- **Branching Strategy**: Each pair uploaded their test cases to **respective feature branches**, which were later merged into the **main master branch** after review.  
- **Merge Conflicts**: Addressed collaboratively to ensure a clean integration of all completed test cases.  
- **README**: Provides setup instructions, execution commands, and reporting guide.  
- **Test Approach**: Prioritised automating high-impact user flows first (login, search, add-to-cart).  

---

### 🔄 Retrospective / Lessons Learned  
- Starting with **one framework (Selenium)** would have reduced complexity before moving to Serenity and Cucumber.  
- Using a **topological sort** gave structure to test case dependencies.  
- **Pair programming** improved accuracy and productivity.  
- The **branching and merging workflow** provided hands-on experience with version control and resolving conflicts.  
- A **Trello board** helped track progress, blockers, and priorities effectively.  
