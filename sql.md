# DBMS and SQL Interview Preparation

## 1. DBMS vs RDBMS

### What is DBMS?

**DBMS** stands for **Database Management System**.

It is software used to:

- Store data.
- Retrieve data.
- Insert and update data.
- Delete data.
- Manage database security.
- Provide backup and recovery.

Examples:

- MongoDB
- File-based database systems
- Hierarchical databases

### What is RDBMS?

**RDBMS** stands for **Relational Database Management System**.

It stores data in the form of related tables containing:

- Rows.
- Columns.
- Primary keys.
- Foreign keys.
- Constraints.

Examples:

- MySQL
- PostgreSQL
- Oracle
- SQL Server
- SQLite

### DBMS vs RDBMS

| Feature | DBMS | RDBMS |
|---|---|---|
| Full form | Database Management System | Relational Database Management System |
| Data storage | Files, documents, graphs, or other structures | Tables containing rows and columns |
| Relationships | May not support relationships | Supports relationships using keys |
| Foreign keys | May not be available | Supported |
| Normalization | Not always used | Commonly used |
| Data integrity | Limited or depends on the system | Enforced using constraints |
| Examples | MongoDB, hierarchical DBMS | MySQL, PostgreSQL, Oracle |

### Interview Answer

> A DBMS is software used to manage data in a database. An RDBMS is a type of DBMS that stores data in related tables and uses keys and constraints to maintain relationships and data integrity.

***

# 2. Keys

Consider the following table:

```text
STUDENT
--------------------------------
student_id
name
email
department_id
```

## Primary Key

A **primary key** uniquely identifies every row in a table.

```sql
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    department_id INT
);
```

### Properties

- Must be unique.
- Cannot contain `NULL`.
- A table can have only one primary key.
- It can contain one column or multiple columns.

Example:

```text
student_id
-----------
101
102
103
```

Here, `student_id` uniquely identifies each student.

***

## Can a table have multiple primary keys?

No.

A table can have only **one primary key**.

However, that primary key can contain multiple columns. This is called a **composite primary key**.

```sql
CREATE TABLE Enrollment (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id)
);
```

Here, the combination of `student_id` and `course_id` is the primary key.

***

## Can a primary key contain NULL?

No.

A primary key cannot contain `NULL`.

A primary key is effectively:

```text
PRIMARY KEY = UNIQUE + NOT NULL
```

A row must always have a valid identifier.

***

## Candidate Key

A **candidate key** is a minimal column or group of columns that can uniquely identify a row.

Suppose both `student_id` and `email` are unique:

```text
student_id = 101
email = ravi@example.com
```

Then both are candidate keys.

One candidate key is selected as the primary key.

Example:

```sql
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    department_id INT
);
```

Here:

```text
Candidate keys:
- student_id
- email

Primary key:
- student_id

Alternate key:
- email
```

***

## Super Key

A **super key** is any column or combination of columns that uniquely identifies a row.

Examples:

```text
student_id
email
(student_id, name)
(student_id, email)
```

`student_id` is a super key because it uniquely identifies a student.

`(student_id, name)` is also a super key, but `name` is unnecessary because `student_id` is already unique.

***

## Candidate Key vs Super Key

| Candidate Key | Super Key |
|---|---|
| Uniquely identifies a row | Uniquely identifies a row |
| Must be minimal | May contain unnecessary columns |
| Example: `student_id` | Example: `(student_id, name)` |

### Important Interview Line

> Every candidate key is a super key, but every super key is not a candidate key.

***

## Composite Key

A **composite key** contains two or more columns.

```sql
CREATE TABLE StudentCourse (
    student_id INT,
    course_id INT,
    enrolled_on DATE,
    PRIMARY KEY (student_id, course_id)
);
```

The combination of `student_id` and `course_id` uniquely identifies an enrollment.

***

## Unique Key

A **unique key** prevents duplicate values in a column or group of columns.

```sql
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    department_id INT
);
```

Now two students cannot have the same email address.

***

## Primary Key vs Unique Key

