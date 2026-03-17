# AGENTS.md - FinalWinter2026

## Snapshot
- Spring Boot backend scaffold with Maven (`pom.xml`) and Java 24 compiler target.
- Current Java package root is `com.finalreview.booktrackerapi` (`src/main/java/com/finalreview/booktrackerapi`).
- Domain model placeholders exist: `Book`, `User`, `Review`, `ReadingList`, `Follow`.
- No controllers/services/repositories yet; this is model-first scaffolding.

## Architecture Reality (Current State)
- `src/main/java/com/finalreview/booktrackerapi/*.java` contains empty classes only.
- `BookTrackerApplication.java` has no `main` method and no `@SpringBootApplication` annotation.
- Consequence: `mvn spring-boot:run` currently fails with "Unable to find a suitable main class".
- Data/storage intent is visible in dependencies: Spring Data JPA + MySQL + H2.

## Data and Integration Points
- Runtime config is centralized in `src/main/resources/application.properties`.
- Active datasource is MySQL RDS via `spring.datasource.url=jdbc:mysql://...`.
- Driver is explicit: `spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`.
- H2 is present as a runtime dependency in `pom.xml` but not wired via profile-specific properties yet.
- API documentation dependency is present (`springdoc-openapi-starter-webmvc-ui`), but no endpoints exist to document.

## Build, Test, and Local Workflow
- Use Maven directly (no wrapper files in repo root):
  - `mvn clean package -DskipTests`
  - `mvn test`
  - `mvn compile`
- `Makefile` shortcuts:
  - `make package` builds jar via Maven.
  - `make build` builds Docker image `jkells/bookapp:latest` for `linux/amd64`.
  - `make run` expects a `docker compose` setup.
- `Dockerfile` runs `target/*.jar` on Eclipse Temurin 24.

## Conventions to Follow in This Repo
- Keep new Java code under `com.finalreview.booktrackerapi` (matches current code + `pom.xml` groupId).
- When adding app startup, implement it in `BookTrackerApplication.java` rather than creating a second entrypoint.
- If introducing layers, place them in subpackages under `com.finalreview.booktrackerapi` (for example `controller`, `service`, `repository`, `entity`).
- Treat `application.properties` as environment-specific and avoid committing real credentials.

## AI Instruction Sources (Single Required Glob)
- Glob searched: `**/{.github/copilot-instructions.md,AGENT.md,AGENTS.md,CLAUDE.md,.cursorrules,.windsurfrules,.clinerules,.cursor/rules/**,.windsurf/rules/**,.clinerules/**,README.md}`
- Match found: `AGENTS.md` only.
- No additional repository-local AI rule files were discovered.
