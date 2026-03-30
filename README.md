# poc-own-annotations

## 🧠 Java Reflection & Annotations POC (Java 21)

### 📌 Overview

This project is a Proof of Concept (POC) built with Java 21 to explore the power of:

- Custom Annotations
- Reflection API
- Runtime Processing
- Dynamic Behavior

The goal is to understand how frameworks like Spring, Hibernate, and JUnit work under the hood.


## 🚀 Features Implemented

### 1️⃣ Custom Annotations

Created custom annotations such as:

- @Note → add metadata
- @Important → mark critical elements
- @Run → mark executable methods
- @Order → control execution order
- @NotNull, @MaxLength → validation rules
- @Param → bind method parameters

## 🚀 Features Implemented

### 2️⃣ Reflection Basics

- Access classes, fields, and methods dynamically
- Instantiate objects at runtime:

````java
clazz.getDeclaredConstructor().newInstance();
````

- Execute methods dynamically:

````java
method.invoke(instance);
````


### 3️⃣ Field Validation Engine

Implemented a simple validation system using annotations:

- @NotNull

- @MaxLength(10)

private String name;

✔ Validates:

Null values
String length

✔ Uses:

Field
setAccessible(true)
Annotation processing

### 4️⃣ Method Execution Engine

Created a mini execution engine:

- @Run
public void execute() {}

✔ Finds methods with @Run
✔ Executes them automatically via Reflection

### 5️⃣ Execution Order with @Order

Controlled method execution order:

@Run
@Order(1)
public void job1() {}

@Run
@Order(2)
public void job2() {}

✔ Sorted execution using Comparator
✔ Methods without order run last