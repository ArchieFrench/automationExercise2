# Serenity JUnit Starter project

Get started quickly with Serenity BDD and JUnit 5 with this simple starter project. 

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
| TC12         | Add Products in Cart                         | ✅ Completed     | Core add-to-cart flow implemented; validations pending. |

**Number of tests:** 4 (executed)  
**Percentage passed:** 100% (4 of 4 completed successfully)  

### Definition of Done  
<img width="432" height="590" alt="image" src="https://github.com/user-attachments/assets/929a23e6-61d7-4b4c-a0f9-ce4ce0bbe32b" />

---

## 🐞 Defects & Suggested Actions

### 1. Unconventional Signup Flow
<img width="695" height="403" alt="image" src="https://github.com/user-attachments/assets/c76e3311-6ee1-4deb-90d7-ad793c2a35db" />


**Description:**  
Unlike standard signup forms that present fields like **Email**, **Password**, and **Confirm Password** on a single page, this application uses a two-step process:

- **Step 1:** The user enters only **Name** and **Email**.
- **Step 2:** The user is taken to a new page to provide more information such as **Password**, **Title**, **Date of Birth**, and other account details.

**Why this is a defect:**  
- It deviates from standard user experience expectations for registration.  
- Users may be confused or drop off due to the unexpected redirection.  
- Automation scripts that assume a single-page form may break.  
- Page transitions require additional handling in test automation to ensure all fields are validated properly across both steps.

**Suggested Action:**  
- Treat this as a **multi-step form** in testing documentation and scripts.  
- Ensure test cases and automation flows are updated to verify each stage separately and confirm that data passes correctly from step 1 to step 2.

### 2. Country-State-City Mismatch Validation Issue
<img width="761" height="380" alt="image" src="https://github.com/user-attachments/assets/abdffeb8-9bd5-41c0-adf4-13b812ba30b9" />

**Description:**  
During registration, the user is allowed to select **India** as the country but still enter any other city, for example, **Glasgow** (a UK city) as the city. The form does not trigger any validation error or warning.

**Why this is a defect:**  
- Leads to **logically inconsistent data** in the system.  
- Breaks basic **geographic integrity rules**—a user should not be able to pair mismatched country and city combinations.  
- Could negatively impact downstream systems (e.g., shipping, reporting, or region-specific features).  
- Indicates a **lack of contextual validation** on the front end or back end.

**Suggested Action:**  
- Implement country-city validation rules to prevent incompatible combinations.  
- Add **negative test cases** to the automation suite that attempt invalid city-country pairings and expect proper error handling.

---


### 3. Button Blocked by Advertisement Pop-Up
**Description:**
On the product listing page, a persistent advertisement banner appears at the bottom of the screen. This banner occasionally obstructs the “Add to cart” button, making it unclickable during automated test execution.

**Why this is a defect:**
- Prevents reliable access to critical UI elements, such as the "Add to cart" button.
- Interferes with test automation flows, causing failures unrelated to the actual application logic.
- Introduces false negatives in test reports, increasing debugging time.
- Results in inconsistent test outcomes depending on ad timing and page load speed.

**Suggested Action:**
- Implement a scroll-to-element action before attempting to click buttons that may be blocked.
- Where possible, add logic to detect and dismiss pop-up ads or adjust viewport/window size in tests.
- Capture and document such cases with screenshots for test reporting and potential stakeholder review.

**Screenshot Evidence:**
<img width="1304" height="650" alt="Pop up ad blocks button" src="https://github.com/user-attachments/assets/21f2e244-013b-4134-91a7-58bd32de6be9" />
<img width="975" height="692" alt="Screenshot 2025-08-01 at 11 35 42" src="https://github.com/user-attachments/assets/4530777b-d73f-40d6-a7de-5bb2db02c2f1" />

---


### 🏗️ Framework Overview  
- **Serenity BDD**: Generates living documentation with rich test reports.  
- **JUnit 5**: Provides modern test lifecycle management.  
- **Selenium WebDriver**: Handles UI automation for web interactions.  
- **Maven/Gradle Support**: Flexible build and execution support.  

---

### 🚫 Blockers
- **Consent To Cookies**: The Locator struggled to reliably find the consent button regardless of extraction methods we have each tried.
- There is a workaround to this by pressing the consent button manually each time, it is not ideal but it allows the other scripts to run.
- This could be for a number of reasons, potentially because we each used different testing frameworks or errors with our setup environment or the website itself.
- Because the tests could still executed with valuable results and there is a manageable workaround it took low priority
  
---

### 🔄 Retrospective / Lessons Learned  

# 🧪 Serenity JUnit Starter Project Retrospective

This document reflects on the collaborative work done in the Serenity JUnit Starter project. It outlines what went well, what could be improved, key lessons learned, and takeaways for future projects.

---

## ✅ What Went Well

### 🧑‍💻 Pair Programming  
Working in pairs led to higher code quality and fewer bugs. It also encouraged active knowledge sharing and made troubleshooting more efficient. Team members were able to divide tasks logically, review each other’s code, and iterate quickly.

### 📌 Dependency Mapping via Topological Sort  
Using a topological sort to structure test case execution brought much-needed clarity to dependencies. It ensured that test cases ran in a logical order, reducing failures due to unhandled prerequisites.

### 🔀 Branching and Merging Workflow  
Using separate feature branches per test case and merging them into the main branch after review gave hands-on experience with Git workflows. This not only improved version control practices but also taught conflict resolution and collaborative development strategies.

### 📋 Trello for Task Management  
The Trello board allowed us to visually track progress, identify blockers early, and manage priorities. It improved team coordination and kept the entire project transparent and on schedule.

### 🎯 Test Focus  
We prioritized automating core user flows—like login, registration, and adding products to the cart—which delivered meaningful coverage early. This helped establish confidence in the framework and ensured we tested high-value scenarios first.

---

## ⚠️ What Could Be Improved

### 🧱 Framework Complexity  
Adopting Serenity and Cucumber at the start introduced a steep learning curve. While powerful, they added complexity before the team had fully grasped Selenium and JUnit fundamentals. This impacted early productivity and delayed progress.

### 🖱️ Pop-up/Ad Handling  
Automated tests occasionally failed due to advertisement pop-ups blocking essential UI elements (like the "Add to cart" button). This led to unstable test execution and false negatives.  
We should improve test resilience by adding scroll-to-element logic, using headless modes, or dismissing overlays programmatically.

---

## 💡 Lessons Learned

### 🔧 Start with One Framework  
Starting with just Selenium and JUnit would have reduced the cognitive load on the team. Once the basics were solidified, we could have layered in Serenity for reporting and Cucumber for behavior-driven development (BDD). This step-by-step adoption would have accelerated learning and boosted confidence.

---

## 📘 Key Takeaways for Future Projects

### 🛠️ Start Simple  
Begin with a minimal viable test setup. Once core test flows are stable and the team is comfortable, introduce advanced tools or integrations incrementally. Simplicity early on allows for rapid onboarding and more consistent execution.

### 📈 Build for Stability First  
Handle flaky elements (e.g., pop-ups, animations) early in the test lifecycle. Add retry logic, wait conditions, or headless testing to ensure test runs are deterministic and reproducible.

### 🗂️ Establish Testing Standards  
Implement templates for test case design, naming conventions, and assertions to ensure uniformity across the codebase. This reduces ramp-up time for new contributors and makes maintenance easier.

### 🔁 Continuous Integration Ready  
Aim to integrate the test suite into a CI/CD pipeline (e.g., GitHub Actions, Jenkins) to catch regressions early and reduce manual test execution overhead.

---
