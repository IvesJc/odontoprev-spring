<h1>🎯 Adaptive Dialogs</h1>  
<p>👥 Integrantes:  </p>
<p>Ellie de Oliveira  </p>
<p>RM: 552824  </p>
<p>🎯 Responsável pela integração dos serviços de backend com a API. </p> 

<p>Ives Jundi Chiba  </p>
<p>RM: 553243  </p>
<p>💻 Responsável pelo desenvolvimento das funcionalidades de comunicação com a API.  </p>

<p>Nathalia Comeron Freire  </p>
<p>RM: 553233  </p>
<p>💻 Responsável pelo desenvolvimento e consumo da API em Kotlin  </p>

<h2>🚀 Como Rodar a Aplicação  </h2>
<p>Para rodar a aplicação, basta clonar a aplicação e utilizar os endpoints fornecidos para obter o retorno das consultas na API. <p>A recomendação é utilizar o Swagger para ter uma visualização clara de todos os endpoints e todas as entidades do projeto  <p>Certifique-se de que as dependências e variáveis de ambiente estejam configuradas corretamente.

<h2>🛠 Diagrama da Aplicação  </h2>
<p>📄 Nome da Aplicação: Adaptive Dialogs  </p>
<p>👥 Integrantes e Atividades:  </p>
<p>Ellie de Oliveira – Responsável pela integração backend com a API  </p>
<p>Ives Jundi Chiba – Responsável pelo desenvolvimento da comunicação com a API  </p>
<img src="https://github.com/user-attachments/assets/a8c4757c-cf6e-4162-8203-628adb1876cb">
<img src="https://github.com/user-attachments/assets/d6d3b589-fe7c-4f4a-b45d-ecb55c9ce7a9">
<img src="https://github.com/user-attachments/assets/75f278d6-1ddc-472b-96ea-a4b16fd1ec58">
<img src="https://github.com/user-attachments/assets/7be29a53-18a4-4190-b63c-7fdb1fb9f0a5">  
<p>A arquitetura se tornou complexa com o avanço do projeto. Mas basicamente o Beneficiário é o centro do sistema, e a partir dele(a) é possível entender que o mesmo pode ter Endereço, Plano Odontológico, Missões dentro do App.</p>  

<h3>Swagger</h3>
<img src="https://github.com/user-attachments/assets/7646bc6a-ccd5-4f86-9f6a-0399aee766fa">
<p>Já dentro do Swagger será possível acessar a todas as Entidades e seus devidos endpoints</p>
<ul>
  <li>Endereco</li>
  <li>Missao</li>
  <li>Tipo Recompensa</li>
  <li>Programa Relacionamento Status</li>
  <li>Plano Odontologico</li>
  <li>Tipo Plano Odontologico</li>
  <li>Recompensa</li>
  <li>Servico</li>
  <li>Beneficiario</li>
  <li>Prestador Servico</li>
  <li>Tipo Servico</li>
  <li>Tipo Missao</li>
  <li>Sinistro</li>
  <li>Empresa Contratante</li>
  <li>Rede Credenciada</li>
</ul>

# API - Endpoints do MVC

Este documento fornece informações sobre os endpoints disponíveis no sistema de gerenciamento de Endereços e Empresas Contratantes.

## Endpoints

### **1. Endereços**

#### **GET /enderecos**
- **Descrição**: Lista todos os endereços cadastrados no sistema.

#### **GET /enderecos/{id}**
- **Descrição**: Obtém os detalhes de um endereço específico pelo ID.
- **Parâmetros**:
  - `id`: ID do endereço a ser recuperado.

#### **POST /enderecos/salvar**
- **Descrição**: Cria um novo endereço.
- **Corpo da requisição**:
    - `rua`: Rua do endereço.
    - `numero`: Número do endereço.
    - `cidade`: Cidade do endereço.
    - `estado`: Estado do endereço.
    - `cep`: CEP do endereço.
    - `complemento`: Complemento do endereço (opcional).

#### **POST /enderecos/{id}/editar**
- **Descrição**: Atualiza um endereço existente.
- **Parâmetros**:
  - `id`: ID do endereço a ser atualizado.
- **Corpo da requisição**:
    - `rua`: Rua do endereço.
    - `numero`: Número do endereço.
    - `cidade`: Cidade do endereço.
    - `estado`: Estado do endereço.
    - `cep`: CEP do endereço.
    - `complemento`: Complemento do endereço (opcional).

#### **POST /enderecos/{id}/deletar**
- **Descrição**: Deleta um endereço existente.
- **Parâmetros**:
  - `id`: ID do endereço a ser deletado.

### **2. Empresas Contratantes**

#### **GET /empresas**
- **Descrição**: Lista todas as empresas contratantes cadastradas no sistema.

#### **GET /empresas/{id}**
- **Descrição**: Obtém os detalhes de uma empresa contratante específica pelo ID.
- **Parâmetros**: 
  - `id`: ID da empresa contratante a ser recuperada.

#### **POST /empresas/salvar**
- **Descrição**: Cria uma nova empresa contratante.
- **Corpo da requisição**:
    - `nome`: Nome da empresa contratante.
    - `cnpj`: CNPJ da empresa contratante.
    - `numeroContrato`: Número do contrato da empresa contratante.

#### **POST /empresas/{id}/editar**
- **Descrição**: Atualiza uma empresa contratante existente.
- **Parâmetros**:
  - `id`: ID da empresa contratante a ser atualizada.
- **Corpo da requisição**:
    - `nome`: Nome da empresa contratante.
    - `cnpj`: CNPJ da empresa contratante.
    - `numeroContrato`: Número do contrato da empresa contratante.

#### **POST /empresas/{id}/deletar**
- **Descrição**: Deleta uma empresa contratante existente.
- **Parâmetros**:
  - `id`: ID da empresa contratante a ser deletada.

---

# Vídeo Apresentação

https://youtu.be/cpYf2MAuyQI