| Feature | Primary Key | Unique Key |
|---|---|---|
| Allows duplicate values | No | No |
| Allows `NULL` | No | Depends on the DBMS |
| Number allowed per table | Only one | Multiple |
| Main purpose | Main row identifier | Prevent duplicate values |
| Example | `student_id` | `email` |

### Interview Answer

> A primary key is the main identifier of a row and cannot be `NULL`. A unique key also prevents duplicate values, but a table can have multiple unique keys.

***

## Foreign Key

A **foreign key** is a column that refers to a primary key or unique key in another table.

```sql
CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100)
);
```

```sql
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    department_id INT,

    FOREIGN KEY (department_id)
        REFERENCES Department(department_id)
);
```

Relationship:

```text
Student.department_id
        |
        v
Department.department_id
```

***

## Why Do We Need Foreign Keys?

Foreign keys are used to:

- Maintain referential integrity.
- Prevent invalid references.
- Prevent orphan records.
- Maintain relationships between tables.
- Keep related data consistent.

Without a foreign key, this invalid data could be inserted:

```text
student_id | name  | department_id
101        | Ravi  | 999
```

If department `999` does not exist, this is invalid data.

A foreign key prevents this insertion.

***

# 3. Normalization

**Normalization** is the process of organizing data into tables to:

- Reduce data redundancy.
- Avoid duplicate data.
- Prevent update anomalies.
- Prevent insert anomalies.
- Prevent delete anomalies.
- Improve data consistency.

***

## Data Redundancy

**Data redundancy** means storing the same information multiple times.

Bad design:

```text
employee_id | employee_name | department_id | department_name
--------------------------------------------------------------
1           | Arun          | 10            | Engineering
2           | Neha          | 10            | Engineering
3           | Ravi          | 20            | HR
```

`Engineering` is repeated for multiple employees.

Better design:

```text
Employee
--------------------------------
id | name | department_id
1  | Arun | 10
2  | Neha | 10
3  | Ravi | 20
```

```text
Department
----------------------------
id | department_name
10 | Engineering
20 | HR
```

***

## Update Anomaly

An **update anomaly** occurs when the same information is stored in multiple places and only some copies are updated.

Example:

```text
Employee 1 → Engineering
Employee 2 → Engg
```

Both employees belong to the same department, but the values are inconsistent.

***

## Insert Anomaly

An **insert anomaly** occurs when you cannot insert one piece of information without inserting unrelated information.

Example:

If department information is stored only in the `Employee` table, you cannot insert a new department until at least one employee joins it.

With a separate table, you can insert:

```sql
INSERT INTO Department (id, department_name)
VALUES (30, 'Finance');
```

***

## Delete Anomaly

A **delete anomaly** occurs when deleting one record accidentally deletes other important information.

Example:

If the only employee in the HR department leaves and you delete that employee’s row, you may also lose all information about the HR department.

***

## First Normal Form: 1NF

A table is in **1NF** when:

- Each column contains atomic values.
- There are no repeating groups.
- Each row is uniquely identifiable.

Bad example:

```text
student_id | name | phone_numbers
----------------------------------
101        | Ravi | 98765, 87654
```

Good design:

```text
StudentPhone
------------------------
student_id | phone_number
101        | 98765
101        | 87654
```

***

## Second Normal Form: 2NF

A table is in **2NF** when:

1. It is already in 1NF.
2. It has no partial dependency.
3. Every non-key column depends on the entire primary key.

Example:

```text
Enrollment
------------------------------------------------
student_id | course_id | student_name | course_name | grade
```

Assume the primary key is:

```text
(student_id, course_id)
```

Problems:

```text
student_name depends only on student_id
course_name depends only on course_id
grade depends on both student_id and course_id
```

Better design:

```text
Student
-------------------------
student_id | student_name
```

```text
Course
-------------------------
course_id | course_name
```

```text
Enrollment
-----------------------------------
student_id | course_id | grade
```

***

## Third Normal Form: 3NF

A table is in **3NF** when:

