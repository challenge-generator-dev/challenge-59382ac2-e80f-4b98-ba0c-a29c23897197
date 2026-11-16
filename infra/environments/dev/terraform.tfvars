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