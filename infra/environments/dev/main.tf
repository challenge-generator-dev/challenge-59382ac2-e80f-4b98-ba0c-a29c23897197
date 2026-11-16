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