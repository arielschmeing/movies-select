INSERT INTO user_account (id, name, email, password, created_at, updated_at, activated) 
VALUES (
  '00000000-0000-0000-0000-000000000001',
  'Administrador',
  'admin@example.com',
  '$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqhN8/LewY5NU7xl82YdZy.',
  NOW(),
  NOW(),
  TRUE
)
ON CONFLICT (email) DO NOTHING;


INSERT INTO user_permission (id, role, user_id)
VALUES (
  '00000000-0000-0000-0000-000000000002',
  'ADMIN',
  '00000000-0000-0000-0000-000000000001'
)
ON CONFLICT (role, user_id) DO NOTHING;