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
1. Unconventional Signup Flow
Why it’s a defect:

Expected behavior: Most websites present a single-step form where users enter all essential credentials (email, password, confirm password) before creating an account. This is intuitive, familiar to users, and aligns with standard UX design.

Actual behavior: The site begins the signup with just "Name" and "Email," then unexpectedly redirects to a separate page for the rest of the information. This non-standard flow:

Breaks user expectations.

Can confuse automation scripts that are written assuming a single form submission.

Increases the chance of user drop-off if the transition is not handled smoothly.

Why it matters for testing: This is a flow-based form, not a flat form. Many automation frameworks treat form submission as a single event, so this requires special handling in scripts to manage the transition between pages and ensure form continuity.

Suggested Action:

Clearly document and handle the multi-step flow in test cases.

Ensure test automation recognizes the change in context (e.g., page navigation, DOM changes).

2. Country-City Mismatch Validation Issue
Why it’s a defect:

Expected behavior: When a user selects a country (e.g., India), the system should restrict or validate the city field to ensure consistency (e.g., only Indian cities allowed).

Actual behavior: You can enter a city like "Glasgow" (a UK city) even when "India" is selected as the country — and the system accepts it without error.

Why this is a problem:

It undermines data integrity — results in nonsensical or contradictory user profiles.

Real-world systems using this data (e.g., shipping, marketing) could fail or behave unpredictably.

It’s a missed validation opportunity, and automation scripts may pass despite flawed user input.

This is a clear business logic flaw — even if the field technically allows free text, it should be validated in context.

Suggested Action:

Add validation checks to ensure the entered city logically matches the selected country.

Include negative test cases in automation to ensure invalid combinations are rejected.


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
