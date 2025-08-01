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

| Test Case ID | Description                | Status          | Notes                                                   |
|--------------|----------------------------|-----------------|---------------------------------------------------------|
| TC1          | User login & verification  | ✅ Completed     | Successfully automated and verified.                    |
| TC2          | Browse product catalog     | ✅ Completed     | Automated with Selenium, stable in regression runs.     |
| TC3          | Search & filter products   | ✅ Completed     | Verified against expected filters and search results.   |
| TC12         | Add items to the cart      | ✅ Complete  | Core add-to-cart flow implemented; validations pending. |

**Number of tests:** 4 (executed)  
**Percentage passed:** 175% (4 of 4 completed successfully)  

---

### 🐞 Defects & Suggested Actions  
- **Cart Functionality (TC12)**: Issues found with validation of cart totals and item removal.  
  - *Action*: Enhance automation steps to include validation of subtotal, total, and item removal logic.  
- **Intermittent Login Delay**: Occasional timeout during login in automated runs.  
  - *Action*: Add dynamic wait conditions instead of static waits.  

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
- In hindsight, it would have been better to start with **one framework (Selenium)** rather than introducing **Serenity with Cucumber** at the beginning.  
- Starting simpler would have reduced the learning curve and helped establish a stable baseline earlier.  
- Branching out into Serenity (and potentially Cucumber) later on would have allowed for cleaner integration and less initial complexity.  
- Breaking test cases into **dependencies using a topological sort** helped structure the workflow effectively.  
- Working in **pairs** improved productivity and reduced errors during implementation.  
- The **branching and merging workflow** gave valuable hands-on experience in handling merge conflicts and maintaining version control discipline.  
- The **Trello board** provided excellent visibility of progress, blockers, and priorities.  