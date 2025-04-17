```markdown
# Student Course Management System

A full-stack web application for managing course enrollment, built using **Spring Boot** for the backend and standard HTML/CSS/JavaScript for the frontend.

## 🚀 Features

- 🧑‍🎓 User role selection (Student / Instructor)
- 🔐 Secure login form
- 📦 Spring Boot backend with RESTful API
- 🌐 Static frontend served from `src/main/resources/static`
- 🎨 Responsive UI with custom styling and Google Fonts
- 🌍 CORS configuration for cross-origin frontend development

---

## 📁 Project Structure

```
springboot-student-course-management/
├── src/
│   ├── main/
│   │   ├── java/                # Java source code
│   │   │   └── ...              # Controllers, services, configs
│   │   └── resources/
│   │       ├── static/          # HTML, CSS, JS files
│   │       │   ├── index.html
│   │       │   ├── css/
│   │       │   │   └── style.css
│   │       │   └── js/
│   │       │       └── script.js
│   │       └── application.properties
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🧑‍💻 Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Maven**
- **HTML5 + CSS3 + JavaScript**
- **Google Fonts**
- **MySQL (optional for backend integration)**

---

## 🛠️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/MuhammedNiyas2003/Course-Enrollment.git
cd Course-Enrollment
```

### 2. Run the Spring Boot app

Make sure Java and Maven are installed.

```bash
./mvnw spring-boot:run
```

The app will be available at: [http://localhost:8080](http://localhost:8080)

---

## 🔧 CORS Configuration

The project includes a CORS configuration (`WebConfig.java`) that allows frontend development from `http://127.0.0.1:5500` (Live Server):

```java
registry.addMapping("/**")
        .allowedOrigins("http://127.0.0.1:5500")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*");
```

---

## ✅ TODO / Improvements

- [ ] Connect to a MySQL database
- [ ] Implement full user authentication
- [ ] Add registration and course management pages
- [ ] Build a React or Thymeleaf-based frontend (optional)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 🙌 Acknowledgements

- Inspired by student management systems and hands-on backend practice.
- Fonts from [Google Fonts](https://fonts.google.com/)

---

## 💬 Contact

**Muhammed Niyas**  
📧 [muhammedniyas.dev@gmail.com](mailto:muhammedniyas.dev@gmail.com)  
🔗 [GitHub](https://github.com/MuhammedNiyas2003)

```

---

### ✅ To Add it:

1. Save it as `README.md` in your project root
2. Add & push:

```bash
git add README.md
git commit -m "Add project README"
git push
```
