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
INSERT INTO estados values (null,'Sao Paulo','SP');
INSERT INTO estados values (null,'Rio de Janeiro','RJ');
INSERT INTO estados values (null,'Minas Gerais','MG');
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
INSERT INTO municipios values (null,(SELECT id_estado from estados where sigla LIKE 'SP'),'Sao Paulo');
INSERT INTO municipios values (null,(SELECT id_estado from estados where sigla LIKE 'RJ'),'Rio de Janeiro');
INSERT INTO municipios values (null,3,'Ouro Preto');
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
INSERT INTO endereco values (null,1,1,'Liberdade','','111','','12344544');
INSERT INTO endereco values (null,2,2,'Copacabana','','222','','41234123');

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
INSERT INTO contabilidade values (null,'Manense','424515123',1,1,1);
-- -----------------------------------------------------
-- Tabela Contador
-- -----------------------------------------------------
CREATE TABLE contador (
	id_contador INT NOT NULL AUTO_INCREMENT,
	nome_contador VARCHAR(200),
	PRIMARY KEY (id_contador));
INSERT INTO contador values (null,'Maria');
INSERT INTO contador values (null,'Jose');

-- -----------------------------------------------------
-- Tabela Tipo Cliente
-- -----------------------------------------------------
CREATE TABLE tipo_cliente (
	id_tipo_cliente INT NOT NULL AUTO_INCREMENT,
	desc_tipo_cliente VARCHAR(100),
	PRIMARY KEY (id_tipo_cliente));
    
INSERT INTO tipo_cliente values (null,'Especial');
INSERT INTO tipo_cliente values (null,'Vip');

-- -----------------------------------------------------
-- Tabela Cliente
-- -----------------------------------------------------
CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
	nome_cliente VARCHAR(200),
	id_tipo_cliente INT,
	PRIMARY KEY (id_cliente),
    
	CONSTRAINT fk_id_tipo_cliente
		FOREIGN KEY (id_tipo_cliente)
		REFERENCES tipo_cliente(id_tipo_cliente)
		ON DELETE NO ACTION
		ON UPDATE CASCADE);
 INSERT INTO cliente values (null,'Fabricio',1);     
 INSERT INTO cliente values (null,'Monica',2);   
 INSERT INTO cliente values (null,'Eduardo',2);

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
INSERT INTO pedido values (null,1,'2017-12-25',1,100.00);
INSERT INTO pedido values (null,2,'2017-10-25',2,130.00);
-- -----------------------------------------------------
-- Tabela Tipo Certificado
-- -----------------------------------------------------
CREATE TABLE tipo_certificado (
	id_tipo_certificado INT NOT NULL AUTO_INCREMENT,
	desc_tipo_certificado VARCHAR(100),
	PRIMARY KEY (id_tipo_certificado));
INSERT INTO tipo_certificado values (null,'Virtual');
INSERT INTO tipo_certificado values (null,'Real');
-- -----------------------------------------------------
-- Table Categoria Certificado
-- -----------------------------------------------------
CREATE TABLE categoria_certificado (
	id_categoria_certificado INT NOT NULL AUTO_INCREMENT,
	desc_categoria_certificado VARCHAR(100),
	PRIMARY KEY (id_categoria_certificado));
INSERT INTO categoria_certificado values (null,'Temporario');
INSERT INTO categoria_certificado values (null,'Definitivo');

-- -----------------------------------------------------
-- Tabela Hardware
-- -----------------------------------------------------
CREATE TABLE hardware (
	id_hardware INT NOT NULL AUTO_INCREMENT,
	desc_hardware VARCHAR(100),
	PRIMARY KEY (id_hardware));
    
INSERT INTO hardware values (null, 'PenDrive');
INSERT INTO hardware values (null, 'Token');


-- -----------------------------------------------------
-- Tabela Hierarquia
-- -----------------------------------------------------
CREATE TABLE hierarquia (
	id_hierarquia INT NOT NULL AUTO_INCREMENT,
	desc_hierarquia VARCHAR(100),
	PRIMARY KEY (id_hierarquia));
    
INSERT INTO hierarquia values (null,'Prioritario');
INSERT INTO hierarquia values (null,'Secundario');

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
INSERT INTO certificado values (null,1,1,1,1,1,'001','2050-12-25');
INSERT INTO certificado values (null,2,2,2,2,2,'002','2020-01-01');

-- -----------------------------------------------------
-- Tabela Status Comissao
-- -----------------------------------------------------
CREATE TABLE status_comissao (
	id_status_comissao INT NOT NULL AUTO_INCREMENT,
	desc_status_comissao VARCHAR(100),
	PRIMARY KEY (id_status_comissao));
INSERT INTO status_comissao values (null,'Atrasada');
INSERT INTO status_comissao values (null,'Confirmada');

-- -----------------------------------------------------
-- Tabela Forma Pagamento
-- -----------------------------------------------------
CREATE TABLE forma_pagamento (
	id_forma_pagamento INT NOT NULL AUTO_INCREMENT,
	desc_forma_pagamento VARCHAR(100),
	PRIMARY KEY (id_forma_pagamento));
INSERT INTO forma_pagamento values (null,'Credito');
INSERT INTO forma_pagamento values (null,'Debito');

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
        
INSERT INTO comissao values (null,1,50.00,1,1,0.38);
INSERT INTO comissao values (null,2,74.00,2,2,0.75);

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
        
INSERT INTO renovacao values (null,1,2);

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
        
INSERT INTO cliente_fisico values (null,1,'45854114');

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
        
INSERT INTO cliente_juridico values (null,2,'125369859','Vem Bem');
INSERT INTO cliente_juridico values (null,3,'465784468','Vitoria Certa');

-- -----------------------------------------------------
-- Tabela Tipo Contato
-- -----------------------------------------------------
CREATE TABLE tipo_contato (
	id_tipo_contato INT NOT NULL AUTO_INCREMENT,
	desc_tipo_contato VARCHAR(100),
	PRIMARY KEY (id_tipo_contato));
    
INSERT INTO tipo_contato values (null,'tel');
INSERT INTO tipo_contato values (null,'email');

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
        
INSERT INTO dados_contato values (null,1,'11998585555');
INSERT INTO dados_contato values (null,2,'m.maria@gmail.com');

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
        
INSERT INTO contato_cliente values (null,1,1);
INSERT INTO contato_cliente values (null,2,2);

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
        
INSERT INTO contato_contador values (null,1,1);
INSERT INTO contato_contador values (null,2,2);

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
        
INSERT INTO contato_contabilidade values (null,1,1);

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

INSERT INTO contabilidade_contador values (null,1,1);
