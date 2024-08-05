# Projeto de Banco de Dados com PostgreSQL e pgAdmin

Este projeto configura um banco de dados PostgreSQL e uma interface gráfica pgAdmin usando Docker. Siga as instruções abaixo para configurar e conectar-se ao pgAdmin.

## Pré-requisitos

- Docker e Docker Compose instalados.

## Estrutura do Projeto

O projeto utiliza o Docker Compose para orquestrar dois serviços:

1. **PostgreSQL**: Banco de dados PostgreSQL.
2. **pgAdmin**: Interface gráfica para gerenciar o PostgreSQL.

## Configuração

### 1. Clonar o Repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_DIRETORIO>
```

## 2. Construir e Iniciar os Serviços

Certifique-se de que você está no diretório onde o arquivo docker-compose.yml está localizado e execute:

```
docker-compose up -d
```

Isso iniciará os contêineres do PostgreSQL e do pgAdmin em segundo plano.

## Conectar ao pgAdmin
### Acesso ao pgAdmin

1. Abra um navegador e acesse http://localhost:5050.
2. Login:
     - Email: admin@example.com
     - Senha: admin

## Adicionar uma Nova Conexão de Servidor

1. No painel do pgAdmin, clique em "Add New Server" (Adicionar Novo Servidor).
2. Na aba "General" (Geral), insira um nome para a conexão, por exemplo, PostgreSQL Local.
3. Na aba "Connection" (Conexão), preencha os seguintes campos:
   - Host name/address: db
   - Port: 5433
   - Maintenance database: postgres
   - Username: postgres
   - Password: admin
4. Clique em "Save" (Salvar).