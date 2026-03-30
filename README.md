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

### 6️⃣ Parameter Annotations

Bound external data to method parameters:

public void execute(@Param("userId") String id) {}

✔ Mapped values dynamically from a Map
✔ Built a mini argument resolver

### 7️⃣ Repeatable Annotations

Enabled multiple annotations of the same type:

@Tag("java")
@Tag("reflection")

✔ Implemented using @Repeatable
✔ Processed with:

getAnnotationsByType(Tag.class);

### 8️⃣ Meta-Annotations

Created composed annotations:

@Note("Critical class")
@Important
public @interface Critical {}

✔ Built logic to resolve meta-annotations manually


### 9️⃣ Annotation Inheritance

Used:

@Inherited

✔ Allowed subclasses to inherit annotations from parent classes

### 🔟 Modern Java Features

Used Java 21 capabilities like:

Pattern Matching:
if (value instanceof String str)

✔ Cleaner and safer type handling

## 🧠 Key Concepts Learned

- Reflection API (Class, Field, Method, Parameter)
- Runtime annotation processing
- Dynamic method invocation
- Metadata-driven design
- Separation of concerns
- Mini-framework architecture

#### ⚠️ Important Notes

- Reflection bypasses encapsulation (setAccessible(true))
- Can impact performance if overused
- Should be used carefully in production systems


### 🎯 Conclusion

This POC demonstrates how to:

- Build dynamic and extensible systems
- Use annotations to drive behavior
- Recreate core ideas behind major Java frameworks