1. It is already in 2NF.
2. It has no transitive dependency.
3. Non-key columns depend directly on the primary key.

Bad example:

```text
Employee
------------------------------------------------
employee_id | employee_name | department_id | department_name
```

Dependencies:

```text
employee_id → department_id
department_id → department_name
```

`department_name` depends on `department_id`, not directly on `employee_id`.

Better design:

```text
Employee
--------------------------------------
id | name | salary | department_id
```

```text
Department
----------------------------
id | department_name
```

### Interview Answer

> Normalization organizes data into related tables to reduce redundancy and prevent insert, update, and delete anomalies.

***

# 4. Transactions and ACID

## What Is a Transaction?

A **transaction** is a group of database operations treated as one logical unit.

Example: transferring ₹1,000 from Account A to Account B.

The transaction has two operations:

1. Deduct ₹1,000 from Account A.
2. Add ₹1,000 to Account B.

```sql
BEGIN;

UPDATE Account
SET balance = balance - 1000
WHERE account_id = 1;

UPDATE Account
SET balance = balance + 1000
WHERE account_id = 2;

COMMIT;
```

If an error occurs:

```sql
ROLLBACK;
```

***

## ACID Properties

ACID stands for:

```text
A → Atomicity
C → Consistency
I → Isolation
D → Durability
```

| Property | Meaning | Bank Transfer Example |
|---|---|---|
| Atomicity | All operations succeed or all are rolled back | Debit and credit both happen, or neither happens |
| Consistency | Database remains valid before and after the transaction | Rules and constraints remain valid |
| Isolation | Concurrent transactions do not interfere incorrectly | Two transfers do not corrupt the balance |
| Durability | Committed changes survive failures | Transfer remains after a system crash |

***

## Atomicity

Atomicity means **all or nothing**.

If ₹1,000 is deducted from Account A but the credit to Account B fails, the deduction must be reversed.

Correct behavior:

```text
Both operations succeed
OR
Both operations are rolled back
```

***

## Consistency

Consistency means the transaction preserves all database rules.

Examples:

- A foreign key must reference an existing record.
- An account balance should not become invalid.
- Required columns cannot become `NULL`.
- A transaction must not create invalid data.

***

## Isolation

Isolation means concurrent transactions should not interfere with each other.

Example:

- Account balance is ₹10,000.
- Transaction T1 withdraws ₹5,000.
- Transaction T2 withdraws ₹7,000 at the same time.

Without isolation, both transactions may read ₹10,000 and approve withdrawals incorrectly.

***

## Why Is Isolation Important?

Isolation is important because multiple users may access and modify the same data simultaneously.

It prevents:

- Dirty reads.
- Lost updates.
- Non-repeatable reads.
- Incorrect results from concurrent transactions.

### Interview Answer

> Isolation ensures that concurrent transactions do not see incomplete changes or incorrectly overwrite each other’s data.

***

## Durability

Durability means that once a transaction is committed, its changes remain saved even if:

- The system crashes.
- The database restarts.
- The power goes out.

***

# 5. SQL Schema

Use the following schema for practice:

```sql
CREATE TABLE Department (
    id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);
```

```sql
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2),
    department_id INT,

    FOREIGN KEY (department_id)
        REFERENCES Department(id)
);
```

Example data:

```sql
INSERT INTO Department (id, department_name)
VALUES
(1, 'Engineering'),
(2, 'HR'),
(3, 'Sales'),
(4, 'Finance');
```

```sql
INSERT INTO Employee (id, name, salary, department_id)
VALUES
(101, 'Arun', 60000, 1),
(102, 'Neha', 75000, 1),
(103, 'Ravi', 50000, 2),
(104, 'Asha', 90000, 3),
(105, 'Kiran', 65000, 3),
(106, 'Meera', 55000, NULL);
```

***

# 6. Basic SQL Queries

## Select All Employees

```sql
SELECT *
FROM Employee;
```

***

## Employees Earning More Than 50,000

```sql
SELECT *
FROM Employee
WHERE salary > 50000;
```

