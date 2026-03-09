# 📚 Guru API (Backend)

Backend API untuk sistem **Manajemen Data Guru** menggunakan **Spring Boot**.

API ini menyediakan endpoint untuk:

- Login menggunakan **Basic Authentication**
- Menampilkan daftar guru
- Menambahkan data guru
- Mengupdate data guru
- Mengubah status guru (Aktif / Non-Aktif)

⚠️ Catatan:  
Sesuai requirement, **tidak ada fitur delete data guru**.

---

# ⚙️ Teknologi yang Digunakan

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Maven

---

# 🗂️ Struktur Project

```
guru-api
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   └── TeacherController.java
│
├── dto
│   ├── ApiResponse.java
│   └── TeacherDto.java
│
├── entity
│   ├── User.java
│   └── Teacher.java
│
├── repository
│   ├── UserRepository.java
│   └── TeacherRepository.java
│
├── service
│   ├── TeacherService.java
│   └── CustomUserDetailsService.java
│
└── GuruApiApplication.java
```

---

# 🛠️ Setup Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/username/guru-api.git
cd guru-api
```

---

## 2️⃣ Konfigurasi Database

Edit file:

```
src/main/resources/application.properties
```

Contoh konfigurasi:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/guru_db
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8083
```

---

# 🗄️ Struktur Database

## Table Users

Digunakan untuk **login admin ke sistem**.

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(255),
    role VARCHAR(50)
);
```

Contoh data login:

```sql
INSERT INTO users (username, password, role)
VALUES ('admin', '$2a$10$encryptedpassword', 'ADMIN');
```

---

## Table Teachers

Digunakan untuk menyimpan **data guru**.

```sql
CREATE TABLE teachers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    subject VARCHAR(100),
    active BOOLEAN
);
```

---

# 🔐 Authentication

API menggunakan **Basic Authentication** dari Spring Security.

Contoh header request:

```
Authorization: Basic base64(username:password)
```

Contoh:

```
Authorization: Basic YWRtaW46YWRtaW4xMjM=
```

---

# 📡 Endpoint API

## 1️⃣ Get All Teachers

```
GET /api/teachers
```

Response:

```json
{
  "status": true,
  "message": "Data berhasil didapatkan",
  "data": [
    {
      "id": 1,
      "name": "Budi Santoso",
      "subject": "Matematika",
      "active": true
    }
  ]
}
```

---

## 2️⃣ Create Teacher

```
POST /api/teachers
```

Body Request:

```json
{
  "name": "Andi Saputra",
  "subject": "Fisika",
  "active": true
}
```

---

## 3️⃣ Update Teacher

```
PUT /api/teachers/{id}
```

Body Request:

```json
{
  "name": "Andi Saputra",
  "subject": "Fisika",
  "active": false
}
```

---

# 🔄 Alur Sistem

1. User melakukan login menggunakan username dan password.
2. Backend melakukan autentikasi menggunakan **Spring Security**.
3. Jika login berhasil, user dapat mengakses endpoint `/api/teachers`.
4. User dapat:
   - Melihat daftar guru
   - Menambahkan guru
   - Mengupdate data guru
   - Mengubah status aktif/non-aktif.

---

# 🚫 Batasan Sistem

Sesuai requirement tugas:

- ❌ Tidak ada endpoint delete
- ❌ Tidak ada penghapusan data guru
- ✔ Hanya **Create, Read, Update**

---

# 🚀 Menjalankan Backend

Jalankan menggunakan Maven:

```bash
mvn spring-boot:run
```

atau

```bash
./mvnw spring-boot:run
```

API akan berjalan di:

```
http://localhost:8083
```

---

# 👤 Author

Backend ini dibuat menggunakan:

- Spring Boot REST API
- Spring Security
- MySQL
