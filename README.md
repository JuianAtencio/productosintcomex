# Productos Intcomex API

API REST para la gestión de productos y categorías, desarrollada con Spring Boot, PostgreSQL, Docker y Arquitectura Hexagonal.

## Características

- CRUD de productos y categorías
- Carga masiva de productos
- Paginación y filtrado de productos
- Seguridad con JWT
- Documentación Swagger UI
- Despliegue con Docker y Docker Compose

## Requisitos

- Java 17+
- Maven 3.8+
- Docker y Docker Compose
- PostgreSQL
- JUnit, Mockito

## Instalación y ejecución local

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/JuianAtencio/productosintcomex.git
   cd productosintcomex
   ```

2. **Configura la base de datos en `src/main/resources/application.properties`.**

3. **Levanta los servicios con Docker Compose:**
   ```sh
   docker-compose up -d
   ```

4. **Accede a la API:**
   - API: [http://localhost:8080](http://localhost:8080)
   - Swagger UI: http://localhost:8080/swagger-ui/index.html

## Endpoints principales

- `POST   /auth/login` — Autenticación y obtención de token JWT
- `POST   /Category/` — Crear categoría
- `GET    /Category/` — Listar categorías
- `POST   /Product/` — Crear producto
- `GET    /Product/` — Listar productos (paginado y filtrado)
- `POST   /Product/bulk` — Carga masiva de productos
- `GET    /Product/{id}` — Detalle de producto
- `DELETE /Product/{id}` — Borrar producto
- `PUT    /Product/{id}/price` — Actualizar precio de producto

## Pruebas

Ejecuta las pruebas con:

```sh
mvn test
```

## Despliegue en AWS EC2

1. Sube el proyecto a la instancia EC2.
2. Instala Docker y Docker Compose.
3. Ejecuta `docker-compose up -d`.

---

**Autor:**  
Julian Atencio
