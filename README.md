# Portfolio CMS

A **full-stack personal portfolio CMS** built with **Spring Boot (Java)**, **Angular**, **PostgreSQL**, **Docker**, and **GitHub Actions**.  
The system enables dynamic project and portfolio management with categories, blogs, certifications, and a modern, responsive UI.

---

## 🚀 Features

- **Backend (Spring Boot)**
  - REST APIs for Users, Projects, Blogs, Certifications, Categories, Contacts
  - JWT Authentication & Role-Based Access Control
  - PostgreSQL Database with Spring Data JPA
  - Unit & Integration Tests (JUnit, Mockito)
  - Swagger / OpenAPI Documentation

- **Frontend (Angular)**
  - Responsive Portfolio UI (Projects, Resume, Certifications, Contact Form)
  - Dark/Light Mode Support
  - Skills Visualization (Charts/Icons)
  - Admin Dashboard for content management
  - Contact form with email/notification integration

- **DevOps**
  - Dockerized backend & frontend for portability
  - CI/CD with GitHub Actions
  - Future-ready for AWS deployment (EC2, S3, RDS, CloudWatch)

- **Documentation**
  - System Architecture Diagram
  - Database ERD
  - Wireframes & UI Prototypes
  - Project Charter & Technical Docs

---

## 📂 Project Structure

portfolio-cms/
│── backend/ # Spring Boot backend
│ ├── src/main/java/com/portfolio/cms/Application.java
│ ├── pom.xml
│ └── Dockerfile
│
│── frontend/ # Angular frontend
│ ├── src/
│ ├── angular.json
│ └── Dockerfile
│
│── docs/ # Documentation
│ ├── architecture-diagram.png
│ ├── database-erd.png
│ └── wireframes.png
│
│── .github/workflows/ # CI/CD pipelines
│ └── ci.yml
│
│── .gitignore
│── .gitattributes
│── LICENSE
│── README.md


---

## 🛠️ Tech Stack

- **Frontend:** Angular, TypeScript, SCSS  
- **Backend:** Java 17, Spring Boot, Spring Security, JPA/Hibernate  
- **Database:** PostgreSQL  
- **DevOps:** Docker, GitHub Actions, AWS (future deployment)  
- **Testing:** JUnit 5, Mockito, Jasmine/Karma (Angular)  

---

## 📈 Development Workflow

This project is developed using **Agile Scrum**, tracked in **Jira**, and synced with GitHub.  
Here’s the flow:

1. **Plan & Track (Jira)**
   - Epics, Sprints, and Stories are created in Jira.
   - Each Story has a priority (High/Medium/Low) and dependencies.
   - Example: `PCMS-12 Implement Repositories` must be completed before `PCMS-13 JWT Auth`.

2. **Branching Strategy (GitHub)**
   - `main` → Production-ready code
   - `dev` → Integration branch for all features
   - `feature/*` → Individual feature branches (e.g., `feature/auth-service`)

   ```bash
   git checkout -b feature/auth-service
3. **Development**
   - Backend: Implement APIs (Spring Boot + PostgreSQL).
   - Frontend: Build Angular components & services.
   - Follow TDD where possible (JUnit, Mockito for backend, Jasmine/Karma for frontend).
   - Document changes in Jira (move issues from To Do → In Progress → Done).
4. **Code Review & Merge**
   - Push feature branches to GitHub.
   - Open Pull Requests → Review → Merge into dev.
   - Jira issue transitions automatically update if GitHub-Jira integration is enabled.
5. **CI/CD (GitHub Actions)**
   - On each PR/commit → Run build + tests for backend & frontend.
   - On merge to main → Trigger deployment pipeline.
   - Example pipeline:
        → `mvn clean install` (backend)
        → `ng build --prod` (frontend)
        → Docker image build & push
6. **Deployment**
   - Local: Run via docker-compose up.
   - Cloud: Deploy on AWS (EC2 for backend, S3 + CloudFront for frontend, RDS for PostgreSQL).

7. **Monitoring & Feedback**
   - Logs & metrics tracked with CloudWatch / Splunk.
   - Jira captures bugs & enhancements → fed back into new sprints.

## 📋 How to Run Locally
   - Prerequisites
        → Java 17+
        → Node.js 18+
        → Docker & Docker Compose
        → PostgreSQL (local or Dockerized)
   - Clone Repo
        → `git clone https://github.com/<your-username>/portfolio-cms.git`
        → `cd portfolio-cms`
## Roadmap

    ✅ Setup repo structure & documentation

    ✅ Backend Core (Entities, Auth, Repositories)

    ✅ Frontend Core (Angular setup + UI components)

    ✅ CI/CD integration

    ✅ AWS Deployment

    ✅ Testimonials, LinkedIn API integration, Contact scheduling           

## 📜 License
    This project is licensed under the MIT License – see LICENSE for details.