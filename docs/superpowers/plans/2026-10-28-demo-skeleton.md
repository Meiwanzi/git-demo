# Demo Skeleton Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Create a buildable Java 17 Maven project skeleton that can be opened in
IntelliJ IDEA and used to practice Git manually.

**Architecture:** A single Maven module with a minimal application entry point,
one configuration-loading class, and empty layer packages for future work.

**Tech Stack:** Java 17, Maven, JUnit 5.

**Spec:** `docs/superpowers/specs/2026-10-28-demo-skeleton-design.md`

## Global Constraints

- Project root: `E:\demo-skeleton`.
- Package root: `cn.edu.hbnu.studyseat`.
- Java release: 17.
- Source encoding: UTF-8.
- Do not run `git init` or create a Git commit.
- Do not add business functionality.

## Review Focus

- Missing or blank `app.name` configuration must fail clearly.
- The project must build in a clean Maven invocation.
- IDEA must recognize normal Maven source and resource directories.
- Documentation must describe manual Git steps without performing them.
- Database setup must not invent application tables.

---

### Task 1: Build Configuration and Loading Test

**Files:**
- Create: `pom.xml`
- Create: `.gitignore`
- Create: `src/main/resources/application.properties`
- Create: `src/test/java/cn/edu/hbnu/studyseat/config/AppConfigTest.java`

**Interfaces:**
- Produces: tests for `AppConfig.load(InputStream)` and
  `AppConfig.applicationName()`.

- [ ] **Step 1: Write the failing configuration test**

Test valid loading and blank-name rejection with literal expectations.

- [ ] **Step 2: Run the focused test and verify RED**

Run: `mvn -q -Dtest=AppConfigTest test`

Expected: compilation fails because `AppConfig` does not exist.

- [ ] **Step 3: Implement minimal configuration loading**

Create `AppConfig` with the two interfaces named above. Missing and blank
`app.name` values raise `IllegalArgumentException("app.name must not be blank")`.

- [ ] **Step 4: Run the focused test and verify GREEN**

Run: `mvn -q -Dtest=AppConfigTest test`

Expected: command exits with code 0.

### Task 2: Entry Point, Layers, and Documentation

**Files:**
- Create: `src/main/java/cn/edu/hbnu/studyseat/DemoApplication.java`
- Create: `src/main/java/cn/edu/hbnu/studyseat/{config,domain,exception,repository,service}/package-info.java`
- Create: `db/schema.sql`
- Create: `README.md`
- Create: `docs/design.md`
- Create: `docs/development.md`
- Create: `docs/acceptance.md`
- Create: `docs/team-tasks.md`

**Interfaces:**
- Consumes: `AppConfig.load(InputStream)` and
  `AppConfig.applicationName()`.
- Produces: `DemoApplication.main(String[])`.

- [ ] **Step 1: Implement the entry point**

Load `/application.properties`, build `AppConfig`, and print
`Demo application started: <app.name>`.

- [ ] **Step 2: Add empty package markers and database placeholder**

Each layer package contains a documented `package-info.java`; `schema.sql`
creates the `demo_skeleton` database without business tables.

- [ ] **Step 3: Add project documentation**

Document IDEA import, run and test commands, layer responsibilities, and manual
Git initialization/staging/commit/push steps.

- [ ] **Step 4: Run the full verification**

Run: `mvn test`

Expected: `BUILD SUCCESS` and no test failures.

- [ ] **Step 5: Verify the project is not a Git repository**

Run: `if exist E:\demo-skeleton\.git (exit /b 1) else (exit /b 0)`

Expected: command exits with code 0.
