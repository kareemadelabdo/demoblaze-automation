# Demoblaze E-commerce Checkout Automation (Selenium + Java + TestNG)

This project automates the end-to-end scenario for till confirming checkout 

---

# Tech Stacks used

- Java 21
- Selenium WebDriver
- TestNG
- WebDriverManager (Bonigarcia)
- Maven (build & dependency management)
- Page Object Model (POM)

---

# Project structure

- `pages/` – Page Object classes for modular interaction with UI
- `tests/` – Test classes grouped by feature
- `utils/` – WebDriver factory, config reader, etc.
- `screenshots/` – Screenshots taken during runtime
- `testng.xml` – TestNG test suite

---

# Automated features

- Homepage validation
- Login with external credentials (via JSON)
- Product selection (fallback due to missing search bar)
- Cart validation and checkout flow
- Pop-up handling and alert confirmation
- Purchase confirmation and screenshot

---

#Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/kareemadelabdo/demoblaze-automation.git
   cd demoblaze-automation
