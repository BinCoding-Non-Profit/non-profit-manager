ALTER TABLE public.user drop column id, add column id serial PRIMARY KEY;
ALTER TABLE public.user ADD CONSTRAINT unique_username UNIQUE (username);

CREATE TABLE IF NOT EXISTS public.volunteer (
  id serial PRIMARY KEY,
  email VARCHAR(45) NOT NULL UNIQUE,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  phone VARCHAR(10) NULL,
  availability VARCHAR(45) NULL,
  interests VARCHAR(45) NULL,
  zipcode VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.event (
    id serial PRIMARY KEY,
    organization_id INT NOT NULL,
    title VARCHAR(45) NULL,
    description TEXT NULL,
    header_image VARCHAR(45) NULL,
    address VARCHAR(45) NULL,
    state VARCHAR(45) NULL,
    zipcode VARCHAR(45) NULL,
    date_time TIMESTAMP NULL,
    invited INT NULL,
    going INT NULL,
    type VARCHAR(15) NULL,
    max_allowed INT NULL,
    contact_phone VARCHAR(10) NULL,
    contact_email VARCHAR(45) NULL,
    start_time TIME NULL,
    end_time TIME NULL,
    date DATE NULL,
    price FLOAT NULL,
    close_ticket_sales_date TIMESTAMP NULL,
    status VARCHAR(10) NULL,
    CONSTRAINT fk_event_organization1
      FOREIGN KEY (organization_id)
          REFERENCES public.organization (id)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.user_has_organization (
id serial PRIMARY KEY,
user_id INT NOT NULL,
organization_id INT NOT NULL,
CONSTRAINT fk_user_has_organization_user
    FOREIGN KEY (user_id)
        REFERENCES public.user (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
CONSTRAINT fk_user_has_organization_organization1
    FOREIGN KEY (organization_id)
        REFERENCES public.organization (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.organization_has_volunteer (
    id serial PRIMARY KEY,
    organization_id INT NOT NULL,
    volunteer_id INT NOT NULL,
    CONSTRAINT fk_organization_has_volunteer_organization1
     FOREIGN KEY (organization_id)
         REFERENCES public.organization (id)
         ON DELETE NO ACTION
         ON UPDATE NO ACTION,
    CONSTRAINT fk_organization_has_volunteer_volunteer
     FOREIGN KEY (volunteer_id)
         REFERENCES public.volunteer (id)
         ON DELETE NO ACTION
         ON UPDATE NO ACTION
);