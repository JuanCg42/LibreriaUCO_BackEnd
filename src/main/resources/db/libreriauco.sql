-- Script de creacion de tablas para la base de datos libreriauco (SQL Server).
-- Es idempotente: se puede ejecutar varias veces sin borrar datos existentes.
-- Ejecutar con la base libreriauco seleccionada.

IF OBJECT_ID('dbo.Pais', 'U') IS NULL
BEGIN
	CREATE TABLE dbo.Pais (
		id     UNIQUEIDENTIFIER NOT NULL,
		nombre NVARCHAR(50)     NOT NULL,
		CONSTRAINT PK_Pais PRIMARY KEY (id),
		CONSTRAINT UQ_Pais_nombre UNIQUE (nombre)
	);
END
GO

IF OBJECT_ID('dbo.Departamento', 'U') IS NULL
BEGIN
	CREATE TABLE dbo.Departamento (
		id     UNIQUEIDENTIFIER NOT NULL,
		nombre NVARCHAR(50)     NOT NULL,
		pais   UNIQUEIDENTIFIER NOT NULL,
		CONSTRAINT PK_Departamento PRIMARY KEY (id),
		CONSTRAINT FK_Departamento_Pais FOREIGN KEY (pais) REFERENCES dbo.Pais (id),
		CONSTRAINT UQ_Departamento_pais_nombre UNIQUE (pais, nombre)
	);
END
GO

IF OBJECT_ID('dbo.Ciudad', 'U') IS NULL
BEGIN
	CREATE TABLE dbo.Ciudad (
		id           UNIQUEIDENTIFIER NOT NULL,
		nombre       NVARCHAR(50)     NOT NULL,
		departamento UNIQUEIDENTIFIER NOT NULL,
		CONSTRAINT PK_Ciudad PRIMARY KEY (id),
		CONSTRAINT FK_Ciudad_Departamento FOREIGN KEY (departamento) REFERENCES dbo.Departamento (id),
		CONSTRAINT UQ_Ciudad_departamento_nombre UNIQUE (departamento, nombre)
	);
END
GO
