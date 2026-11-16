# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `infra/modules/network/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/network/outputs.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/compute/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/compute/outputs.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/database/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/modules/database/outputs.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/dev/main.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/dev/backend.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/dev/variables.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.
- `infra/environments/dev/outputs.tf` — El topic pide escribir Terraform: este .tf es el ejercicio, no scaffolding.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `infra` | `infra/` | practice | infra | Terraform (AWS) | Terraform |
| `api` | `api/` | chapter, support | server | Java | - |

## Orden de arranque

1. `cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=modules/compute init -backend=false && terraform -chdir=modules/database init -backend=false && terraform -chdir=modules/network init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=modules/compute validate && terraform -chdir=modules/database validate && terraform -chdir=modules/network validate` — componente `infra` (practice).
2. `cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `api` (chapter, support).

### Contratos entre componentes

- `api` expone http (api: http://localhost:8080):
  - `POST /api/orders`
  - `GET /api/orders/{id}`

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `api/src/main/java/com/orderservice/infrastructure/web/OrderController.java` — `CreateOrderRequest.getItems`: Se invoca `getItems` sobre `CreateOrderRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `api/src/main/java/com/orderservice/infrastructure/web/OrderController.java` — `CreateOrderRequest.getCustomerId`: Se invoca `getCustomerId` sobre `CreateOrderRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
(cd infra && terraform init -backend=false && terraform -chdir=environments/dev init -backend=false && terraform -chdir=modules/compute init -backend=false && terraform -chdir=modules/database init -backend=false && terraform -chdir=modules/network init -backend=false && terraform validate && terraform -chdir=environments/dev validate && terraform -chdir=modules/compute validate && terraform -chdir=modules/database validate && terraform -chdir=modules/network validate) && (cd api && mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package)
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Aprovisionar infraestructura con Terraform

### Misión / candidato
Versionar la infraestructura del servicio

### Reto
- Tema: Infraestructura como codigo para el servicio de ordenes
- Seniority: senior-l2
- Tipo: practical
- Título: Aprovisionamiento de Infraestructura con Terraform para el Servicio de Ordenes
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración Inicial de Terraform — objetivo: Configurar el entorno de Terraform y crear los modulos básicos para red, computo y base de datos. — entregable (NO resolver): Modulos de Terraform configurados y estado remoto en S3.
- Fase 2: Aprovisionamiento de la Infraestructura — objetivo: Utilizar los modulos de Terraform creados para aprovisionar la infraestructura AWS necesaria para el servicio de ordenes. — entregable (NO resolver): Infraestructura AWS aprovisionada y verificada.
- Fase 3: Versionado de la Infraestructura — objetivo: Versionar la infraestructura creada utilizando Terraform y asegurarte de que el estado remoto esté correctamente configurado en S3. — entregable (NO resolver): Infraestructura versionada y estado remoto en S3 configurado.
- Fase 4: Revisión y Optimización — objetivo: Revisar y optimizar la configuración de Terraform para asegurarte de que la infraestructura sea eficiente y escalable. — entregable (NO resolver): Configuración de Terraform optimizada y verificada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: infra/README.md ===
# Terraform AWS Infrastructure

## Overview
This repository contains Terraform configurations to provision AWS infrastructure for a multi-environment deployment. The setup follows a modular approach with separate modules for network, compute, and database resources.

## Structure
```
.
├── environments/
│   └── dev/                  # Environment-specific configurations
│       ├── main.tf           # Root module for the environment
│       ├── variables.tf      # Input variables for the environment
│       ├── outputs.tf        # Output values for the environment
│       ├── terraform.tfvars  # Variable values for the environment
│       └── backend.tf        # Backend configuration for remote state
├── modules/
│   ├── network/              # Networking module (VPC, subnets, etc.)
│   │   ├── main.tf
│   │   └── outputs.tf
│   ├── compute/              # Compute module (EC2, ECS, etc.)
│   │   ├── main.tf
│   │   └── outputs.tf
│   └── database/             # Database module (RDS, DynamoDB, etc.)
│       ├── main.tf
│       └── outputs.tf
├── versions.tf               # Terraform and provider versions
├── providers.tf              # Provider configurations
└── README.md                 # This file
```

## Prerequisites
- Terraform v1.5+ installed
- AWS CLI configured with appropriate credentials
- AWS account with permissions to create the specified resources

## Setup
1. Initialize Terraform:
   ```bash
   cd environments/dev
   terraform init
   ```

2. Review the execution plan:
   ```bash
   terraform plan
   ```

3. Apply the configuration:
   ```bash
   terraform apply
   ```

## Validation
After applying the configuration, verify the resources were created successfully:
- Check AWS Console for the created VPC, subnets, EC2 instances, and database
- Verify outputs from `terraform output` command

## Notes
- The `dev` environment is configured with sample values in `terraform.tfvars`
- Modify variables in `terraform.tfvars` for different environments
- Backend configuration uses S3 for remote state storage

// === ARCHIVO: infra/environments/dev/terraform.tfvars ===
// Terraform tfvars for AWS development environment
// Values should be adjusted based on specific AWS account and region requirements

aws_region = "us-east-1"
vpc_cidr_block = "10.0.0.0/16"
public_subnet_cidrs = ["10.0.1.0/24", "10.0.2.0/24"]
private_subnet_cidrs = ["10.0.3.0/24", "10.0.4.0/24"]
availability_zones = ["us-east-1a", "us-east-1b"]

instance_type = "t3.micro"
key_name = "dev-keypair"
ami_id = "ami-0c55b159cbfafe1f0"  # Amazon Linux 2 AMI (update as needed)

db_instance_class = "db.t3.micro"
db_name = "devdb"
db_username = "admin"
db_password = "securepassword123!"  # In production, use AWS Secrets Manager
db_allocated_storage = 20

tags = {
  Environment = "dev"
  Project     = "terraform-aws-project"
}

// === ARCHIVO: infra/versions.tf ===
terraform {
  required_version = ">= 1.9.0, < 2.0.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "= 5.100.0"
    }
  }
}

// === ARCHIVO: infra/providers.tf ===
provider "aws" {
  region = "us-east-1"
}

// === ARCHIVO: infra/modules/network/main.tf ===
# TODO(reto): Define la red para el servicio de órdenes
# Debes crear:
# - VPC con CIDR 10.0.0.0/16
# - Subnets públicas y privadas en al menos 2 AZs
# - Internet Gateway para las subnets públicas
# - NAT Gateway para las subnets privadas
# - Route Tables para ambas subnets
# - Security Groups para controlar el tráfico (ej: permitir HTTP/HTTPS desde internet, SSH solo desde IP específica)

variable "environment" {
  description = "Entorno de despliegue (dev, staging, prod)"
  type        = string
}

variable "vpc_cidr" {
  description = "CIDR block para la VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "public_subnet_cidrs" {
  description = "Lista de CIDRs para subnets públicas"
  type        = list(string)
  default     = ["10.0.1.0/24", "10.0.2.0/24"]
}

variable "private_subnet_cidrs" {
  description = "Lista de CIDRs para subnets privadas"
  type        = list(string)
  default     = ["10.0.3.0/24", "10.0.4.0/24"]
}

// === ARCHIVO: infra/modules/compute/main.tf ===
# TODO(reto): Define los recursos de cómputo para el servicio de órdenes
# Debes crear:
# - Launch Template para EC2 con AMI adecuada y tipo de instancia
# - Auto Scaling Group con mínimo 2 instancias en subnets privadas
# - Load Balancer (ALB) en subnets públicas con listener en puerto 80
# - Target Group para el ALB apuntando a las instancias EC2
# - Security Group para EC2 permitiendo tráfico solo desde el ALB

variable "environment" {
  description = "Entorno de despliegue (dev, staging, prod)"
  type        = string
}

variable "instance_type" {
  description = "Tipo de instancia EC2"
  type        = string
  default     = "t3.micro"
}

variable "min_size" {
  description = "Número mínimo de instancias en el ASG"
  type        = number
  default     = 2
}

variable "max_size" {
  description = "Número máximo de instancias en el ASG"
  type        = number
  default     = 4
}

variable "desired_capacity" {
  description = "Capacidad deseada del ASG"
  type        = number
  default     = 2
}

// === ARCHIVO: infra/modules/database/main.tf ===
# TODO(reto): Define la base de datos para el servicio de órdenes
# Debes crear:
# - Instancia RDS PostgreSQL con multi-AZ para alta disponibilidad
# - Subnet Group para RDS en subnets privadas
# - Security Group permitiendo tráfico solo desde las instancias EC2
# - Parámetros de configuración para optimizar rendimiento
# - Backup automático con ventana de mantenimiento

variable "environment" {
  description = "Entorno de despliegue (dev, staging, prod)"
  type        = string
}

variable "db_instance_class" {
  description = "Clase de instancia para RDS"
  type        = string
  default     = "db.t3.micro"
}

variable "db_name" {
  description = "Nombre de la base de datos"
  type        = string
  default     = "ordersdb"
}

variable "db_username" {
  description = "Usuario maestro de la base de datos"
  type        = string
  default     = "admin"
}

variable "db_password" {
  description = "Contraseña para el usuario maestro (debe generarse con random_password)"
  type        = string
  sensitive   = true
}

variable "allocated_storage" {
  description = "Almacenamiento asignado en GB"
  type        = number
  default     = 20
}

// === ARCHIVO: infra/modules/network/outputs.tf ===
# Outputs del módulo de red
# Superficie de práctica: completar con los valores correctos

output "vpc_id" {
  description = "ID de la VPC creada"
  value       = null # TODO(reto)
}

output "public_subnet_ids" {
  description = "IDs de las subredes públicas"
  value       = null # TODO(reto)
}

output "private_subnet_ids" {
  description = "IDs de las subredes privadas"
  value       = null # TODO(reto)
}

output "security_group_id" {
  description = "ID del grupo de seguridad"
  value       = null # TODO(reto)
}

// === ARCHIVO: infra/modules/compute/outputs.tf ===
# Outputs del módulo de computo
# Superficie de práctica: completar con los valores correctos

output "instance_ids" {
  description = "IDs de las instancias EC2"
  value       = null # TODO(reto)
}

output "load_balancer_dns" {
  description = "DNS del balanceador de carga"
  value       = null # TODO(reto)
}

// === ARCHIVO: infra/modules/database/outputs.tf ===
# Outputs del módulo de base de datos
# Superficie de práctica: completar con los valores correctos

output "db_instance_endpoint" {
  description = "Endpoint de la instancia de base de datos"
  value       = null # TODO(reto)
}

output "db_instance_username" {
  description = "Usuario de la base de datos"
  value       = null # TODO(reto)
}

// === ARCHIVO: infra/environments/dev/main.tf ===
# Llama a los módulos de red, compute y base de datos para aprovisionar la infraestructura del entorno de desarrollo
# SUPERFICIE DE PRACTICA - El estudiante debe implementar la llamada a los módulos

module "network" {
  source = "../../modules/network"

  environment = var.environment
  vpc_cidr = var.vpc_cidr
  public_subnet_cidrs = var.public_subnet_cidrs
  private_subnet_cidrs = var.private_subnet_cidrs
}

module "database" {
  source = "../../modules/database"

  environment = var.environment
  db_instance_class = var.db_instance_class
  db_name = var.db_name
  db_username = var.db_username
  db_password = var.db_password
  allocated_storage = var.allocated_storage
}

module "compute" {
  source = "../../modules/compute"

  environment = var.environment
  instance_type = var.instance_type
  min_size = var.min_size
  max_size = var.max_size
  desired_capacity = var.desired_capacity
}

# Output que expone los recursos creados para referencia
output "vpc_id" {
  value = module.network.vpc_id
}

output "load_balancer_dns" {
  value = module.compute.load_balancer_dns
}

output "db_endpoint" {
  value = module.database.db_instance_endpoint
}

// === ARCHIVO: infra/environments/dev/backend.tf ===
# Configuración del backend remoto para almacenar el estado de Terraform en S3
# SUPERFICIE DE PRACTICA - El estudiante debe configurar el backend

terraform {
  backend "s3" {
    bucket         = "dev-terraform-state-bucket"
    key            = "orders-service/dev/terraform.tfstate"
    region         = "us-east-1"
    encrypt        = true
    dynamodb_table = "dev-terraform-state-lock"
  }
}

// === ARCHIVO: infra/environments/dev/variables.tf ===
# Variables específicas del entorno de desarrollo
# SUPERFICIE DE PRACTICA - El estudiante debe declarar las variables necesarias

variable "environment" {
  description = "Nombre del entorno"
  type        = string
  default     = "dev"
}

variable "vpc_cidr" {
  description = "CIDR de la VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "public_subnet_cidrs" {
  description = "CIDRs de las subredes públicas"
  type        = list(string)
  default     = ["10.0.1.0/24", "10.0.2.0/24"]
}

variable "private_subnet_cidrs" {
  description = "CIDRs de las subredes privadas"
  type        = list(string)
  default     = ["10.0.3.0/24", "10.0.4.0/24"]
}

variable "instance_type" {
  description = "Tipo de instancia EC2"
  type        = string
  default     = "t3.micro"
}

variable "min_size" {
  description = "Tamaño mínimo del Auto Scaling Group"
  type        = number
  default     = 2
}

variable "max_size" {
  description = "Tamaño máximo del Auto Scaling Group"
  type        = number
  default     = 4
}

variable "desired_capacity" {
  description = "Capacidad deseada del Auto Scaling Group"
  type        = number
  default     = 2
}

variable "db_instance_class" {
  description = "Clase de instancia de base de datos"
  type        = string
  default     = "db.t3.micro"
}

variable "db_name" {
  description = "Nombre de la base de datos"
  type        = string
  default     = "ordersdb"
}

variable "db_username" {
  description = "Usuario de la base de datos"
  type        = string
  default     = "admin"
}

variable "db_password" {
  description = "Contraseña de la base de datos"
  type        = string
  sensitive   = true
}

variable "allocated_storage" {
  description = "Almacenamiento asignado para la base de datos en GB"
  type        = number
  default     = 20
}

// === ARCHIVO: infra/environments/dev/outputs.tf ===
# Outputs del entorno de desarrollo
# Superficie de práctica: definir los outputs que exponen los módulos

# TODO(reto): Completar los outputs del entorno de desarrollo
# Los outputs deben exponer:
# - VPC ID y subnets (red)
# - IDs de instancias EC2 (computo)
# - Endpoint de la base de datos (database)
# - DNS del balanceador de carga (computo)

# Ejemplo de estructura esperada:

// === ARCHIVO: api/pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-sns</artifactId>
            <version>1.12.797</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-java-sdk-sqs</artifactId>
            <version>1.12.797</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: api/src/main/java/com/orderservice/domain/Order.java ===
package com.orderservice.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<OrderItem> items;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order(List<OrderItem> items, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.items = List.copyOf(items);
        this.customerId = customerId;
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public enum OrderStatus {
        CREATED, PROCESSING, COMPLETED, CANCELLED
    }

    public static class OrderItem {
        private String productId;
        private int quantity;
        private double price;

        public OrderItem(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}

// === ARCHIVO: api/src/main/java/com/orderservice/domain/OrderRepository.java ===
package com.orderservice.domain;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String id);
}

// === ARCHIVO: api/src/main/java/com/orderservice/application/OrderService.java ===
package com.orderservice.application;

import com.orderservice.domain.Order;
import com.orderservice.domain.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<OrderItemRequest> items, String customerId) {
        List<Order.OrderItem> orderItems = items.stream()
                .map(item -> new Order.OrderItem(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(orderItems, customerId);
        return orderRepository.save(order);
    }

    public Order getOrder(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }

    public static class OrderItemRequest {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemRequest(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: api/src/main/java/com/orderservice/infrastructure/persistence/JpaOrderRepository.java ===
package com.orderservice.infrastructure.persistence;

import com.orderservice.domain.Order;
import com.orderservice.domain.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaOrderRepository implements OrderRepository {
    private final SpringDataOrderRepository springDataOrderRepository;

    public JpaOrderRepository(SpringDataOrderRepository springDataOrderRepository) {
        this.springDataOrderRepository = springDataOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = OrderEntity.fromDomain(order);
        OrderEntity savedEntity = springDataOrderRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Order> findById(String id) {
        return springDataOrderRepository.findById(id)
                .map(OrderEntity::toDomain);
    }
}

// === ARCHIVO: api/src/main/java/com/orderservice/infrastructure/persistence/OrderEntity.java ===
package com.orderservice.infrastructure.persistence;

import com.orderservice.domain.Order;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItemEntity> items;

    private String customerId;

    @Enumerated(EnumType.STRING)
    private Order.OrderStatus status;

    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(String id, List<OrderItemEntity> items, String customerId, Order.OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.items = items;
        this.customerId = customerId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static OrderEntity fromDomain(Order order) {
        List<OrderItemEntity> itemEntities = order.getItems().stream()
                .map(item -> new OrderItemEntity(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        return new OrderEntity(
                order.getId(),
                itemEntities,
                order.getCustomerId(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

    public Order toDomain() {
        List<Order.OrderItem> orderItems = items.stream()
                .map(item -> new Order.OrderItem(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(orderItems, customerId);
        order.setStatus(status);
        return order;
    }

    public String getId() {
        return id;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Embeddable
    public static class OrderItemEntity {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemEntity() {
        }

        public OrderItemEntity(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}

// === ARCHIVO: api/src/main/java/com/orderservice/infrastructure/persistence/SpringDataOrderRepository.java ===
package com.orderservice.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String> {
}

// === ARCHIVO: api/src/main/java/com/orderservice/infrastructure/web/OrderController.java ===
package com.orderservice.infrastructure.web;

import com.orderservice.application.OrderService;
import com.orderservice.application.OrderService.OrderItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        List<OrderItemRequest> itemRequests = request.getItems().stream()
                .map(dto -> new OrderItemRequest(dto.getProductId(), dto.getQuantity(), dto.getPrice()))
                .collect(Collectors.toList());

        var order = orderService.createOrder(itemRequests, request.getCustomerId());
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {
        var order = orderService.getOrder(id);
        return ResponseEntity.ok(toResponse(order));
    }

    private OrderResponse toResponse(com.orderservice.domain.Order order) {
        List<OrderItemResponse> itemResponses = order.getItems().stream()
                .map(item -> new OrderItemResponse(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                itemResponses,
                order.getCustomerId(),
                order.getStatus().name(),
                order.getCreatedAt().toString()
        );
    }

    public static class CreateOrderRequest {
        private List<OrderItemRequestDto> items;
        private String customerId;

        public CreateOrderRequest() {
        }

        public CreateOrderRequest(List<OrderItemRequestDto> items, String customerId) {
            this.items = items;
            this.customerId = customerId;
        }

        public List<OrderItemRequestDto> getItems() {
            return items;
        }

        public void setItems(List<OrderItemRequestDto> items) {
            this.items = items;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
    }

    public static class OrderItemRequestDto {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemRequestDto() {
        }

        public OrderItemRequestDto(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class OrderResponse {
        private String id;
        private List<OrderItemResponse> items;
        private String customerId;
        private String status;
        private String createdAt;

        public OrderResponse() {
        }

        public OrderResponse(String id, List<OrderItemResponse> items, String customerId, String status, String createdAt) {
            this.id = id;
            this.items = items;
            this.customerId = customerId;
            this.status = status;
            this.createdAt = createdAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<OrderItemResponse> getItems() {
            return items;
        }

        public void setItems(List<OrderItemResponse> items) {
            this.items = items;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }

    public static class OrderItemResponse {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemResponse() {
        }

        public OrderItemResponse(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}

// === ARCHIVO: api/src/main/resources/application.yml ===
spring:
  application:
    name: order-service
  datasource:
    url: ${DATABASE_URL:jdbc:postgresql://localhost:5432/ordersdb}
    username: ${DATABASE_USERNAME:postgres}
    password: ${DATABASE_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    open-in-view: false

server:
  port: ${SERVER_PORT:8080}
  servlet:
    context-path: /
  compression:
    enabled: true

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      show-details: always
  metrics:
    export:
      prometheus:
        enabled: true

aws:
  region: ${AWS_REGION:us-east-1}
  sqs:
    queue-name: ${SQS_QUEUE_NAME:order-events-queue}
    endpoint: ${SQS_ENDPOINT:}
  sns:
    topic-arn: ${SNS_TOPIC_ARN:}
    endpoint: ${SNS_ENDPOINT:}

logging:
  level:
    root: INFO
    com.orderservice: DEBUG
    org.springframework.web: DEBUG
    org.hibernate.SQL: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

// === ARCHIVO: api/src/main/java/com/orderservice/infrastructure/config/AwsConfig.java ===
package com.orderservice.infrastructure.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.sqs.endpoint:}")
    private String sqsEndpoint;

    @Value("${aws.sns.endpoint:}")
    private String snsEndpoint;

    @Value("${AWS_ACCESS_KEY_ID:}")
    private String accessKeyId;

    @Value("${AWS_SECRET_ACCESS_KEY:}")
    private String secretAccessKey;

    @Bean
    public AmazonSQS amazonSQS() {
        AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard();

        if (sqsEndpoint != null && !sqsEndpoint.isEmpty()) {
            builder.withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(sqsEndpoint, awsRegion));
        } else {
            builder.withRegion(awsRegion);
        }

        if (accessKeyId != null && !accessKeyId.isEmpty() && secretAccessKey != null && !secretAccessKey.isEmpty()) {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
            builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        }

        return builder.build();
    }

    @Bean
    public AmazonSNS amazonSNS() {
        AmazonSNSClientBuilder builder = AmazonSNSClientBuilder.standard();

        if (snsEndpoint != null && !snsEndpoint.isEmpty()) {
            builder.withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(snsEndpoint, awsRegion));
        } else {
            builder.withRegion(awsRegion);
        }

        if (accessKeyId != null && !accessKeyId.isEmpty() && secretAccessKey != null && !secretAccessKey.isEmpty()) {
            BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
            builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        }

        return builder.build();
    }
}

// === ARCHIVO: api/src/main/java/com/orderservice/OrderserviceApplication.java ===
package com.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.orderservice.domain",
    "com.orderservice.application",
    "com.orderservice.infrastructure"
})
public class OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }
}
```
