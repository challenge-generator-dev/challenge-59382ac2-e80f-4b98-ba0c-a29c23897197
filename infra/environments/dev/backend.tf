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