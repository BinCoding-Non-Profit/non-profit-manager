CREATE TABLE IF NOT EXISTS public.organization (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  state VARCHAR(45) NULL,
  zip VARCHAR(45) NULL,
  contact VARCHAR(45) NULL,
  primary_contact VARCHAR(45) NULL,
  primary_contact_email VARCHAR(45) NULL,
  primary_contact_phone VARCHAR(45) NULL,
  PRIMARY KEY (id)
)
