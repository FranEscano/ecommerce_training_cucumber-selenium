# Selenium-Cucumber E-commerce

## Overview

This project is a web navigation tool using Selenium and Cucumber for a sample online store. Instead of testing the website, it navigates through the steps a real buyer would take, including logging in, browsing the store, adding a product to the cart, applying a promotional code, entering personal details for the purchase, and verifying the successful completion of the order using the order number.

## Prerequisites

Ensure that the following tools are installed on your machine:

- Java (JDK 8 or later)
- Maven
- Git
- Chrome or Firefox browser

## Installation

1. Clone the repository:

```bash
git clone https://github.com/FranEscano/ecommerce_training_cucumber-selenium.git
```

2. Navigate to the project directory:

```bash
cd ecommerce_training_cucumber-selenium
```

3. Build and run the project using Maven:

```bash
mvn clean install
```

## Jenkins Integration

1. Install Jenkins on your server.

2. Create a new Pipeline job in Jenkins:

   a. Open Jenkins in your browser and click on "New Item."

   b. Enter a name for your job, select "Pipeline," and click "OK."

3. Configure the pipeline:

   a. In the job configuration, scroll down to the "Pipeline" section.

   b. Choose "Pipeline script from SCM" from the Definition dropdown.

   c. In the repository field, enter the original repository (https://github.com/FranEscano/ecommerce_training_cucumber-selenium.git) or your own if you have created one.
   Pay attention to the field section. If you are using the original repository, you should change it to 'main.'

4. Save the job configuration.

5. Run the pipeline manually:

   a. In the Jenkins dashboard, click on your pipeline job.

   b. Click on "Build Now" to trigger the pipeline manually.

The pipeline will now execute the navigation script.