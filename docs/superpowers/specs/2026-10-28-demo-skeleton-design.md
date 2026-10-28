# Demo Skeleton Design

## Intent

Create a small Java project for practicing Git operations manually in IntelliJ
IDEA. The project must open reliably, build with Maven, run from IDEA, and remain
free of business logic.

## Scope

- Maven project targeting Java 17.
- Package root: `cn.edu.hbnu.studyseat`.
- Layer packages: `domain`, `service`, `repository`, `exception`, and `config`.
- Minimal application entry point and real configuration-file loading.
- One JUnit 5 test covering configuration loading.
- MySQL schema placeholder and project documentation.
- Git is deliberately not initialized by this task.

## Non-goals

- No business entities, service implementations, database access, or UI.
- No Spring Boot, Gradle, Maven wrapper, or external service dependency.
- No repository initialization, commit, remote, or push.

## Approaches

1. Maven + Java SE + JUnit 5 (selected): matches the current coursework stack
   and keeps setup small.
2. Spring Boot: useful for later web practice, but adds framework behavior that
   is outside a minimal skeleton.
3. Gradle: smaller build scripts, but inconsistent with the current project.

## Structure

```text
E:\demo-skeleton
├── .gitignore
├── README.md
├── pom.xml
├── db/schema.sql
├── docs/
│   ├── acceptance.md
│   ├── design.md
│   ├── development.md
│   └── team-tasks.md
└── src/
    ├── main/
    │   ├── java/cn/edu/hbnu/studyseat/
    │   │   ├── DemoApplication.java
    │   │   ├── config/AppConfig.java
    │   │   ├── domain/package-info.java
    │   │   ├── exception/package-info.java
    │   │   ├── repository/package-info.java
    │   │   └── service/package-info.java
    │   └── resources/application.properties
    └── test/java/cn/edu/hbnu/studyseat/config/AppConfigTest.java
```

## Decisions

- The project owns its independent Maven build and documentation.
- Configuration loading is real behavior and therefore receives a unit test.
- The database script creates an empty database only, avoiding fake business
  tables.
- Git practice starts after project creation: users choose when to run
  `git init`, add a remote, stage, commit, and push.

## Verification

- `mvn test` exits successfully.
- Running `DemoApplication` prints the configured application name.
- `E:\demo-skeleton\.git` does not exist after creation.
