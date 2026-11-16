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