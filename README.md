-- ============================================
-- CREAR BASE DE DATOS
-- ============================================

CREATE DATABASE Producto_db;
USE Producto_db;

-- ============================================
-- TABLA: producto
-- ============================================

CREATE TABLE producto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL,
    precio DECIMAL(38,2) NOT NULL,
    PRIMARY KEY (id)
);

-- ============================================
-- TABLA: venta
-- ============================================

CREATE TABLE venta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    total DECIMAL(38,2) NOT NULL,
    PRIMARY KEY (id)
);

-- ============================================
-- TABLA: detalle_venta
-- ============================================

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