***

## Employees in a Particular Department

Using the department ID:

```sql
SELECT *
FROM Employee
WHERE department_id = 1;
```

Using the department name:

```sql
SELECT e.*
FROM Employee e
JOIN Department d
    ON e.department_id = d.id
WHERE d.department_name = 'Engineering';
```

***

## Sort Employees by Salary

Ascending order:

```sql
SELECT *
FROM Employee
ORDER BY salary ASC;
```

Descending order:

```sql
SELECT *
FROM Employee
ORDER BY salary DESC;
```

***

## Find the Highest Salary

```sql
SELECT MAX(salary) AS highest_salary
FROM Employee;
```

***

## Find the Average Salary

```sql
SELECT AVG(salary) AS average_salary
FROM Employee;
```

***

## Count Employees

```sql
SELECT COUNT(*) AS employee_count
FROM Employee;
```

***

## Count Employees in Each Department

```sql
SELECT department_id,
       COUNT(*) AS employee_count
FROM Employee
GROUP BY department_id;
```

Using department names:

```sql
SELECT d.department_name,
       COUNT(e.id) AS employee_count
FROM Department d
LEFT JOIN Employee e
    ON d.id = e.department_id
GROUP BY d.id, d.department_name;
```

Use `COUNT(e.id)` instead of `COUNT(*)` when using a `LEFT JOIN`. This correctly returns `0` for departments with no employees.

***

# 7. WHERE, GROUP BY, HAVING, ORDER BY

## WHERE

`WHERE` filters individual rows before grouping.

```sql
SELECT *
FROM Employee
WHERE salary > 50000;
```

***

## GROUP BY

`GROUP BY` combines rows into groups.

```sql
SELECT department_id,
       AVG(salary) AS average_salary
FROM Employee
GROUP BY department_id;
```

***

## HAVING

`HAVING` filters groups after aggregation.

```sql
SELECT department_id,
       COUNT(*) AS employee_count
FROM Employee
GROUP BY department_id
HAVING COUNT(*) > 5;
```

***

## ORDER BY

`ORDER BY` sorts the final result.

```sql
SELECT *
FROM Employee
ORDER BY salary DESC;
```

***

## Difference Between WHERE and HAVING

| WHERE | HAVING |
|---|---|
| Filters individual rows | Filters groups |
| Used before `GROUP BY` | Used after `GROUP BY` |
| Cannot normally use aggregate results | Used with aggregate results |
| Example: `salary > 50000` | Example: `COUNT(*) > 5` |

### Logical Query Order

```text
FROM
→ WHERE
→ GROUP BY
→ HAVING
→ SELECT
→ ORDER BY
```

***

## Find Departments Having More Than Five Employees

```sql
SELECT department_id,
       COUNT(*) AS employee_count
FROM Employee
GROUP BY department_id
HAVING COUNT(*) > 5;
```

With department names:

```sql
SELECT d.department_name,
       COUNT(e.id) AS employee_count
FROM Department d
JOIN Employee e
    ON d.id = e.department_id
GROUP BY d.id, d.department_name
HAVING COUNT(e.id) > 5;
```

***

# 8. SQL JOINs

## INNER JOIN

Returns only rows that match in both tables.

```sql
SELECT e.name,
       e.salary,
       d.department_name
FROM Employee e
INNER JOIN Department d
    ON e.department_id = d.id;
```

Employees without a department are excluded.

***

## LEFT JOIN

Returns all rows from the left table and matching rows from the right table.

```sql
SELECT e.name,
       d.department_name
FROM Employee e
LEFT JOIN Department d
    ON e.department_id = d.id;
```

Employees without a department are included with:

```text
department_name = NULL
```

***

## RIGHT JOIN

Returns all rows from the right table and matching rows from the left table.

```sql
SELECT e.name,
       d.department_name
FROM Employee e
RIGHT JOIN Department d
    ON e.department_id = d.id;
```

All departments are included, even departments without employees.

Equivalent `LEFT JOIN` version:

