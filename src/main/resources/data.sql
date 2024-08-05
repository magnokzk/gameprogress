CREATE TABLE IF NOT EXISTS jogos.users (
    id SERIAL PRIMARY KEY,               -- Campo identificador único com auto incremento
    username VARCHAR(50) UNIQUE NOT NULL,  -- Nome de usuário único e obrigatório
    password VARCHAR(255) NOT NULL,        -- Senha do usuário
    nome_completo VARCHAR(255) NOT NULL,   -- Nome completo do usuário
    data_nascimento DATE NOT NULL,         -- Data de nascimento do usuário
    email VARCHAR(255) UNIQUE NOT NULL,    -- Email único e obrigatório
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Data de criação (automático)
    data_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP -- Data de atualização
);