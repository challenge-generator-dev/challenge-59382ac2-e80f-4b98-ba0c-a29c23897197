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