```sql
SELECT e.name,
       d.department_name
FROM Department d
LEFT JOIN Employee e
    ON d.id = e.department_id;
```

***

## FULL OUTER JOIN

Returns:

- Matching rows.
- Rows only from the left table.
- Rows only from the right table.

```sql
SELECT e.name,
       d.department_name
FROM Employee e
FULL OUTER JOIN Department d
    ON e.department_id = d.id;
```

Some databases, such as MySQL, do not directly support `FULL OUTER JOIN`.

***

## SELF JOIN

A self join joins a table with itself.

Assume:

```text
Employee
------------------------------------
id | name | salary | manager_id
```

Query:

```sql
SELECT e.name AS employee_name,
       m.name AS manager_name
FROM Employee e
LEFT JOIN Employee m
    ON e.manager_id = m.id;
```

Here:

- `e` represents the employee.
- `m` represents the manager.
- Both are aliases of the same table.

***

# 9. SQL JOIN Interview Questions

## Q1. Find Every Employee Along With Department Name

```sql
SELECT e.id,
       e.name,
       e.salary,
       d.department_name
FROM Employee e
INNER JOIN Department d
    ON e.department_id = d.id;
```

To include employees without departments:

```sql
SELECT e.id,
       e.name,
       e.salary,
       d.department_name
FROM Employee e
LEFT JOIN Department d
    ON e.department_id = d.id;
```

***

## Q2. Find Employees Who Do Not Belong to Any Department

```sql
SELECT e.*
FROM Employee e
LEFT JOIN Department d
    ON e.department_id = d.id
WHERE d.id IS NULL;
```

Alternative:

```sql
SELECT e.*
FROM Employee e
WHERE e.department_id IS NULL;
```

The first query also handles an invalid department reference if foreign-key enforcement is not enabled.

***

## Q3. Find the Number of Employees in Every Department

```sql
SELECT d.id,
       d.department_name,
       COUNT(e.id) AS employee_count
FROM Department d
LEFT JOIN Employee e
    ON d.id = e.department_id
GROUP BY d.id, d.department_name;
```

This includes departments with zero employees.

***

## Q4. Find Departments That Have No Employees

```sql
SELECT d.id,
       d.department_name
FROM Department d
LEFT JOIN Employee e
    ON d.id = e.department_id
WHERE e.id IS NULL;
```

Alternative using `NOT EXISTS`:

```sql
SELECT d.id,
       d.department_name
FROM Department d
WHERE NOT EXISTS (
    SELECT 1
    FROM Employee e
    WHERE e.department_id = d.id
);
```

***

# 10. SQL Interview Problems

## Q1. Second-Highest Distinct Salary

```sql
SELECT MAX(salary) AS second_highest_salary
FROM Employee
WHERE salary < (
    SELECT MAX(salary)
    FROM Employee
);
```

### How It Works

1. The inner query finds the highest salary.
2. The outer query removes that salary.
3. `MAX()` finds the next-highest salary.

Example:

```text
Salaries:
90000
75000
75000
65000
```

Result:

```text
75000
```

### Using DENSE_RANK

```sql
SELECT DISTINCT salary AS second_highest_salary
FROM (
    SELECT salary,
           DENSE_RANK() OVER (
               ORDER BY salary DESC
           ) AS salary_rank
    FROM Employee
) ranked
WHERE salary_rank = 2;
```

***

## Q2. Third-Highest Salary Using DENSE_RANK

```sql
SELECT DISTINCT salary AS third_highest_salary
FROM (
    SELECT salary,
           DENSE_RANK() OVER (
               ORDER BY salary DESC
           ) AS salary_rank
    FROM Employee
) ranked
WHERE salary_rank = 3;
```

Example:

```text
Salary   Rank
100000   1
90000    2
90000    2
80000    3
```

The third-highest distinct salary is:

```text
80000
```

### Why Use DENSE_RANK?

`DENSE_RANK()` gives equal salaries the same rank and does not skip rank numbers.

***

