# Appium UI Testing Utility Codebase

Reusable Appium UI automation scripts and framework utilities for mobile app testing, designed to accelerate test automation across Android and iOS applications in a scalable and maintainable way.

---

## 📝 Project Overview
This repository contains a utility-focused Appium UI testing framework in Java using TestNG. It provides reusable components, driver setup utilities, common UI interaction workflows, and sample test cases to standardize mobile automation practices.

**Key Benefits:**
- Standardizes UI test creation and maintenance  
- Quick onboarding for new automation engineers  
- Easily integrates into CI/CD pipelines  

---

## 🚀 Key Features
- Reusable Appium driver setup and teardown utilities  
- Support for both Android & iOS platforms  
- TestNG framework integration for structured test execution  
- Sample test cases demonstrating best practices  
- Configurable test suite via `testng.xml`  
- Easily extendable for additional test scenarios  

---

## ⚙️ Technology Stack
- **Appium** — Mobile automation framework  
- **Java** — Primary language  
- **TestNG** — Test execution framework  
- **Maven** — Build & dependency management  

---

## 📥 Setup Instructions
### Prerequisites
- Java JDK  
- Maven  
- Appium server (`npm install -g appium`)  
- Appium Inspector for element locators  

### Installation
```bash
git clone https://github.com/AravindBalaji1990/AppiumUITestingCode.git
cd AppiumUITestingCode
mvn test

### Project Structure
AppiumUITestingCode
 ┣ src/
 ┃ ┣ main/java — Driver utils & helper components
 ┃ ┣ test/java — Test cases
 ┃ ┣ resources — Config files (e.g., testng.xml)
 ┣ pom.xml — Maven configuration

### Example Test Snippet
@Test
public void verifyLoginScreen() {
    loginPage.enterUsername("user1");
    loginPage.enterPassword("Pass@123");
    loginPage.tapLogin();
    Assert.assertTrue(homePage.isDisplayed());
}

🤝 Contribution & Support

Contributions are welcome! Raise an issue or submit a pull request.
For questions, contact aravindbalaji.balaji7@gmail.com.
