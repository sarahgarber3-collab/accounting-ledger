# Accounting Ledger Application

A console-based personal accounting application built with Java that makes it easy to record deposits and payments, review transaction history, and generate financial reports.

![Java](https://img.shields.io/badge/Java-17-orange)
![Build](https://img.shields.io/badge/Build-Maven-blue)

## Overview

The Accounting Ledger Application helps users track money coming in and going out without relying on a spreadsheet or external service. Transactions are stored in a CSV file and loaded into the application at runtime.

This project demonstrates object-oriented Java design, menu-driven console navigation, file I/O, date filtering, input validation, collections, and formatted terminal output.

## Features

- Add deposits and payments
- Record the date, time, description, vendor, and amount
- Automatically save transactions to `transactions.csv`
- View all transactions, deposits, or payments
- Filter transactions by:
  - Month to date
  - Previous month
  - Year to date
  - Previous year
  - Vendor
  - Custom date, description, vendor, or amount criteria
- Generate a transaction summary
- Validate transaction input before saving
- Display ANSI-formatted console output

## Getting Started

### Prerequisites

- Java 17 or later
- Apache Maven

### Clone the Repository

```bash
git clone https://github.com/sarahgarber3-collab/accounting-ledger.git
cd accounting-ledger
```

### Run the Application

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.pluralsight.Main"
```

Alternatively, open the project in IntelliJ IDEA and run `src/main/java/com/pluralsight/Main.java`.

## Using the Application

### Home Menu

| Option | Action |
|---|---|
| `D` | Add a deposit |
| `P` | Add a payment |
| `L` | Open the ledger |
| `X` | Exit the application |

### Ledger Menu

| Option | Action |
|---|---|
| `A` | View all transactions |
| `D` | View deposits |
| `P` | View payments |
| `R` | Open reports |
| `H` | Return home |

### Reports Menu

| Option | Action |
|---|---|
| `1` | Month-to-date transactions |
| `2` | Previous-month transactions |
| `3` | Year-to-date transactions |
| `4` | Previous-year transactions |
| `5` | Search by vendor |
| `6` | View a transaction summary |
| `7` | Run a custom search |
| `0` | Return to the ledger |

## Data Storage

Transactions are stored in:

```text
src/main/resources/transactions.csv
```

Each row uses pipe-delimited fields:

```text
date|time|description|vendor|amount
2026-04-28|11:49:47|Bills|Landlord|-500.00
```

- **Date:** `yyyy-MM-dd`
- **Time:** `HH:mm:ss`
- **Description:** A short explanation of the transaction
- **Vendor:** The person or organization involved
- **Amount:** Positive values represent deposits; negative values represent payments

## Project Structure

```text
src/main/java/com/pluralsight/
├── Main.java                 # Application entry point
├── model/                    # Transaction models and validation
├── service/                  # Ledger and report filtering logic
├── ui/                       # Console screens and menu navigation
└── util/                     # CSV writing and terminal formatting

src/main/resources/
└── transactions.csv          # Persistent transaction data
```

## Technical Highlights

- Java 17 with Maven
- Object-oriented package organization
- `ArrayList`-based in-memory transaction management
- CSV file reading and writing
- `LocalDate` and `LocalTime` for date and time handling
- Custom transaction validation and exception handling
- Date-based and vendor-based report filtering
- Custom console search across multiple fields
- ANSI terminal formatting for an improved command-line interface

## Author

Created as a Java application project to practice console application development, file persistence, filtering, and object-oriented design.
