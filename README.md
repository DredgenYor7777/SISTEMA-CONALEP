# SISTEMA-CONALEP

## Sistema de Inventarios y Control de Libros del CONALEP 📚

Este proyecto es un sistema diseñado específicamente para el control de inventarios y la gestión de préstamos de libros en bibliotecas del CONALEP. Ofrece una interfaz intuitiva para registrar, consultar y actualizar información relacionada con los libros disponibles, así como gestionar préstamos de manera eficiente.

---

## 📝 Características

### Gestión de inventarios:
- Registrar, actualizar y eliminar libros.
- Visualizar información detallada de los libros disponibles.

### Control de préstamos:
- Registrar préstamos de libros a usuarios.
- Seguimiento del estado de los préstamos (devueltos, en préstamo).


### Reportes:
- Generar reportes en Excel de inventarios y préstamos para análisis y auditorías.

---

## 🚀 Instalación

Sigue estos pasos para instalar y ejecutar el sistema:

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/DredgenYor7777/SISTEMA-CONALEP.git
Configura la base de datos:

Ve a la carpeta Bd/ del proyecto dentro de la rama master, tambien podras encontrar todo el código del proyecto.
Importa el archivo conalep_version1.sql a tu servidor MySQL usando tu herramienta favorita (por ejemplo, phpMyAdmin o línea de comandos).
Comando para importar desde la terminal:

bash
Copiar código
mysql -u tu_usuario -p tu_base_de_datos < Bd/conalep_version1.sql
