create database SegMaster;
use SegMaster;

-- -----------------------------------------------------
-- Tabela Estados
-- -----------------------------------------------------
CREATE TABLE estados (
	id_estado INT NOT NULL AUTO_INCREMENT,
	desc_estado VARCHAR(100),
	sigla VARCHAR(2),
	PRIMARY KEY (id_estado));

-- -----------------------------------------------------
-- Tabela Municipios
-- -----------------------------------------------------
CREATE TABLE municipios (
	id_municipio INT NOT NULL AUTO_INCREMENT,
	id_estado INT,
	descricao VARCHAR(100),
	PRIMARY KEY (id_municipio),
    
	CONSTRAINT fk_cod_estado_municipio
		FOREIGN KEY (id_estado)
		REFERENCES estados (id_estado)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Endereco
-- -----------------------------------------------------
CREATE TABLE endereco (
	id_endereco INT NOT NULL AUTO_INCREMENT,
	id_estado INT,
	id_municipio INT,
	bairro VARCHAR(100),
	logradouro VARCHAR(200),
	numero VARCHAR(20),
	complemento VARCHAR(200),
	cep VARCHAR(8),
	PRIMARY KEY (id_endereco),
	
    CONSTRAINT fk_id_estado_endereco
		FOREIGN KEY (id_estado)
		REFERENCES estados(id_estado)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	
    CONSTRAINT fk_id_municipio_endereco
		FOREIGN KEY (id_municipio)
		REFERENCES municipios(id_municipio)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Contabilidade
-- -----------------------------------------------------
CREATE TABLE contabilidade (
	id_contabilidade INT NOT NULL AUTO_INCREMENT,
	nome_contabilidade VARCHAR(100),
	cnpj VARCHAR(14),
	ies_parceiro TINYINT(1),
	cod_parceria INT,
	id_endereco INT,
	PRIMARY KEY (id_contabilidade),
    
	CONSTRAINT fk_id_endereco_contabilidade
		FOREIGN KEY (id_endereco)
		REFERENCES endereco(id_endereco)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Contador
-- -----------------------------------------------------
CREATE TABLE contador (
	id_contador INT NOT NULL AUTO_INCREMENT,
	nome_contador VARCHAR(200),
	PRIMARY KEY (id_contador));

-- -----------------------------------------------------
-- Tabela Tipo Cliente
-- -----------------------------------------------------
CREATE TABLE tipo_cliente (
	id_tipo_cliente INT NOT NULL AUTO_INCREMENT,
	desc_tipo_cliente VARCHAR(100),
	PRIMARY KEY (id_tipo_cliente));

-- -----------------------------------------------------
-- Tabela Cliente
-- -----------------------------------------------------
CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
	nome_cliente VARCHAR(200),
	id_tipo_cliente INT,
	id_endereco INT,
	PRIMARY KEY (id_cliente),
    
	CONSTRAINT fk_id_tipo_cliente
		FOREIGN KEY (id_tipo_cliente)
		REFERENCES tipo_cliente(id_tipo_cliente)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_id_endereco_cliente
		FOREIGN KEY (id_endereco)
		REFERENCES endereco (id_endereco)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Pedido
-- -----------------------------------------------------
CREATE TABLE pedido (
	id_pedido INT NOT NULL AUTO_INCREMENT,
	id_cliente INT,
	dt_expedicao DATE,
	id_contador INT,
	valor_bruto DOUBLE,
	PRIMARY KEY (id_pedido),
    
	CONSTRAINT fk_id_cliente
		FOREIGN KEY (id_cliente)
		REFERENCES cliente(id_cliente)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	
    CONSTRAINT fk_id_contador
		FOREIGN KEY (id_contador)
		REFERENCES contador(id_contador)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Tabela Tipo Certificado
-- -----------------------------------------------------
CREATE TABLE tipo_certificado (
	id_tipo_certificado INT NOT NULL AUTO_INCREMENT,
	desc_tipo_certificado VARCHAR(100),
	PRIMARY KEY (id_tipo_certificado));

-- -----------------------------------------------------
-- Table Categoria Certificado
-- -----------------------------------------------------
CREATE TABLE categoria_certificado (
	id_categoria_certificado INT NOT NULL AUTO_INCREMENT,
	desc_categoria_certificado VARCHAR(100),
	PRIMARY KEY (id_categoria_certificado));

-- -----------------------------------------------------
-- Tabela Hardware
-- -----------------------------------------------------
CREATE TABLE hardware (
	id_hardware INT NOT NULL AUTO_INCREMENT,
	desc_hardware VARCHAR(100),
	PRIMARY KEY (id_hardware));

-- -----------------------------------------------------
-- Tabela Hierarquia
-- -----------------------------------------------------
CREATE TABLE hierarquia (
	id_hierarquia INT NOT NULL AUTO_INCREMENT,
	desc_hierarquia VARCHAR(100),
	PRIMARY KEY (id_hierarquia));

-- -----------------------------------------------------
-- Tablela Certificado
-- -----------------------------------------------------
CREATE TABLE certificado (
	id_certificado INT NOT NULL AUTO_INCREMENT,
	id_tipo_certificado INT,
	id_categoria_certificado INT,
	id_hardware INT,
    id_hierarquia INT,
	id_pedido INT,
	num_certificado VARCHAR(100),
	data_validade DATE,
	PRIMARY KEY (id_certificado),

	CONSTRAINT fk_id_pedido_certificado
		FOREIGN KEY (id_pedido)
		REFERENCES pedido(id_pedido)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_id_tipo_certificado
		FOREIGN KEY (id_tipo_certificado)
		REFERENCES tipo_certificado(id_tipo_certificado)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
  
	CONSTRAINT fk_id_categoria_certificado
		FOREIGN KEY (id_categoria_certificado)
		REFERENCES categoria_certificado(id_categoria_certificado)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
  
	CONSTRAINT fk_id_hardware
		FOREIGN KEY (id_hardware)
		REFERENCES hardware (id_hardware)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	
    CONSTRAINT fk_id_hierarquia
		FOREIGN KEY (id_hierarquia)
		REFERENCES hierarquia(id_hierarquia)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Status Comissao
-- -----------------------------------------------------
CREATE TABLE status_comissao (
	id_status_comissao INT NOT NULL AUTO_INCREMENT,
	desc_status_comissao VARCHAR(100),
	PRIMARY KEY (id_status_comissao));

-- -----------------------------------------------------
-- Tabela Forma Pagamento
-- -----------------------------------------------------
CREATE TABLE forma_pagamento (
	id_forma_pagamento INT NOT NULL AUTO_INCREMENT,
	desc_forma_pagamento VARCHAR(100),
	PRIMARY KEY (id_forma_pagamento));

-- -----------------------------------------------------
-- Tabela Comissao
-- -----------------------------------------------------
CREATE TABLE comissao (
	id_comissao INT NOT NULL AUTO_INCREMENT,
	id_pedido INT,
	valor_comissao DOUBLE,
	id_status_comissao INT,
	id_forma_pagamento INT,
	prc_comissao DOUBLE,
	PRIMARY KEY (id_comissao),
    
	CONSTRAINT fk_id_pedido
		FOREIGN KEY (id_pedido)
		REFERENCES pedido(id_pedido)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_cod_situacao_comissao
		FOREIGN KEY (id_status_comissao)
		REFERENCES status_comissao(id_status_comissao)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_cod_forma_pagamento_comissao
		FOREIGN KEY (id_forma_pagamento)
		REFERENCES forma_pagamento(id_forma_pagamento)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Renovacao
-- -----------------------------------------------------
CREATE TABLE renovacao (
	id_renovacao INT NOT NULL AUTO_INCREMENT,
	id_pedido_antigo INT,
	id_pedido_atual INT,
	PRIMARY KEY (id_renovacao),
	
    CONSTRAINT fk_id_pedido_antigo
		FOREIGN KEY (id_pedido_antigo)
		REFERENCES pedido(id_pedido)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
  
	CONSTRAINT fk_id_pedido_atual
		FOREIGN KEY (id_pedido_atual)
		REFERENCES pedido(id_pedido)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Cliente Fisico
-- -----------------------------------------------------
CREATE TABLE cliente_fisico (
	id_cliente_fisico INT NOT NULL AUTO_INCREMENT,
	id_cliente INT,
	cpf VARCHAR(11),
	PRIMARY KEY (id_cliente_fisico),
	
    CONSTRAINT fk_id_cliente_fisico
	FOREIGN KEY (id_cliente)
		REFERENCES cliente(id_cliente)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Cliente Juridico
-- -----------------------------------------------------
CREATE TABLE cliente_juridico(
	id_cliente_juridico INT NOT NULL AUTO_INCREMENT,
	id_cliente INT,
	cnpj VARCHAR(14),
	nome_empresa VARCHAR(100),
	PRIMARY KEY (id_cliente_juridico),
    
    CONSTRAINT fk_id_cliente_juridico
		FOREIGN KEY (id_cliente)
		REFERENCES cliente(id_cliente)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Tipo Contato
-- -----------------------------------------------------
CREATE TABLE tipo_contato (
	id_tipo_contato INT NOT NULL AUTO_INCREMENT,
	desc_tipo_contato VARCHAR(100),
	PRIMARY KEY (id_tipo_contato));

-- -----------------------------------------------------
-- Tabela Dados Contato
-- -----------------------------------------------------
CREATE TABLE dados_contato (
	id_dados_contato INT NOT NULL AUTO_INCREMENT,
	id_tipo_contato INT,
	desc_dados_contato VARCHAR(250),
	PRIMARY KEY (id_dados_contato),
    
	CONSTRAINT fk_id_tipo_contato_dados_contato
		FOREIGN KEY (id_tipo_contato)
		REFERENCES tipo_contato(id_tipo_contato)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Contato Cliente
-- -----------------------------------------------------
CREATE TABLE contato_cliente (
	id_contato_cliente INT NOT NULL AUTO_INCREMENT,
	id_cliente INT,
	id_dados_contato INT,
	PRIMARY KEY (id_contato_cliente),
    
    CONSTRAINT fk_id_dados_contato_cliente
		FOREIGN KEY (id_dados_contato)
		REFERENCES dados_contato(id_dados_contato)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_id_cliente_contato
		FOREIGN KEY (id_cliente)
		REFERENCES cliente(id_cliente)
		ON DELETE CASCADE
		ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Tabela Contato Contador
-- -----------------------------------------------------
CREATE TABLE contato_contador (
	id_contato_contador INT NOT NULL AUTO_INCREMENT,
	id_contador INT,
	id_dados_contato INT,
	PRIMARY KEY (id_contato_contador),
	
    CONSTRAINT fk_id_dados_contato_contador
		FOREIGN KEY (id_dados_contato)
		REFERENCES dados_contato(id_dados_contato)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_id_contador_contato
		FOREIGN KEY (id_contador)
		REFERENCES contador(id_contador)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Contato Contabilidade
-- -----------------------------------------------------
CREATE TABLE contato_contabilidade (
	id_contato_contabilidade INT NOT NULL AUTO_INCREMENT,
	id_contabilidade INT,
	id_dados_contato INT,
	PRIMARY KEY (id_contato_contabilidade),
	
    CONSTRAINT fk_id_dados_contato_contabilidade
		FOREIGN KEY (id_dados_contato)
		REFERENCES dados_contato(id_dados_contato)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
        
	CONSTRAINT fk_id_contabilidade_contato
		FOREIGN KEY (id_contabilidade)
		REFERENCES contabilidade(id_contabilidade)
		ON DELETE CASCADE
		ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Tabela Contabilidade Contador
-- -----------------------------------------------------
CREATE TABLE contabilidade_contador (
	id_contabilidade_contador INT NOT NULL AUTO_INCREMENT,
	id_contabilidade INT,
	id_contador INT,
	PRIMARY KEY (id_contabilidade_contador),
  
	CONSTRAINT fk_id_contador_contabilidade
		FOREIGN KEY (id_contador)
		REFERENCES contador(id_contador)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
  
	CONSTRAINT fk_id_contabilidade_contador
		FOREIGN KEY (id_contabilidade)
		REFERENCES contabilidade(id_contabilidade)
		ON DELETE CASCADE
		ON UPDATE CASCADE);
