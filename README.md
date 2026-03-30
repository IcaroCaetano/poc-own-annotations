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