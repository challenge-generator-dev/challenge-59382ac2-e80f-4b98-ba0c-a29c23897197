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