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