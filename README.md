<h1 align="center">📦 Sistema de Ventas - Base de Datos</h1>

<h3 align="center">Producto_db</h3>

---

<h2 align="center">🗄️ Creación de Base de Datos</h2>

```sql
CREATE DATABASE Producto_db;
USE Producto_db;
```

---

<h2 align="center">📋 Tabla: producto</h2>

```sql
CREATE TABLE producto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL,
    precio DECIMAL(38,2) NOT NULL,
    PRIMARY KEY (id)
);
```

---

<h2 align="center">🧾 Tabla: venta</h2>

```sql
CREATE TABLE venta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    total DECIMAL(38,2) NOT NULL,
    PRIMARY KEY (id)
);
```

---

<h2 align="center">🧮 Tabla: detalle_venta</h2>

```sql
CREATE TABLE detalle_venta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cantidad INTEGER NOT NULL,
    subtotal DECIMAL(38,2) NOT NULL,
    producto_id BIGINT NOT NULL,
    venta_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (producto_id) REFERENCES producto(id),
    FOREIGN KEY (venta_id) REFERENCES venta(id)
);
```

---

<h2 align="center">🔎 Consultas Básicas</h2>

```sql
-- Ver productos
SELECT * FROM producto;

-- Ver ventas
SELECT * FROM venta;

-- Ver detalles de venta
SELECT * FROM detalle_venta;
```

---

<h2 align="center">🔗 Consulta con JOIN</h2>

```sql
SELECT dv.id,
       dv.cantidad,
       dv.subtotal,
       p.nombre AS producto,
       v.total AS total_venta
FROM detalle_venta dv
JOIN producto p ON dv.producto_id = p.id
JOIN venta v ON dv.venta_id = v.id;
```

---

<h3 align="center">🚀 API REST desarrollada con Spring Boot + MySQL</h3>