## Q3. Employees Earning Above the Company Average

```sql
SELECT *
FROM Employee
WHERE salary > (
    SELECT AVG(salary)
    FROM Employee
);
```

The subquery calculates the company-wide average salary.

The outer query returns employees earning more than that average.

***

## Q4. Find Duplicate Emails

Given:

```text
Person
----------------
id
email
```

Query:

```sql
SELECT email,
       COUNT(*) AS duplicate_count
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;
```

To ignore `NULL` emails:

```sql
SELECT email,
       COUNT(*) AS duplicate_count
FROM Person
WHERE email IS NOT NULL
GROUP BY email
HAVING COUNT(*) > 1;
```

To return complete rows:

```sql
SELECT *
FROM Person
WHERE email IN (
    SELECT email
    FROM Person
    WHERE email IS NOT NULL
    GROUP BY email
    HAVING COUNT(*) > 1
);
```

***

## Q5. Highest Salary Per Department

```sql
SELECT d.department_name,
       MAX(e.salary) AS highest_salary
FROM Department d
JOIN Employee e
    ON d.id = e.department_id
GROUP BY d.id, d.department_name;
```

Result format:

```text
department_name | highest_salary
-------------------------------
Engineering     | 75000
HR              | 50000
Sales           | 90000
```

### Find Employees Having the Highest Salary in Their Department

```sql
SELECT d.department_name,
       e.name,
       e.salary
FROM Employee e
JOIN Department d
    ON e.department_id = d.id
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM Employee e2
    WHERE e2.department_id = e.department_id
);
```

This returns all employees if multiple employees share the highest salary.

***

## Q6. Second-Highest Salary Per Department

```sql
SELECT d.department_name,
       ranked.name,
       ranked.salary AS second_highest_salary
FROM (
    SELECT e.id,
           e.name,
           e.salary,
           e.department_id,
           DENSE_RANK() OVER (
               PARTITION BY e.department_id
               ORDER BY e.salary DESC
           ) AS salary_rank
    FROM Employee e
) ranked
JOIN Department d
    ON ranked.department_id = d.id
WHERE ranked.salary_rank = 2;
```

### Explanation

```sql
PARTITION BY e.department_id
```

Creates a separate ranking for each department.

```sql
ORDER BY e.salary DESC
```

Ranks salaries from highest to lowest.

```sql
DENSE_RANK()
```

Gives equal salaries the same rank without skipping rank numbers.

Example:

```text
Engineering
-------------------------
Name   Salary   Rank
Neha   90000    1
Arun   80000    2
Ravi   80000    2
Kiran  70000    3
```

The second-highest distinct salary is `80000`, so both Arun and Ravi are returned.

***

# 11. Quick Interview Revision

## DBMS and RDBMS

- **DBMS:** Software used to manage data.
- **RDBMS:** A DBMS that stores data in related tables.
- **Main difference:** RDBMS supports relationships, keys, and stronger integrity constraints.

## Keys

- **Primary key:** Main unique identifier; cannot be `NULL`.
- **Foreign key:** Refers to a key in another table.
- **Candidate key:** Minimal key capable of uniquely identifying a row.
- **Super key:** Any key combination that uniquely identifies a row.
- **Composite key:** Key containing multiple columns.
- **Unique key:** Prevents duplicate values.

## Normalization

- **1NF:** Atomic values and no repeating groups.
- **2NF:** No partial dependency.
- **3NF:** No transitive dependency.
- **Purpose:** Reduce redundancy and prevent anomalies.

## ACID

- **Atomicity:** All or nothing.
- **Consistency:** Valid state to valid state.
- **Isolation:** Concurrent transactions do not interfere incorrectly.
- **Durability:** Committed data survives failures.

## SQL

- `WHERE` filters rows.
- `GROUP BY` creates groups.
- `HAVING` filters groups.
- `ORDER BY` sorts results.
- `INNER JOIN` returns matching rows.
- `LEFT JOIN` returns all left-side rows.
- `DENSE_RANK()` ranks values without gaps.