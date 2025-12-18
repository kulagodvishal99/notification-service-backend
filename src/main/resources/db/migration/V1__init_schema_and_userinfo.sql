-- Use placeholders for schema and owner
CREATE SCHEMA IF NOT EXISTS notification_system AUTHORIZATION flyway_user;

-- Table to store user info (snake_case to match SQL conventions)
CREATE TABLE IF NOT EXISTS notification_system.user_info (
	user_id			VARCHAR(64) PRIMARY KEY,
	first_name		VARCHAR(100) NOT NULL,
	last_name		VARCHAR(100),
	phone_number	VARCHAR(32),
	email_id		VARCHAR(255),
	street			VARCHAR(255),
	city			VARCHAR(100),
	state			VARCHAR(100),
	country			VARCHAR(100),
	country_code	VARCHAR(8)
);

-- Helpful indexes
CREATE INDEX IF NOT EXISTS idx_user_info_email ON ${schema}.user_info (lower(email_id));
CREATE INDEX IF NOT EXISTS idx_user_info_phone ON ${schema}.user_info (phone_number);

-- Grant schema and data privileges to application user
GRANT USAGE ON SCHEMA ${schema} TO ${application_db_user};
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA ${schema} TO ${application_db_user};
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA ${schema} TO ${application_db_user};

-- Ensure future objects created by flyway_user in this schema are granted to app user
ALTER DEFAULT PRIVILEGES FOR ROLE flyway_user IN SCHEMA ${schema}
	GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO ${application_db_user};
ALTER DEFAULT PRIVILEGES FOR ROLE flyway_user IN SCHEMA ${schema}
	GRANT USAGE, SELECT, UPDATE ON SEQUENCES TO ${application_db_user};


