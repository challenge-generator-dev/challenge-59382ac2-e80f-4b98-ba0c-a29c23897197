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