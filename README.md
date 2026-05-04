# 🗄️ Ejercicio16 [ConexionOracleMaven] — Consultas Filtradas por Parámetros

Este proyecto Java gestionado con Maven establece una conexión con una base de datos Oracle para realizar consultas dinámicas sobre la tabla `empleado`. La aplicación permite filtrar registros basándose en un criterio de entrada proporcionado por el usuario en tiempo de ejecución.

## 📋 Descripción del Proyecto
El propósito de este programa es demostrar la recuperación de información específica utilizando **sentencias preparadas con parámetros**. El sistema solicita al usuario el identificador de un departamento y devuelve una lista detallada de todos los empleados asociados a dicho departamento, incluyendo su nombre, salario e ID.

## 🎯 Funcionalidades Principales
Al ejecutarse, el programa realiza las siguientes acciones:
*   **Interacción con el Usuario**: Solicita mediante consola el `idDep` (ID del departamento) a consultar.
*   **Consulta Parametrizada**: Ejecuta la sentencia SQL `SELECT nombre, salario, emp_id FROM empleado WHERE dep_id = ?` de forma segura.
*   **Mapeo de Resultados**: Recorre el `ResultSet` y extrae la información de cada empleado que cumple con el criterio de filtrado.
*   **Visualización Detallada**: Muestra los resultados en consola utilizando un formato de flechas (`-->`) para separar los atributos del empleado.

## 🏗️ Estructura del Proyecto
El proyecto mantiene la organización modular estándar de Maven:

```text
Ejercicio16 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Proveedor de configuración JDBC
│       │       └── ☕ Main.java            # Lógica de consulta filtrada por parámetro
│       └── 📁 resources/
│           └── 📄 db.properties           # Credenciales de acceso externas
│
├── 📁 target/                             # Binarios generados por Maven
├── 📄 pom.xml                             # Gestión de dependencias (OJDBC11)
└── 📄 README.md                           # Documentación del proyecto
```

## 📄 Formato del Archivo de Entrada
El archivo `src/main/resources/db.properties` debe estar configurado para permitir la conexión:
```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=tu_usuario
db.password=tu_contraseña
```

## 🚀 Compilación y Ejecución
### Requisitos
*   Java JDK 17 o superior.
*   Maven 3.8+ instalado.
*   Base de datos Oracle con la tabla `empleado` y registros asociados a departamentos.

### Comandos de Terminal
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 🔧 Características Técnicas Implementadas
*   **Sentencias Preparadas**: Uso de `PreparedStatement` para pasar parámetros dinámicos de forma segura y eficiente.
*   **Captura de Datos**: Uso de la clase `Scanner` para recibir la entrada del usuario.
*   **Gestión de Recursos**: Implementación de `try-with-resources` para garantizar el cierre automático de `Connection` y `PreparedStatement`.
*   **Manejo de SQL**: Gestión de `SQLException` para reportar fallos de conectividad o errores en la consulta.

## 🎮 Ejemplo de Uso Visual

**Interacción en Consola:**
```text
Indique el id del departamento
> 10
Nombre del empleado: Judith --> salario: 3500.0 --> id: 1
Nombre del empleado: Sergio --> salario: 2355.15 --> id: 10
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 16 - Consultas Dinámicas con Parámetros en Oracle JDBC*