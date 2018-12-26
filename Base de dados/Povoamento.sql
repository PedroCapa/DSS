USE configurafacil;

insert into utilizador (Nome, Email, Password, Tipo)
	VALUES('Luís Capa'		, 'lfcc1998@gmail.com' , 'Lfcc98', 0),
		  ('Moisés Antunes' , 'maa1999@hotmail.com', 'Maa99' , 0),
          ('Pedro Capa'		, 'pmcc1998@gmail.com' , 'Pmcc98', 0),
          ('Tiago Pinheiro' , 'tmp1998@hotmail.com', 'Tmp98' , 1),
          ('Joel Gama'		, 'jfeg1998@gmail.com' , 'Jfeg98', 1);
          
insert into modelo (Nome, CustoBase)
	VALUES('Edge'			 , 56880 ),
		  ('Boss 429 Mustang', 183900),
          ('Indigo Concept'	 , 88000 ),
          ('302 Mustang'	 , 27000 ),
          ('Model T'		 , 22500 ),
          ('Thunderbird'	 , 38350 );
          
insert into pacote (Nome, Desconto)
	VALUES('Desportivo',0.10),
		  ('Clássico'  ,0.15),
          ('Confort'   ,0.25),
          ('Eco'	   ,0.20);
          
insert into peca (Nome, Quantidade, Tipo, Custo)
	VALUES('177 cu in'					   	 , 10, 1, 2000),
		  ('Boss 302 V8'					 , 12, 1, 5000),
          ('385 Engine'					   	 , 7 , 1, 2300),
          ('V 12'							 , 9 , 1, 2700),
          ('Lynx'							 , 14, 1, 4500),
          ('255 Horsepower 312 Cubic Inch V8', 11, 1, 3300), 
          ('2.3 Ecoboost 290cv'			   	 , 8 , 1, 3800),
          ('Branco'						   	 , 20, 2, 500 ),
          ('Vermelho'						 , 12, 2, 500 ),
          ('Azul'							 , 16, 2, 500 ),
          ('Preto'						   	 , 22, 2, 500 ),
          ('Liga Leve'					   	 , 36, 3, 1000),
          ('Ferro'						   	 , 30, 3, 700 ),
          ('Couro Cognac'					 , 25, 4, 600 ),
          ('Couro Alcantara'				 , 28, 4, 800 ),
          ('Couro Recaro Red'				 , 23, 4, 500 ),
          ('Escape Regulável'				 , 13, 5, 1200),
          ('Sistema de Climatização'		 , 17, 5, 300 ),
          ('Teto de Abrir'				   	 , 15, 5, 400 ),
          ('Spoiler'						 , 20, 5, 700 ),
          ('Condutor Automático'			 , 10, 5, 1600),
          ('Vidros Escurecidos'			   	 , 11, 5, 200 );
          
insert into peca_pacote (Peca_Nome, Pacote_Nome)
	VALUES ('Lynx'					 , 'Desportivo'),
		   ('Preto'					 , 'Desportivo'),
           ('Liga Leve'				 , 'Desportivo'),
           ('Couro Recaro Red'		 , 'Desportivo'),
           ('385 Engine'			 , 'Clássico'  ),
           ('Vermelho'				 , 'Clássico'  ),
           ('Ferro'					 , 'Clássico'  ),
           ('Couro Cognac'			 , 'Clássico'  ),
           ('V 12'					 , 'Confort'   ),
           ('Branco'				 , 'Confort'   ),
           ('Liga Leve'				 , 'Confort'   ),
           ('Couro Alcantara'		 , 'Confort'   ),
           ('2.3 Ecoboost 290cv'	 , 'Eco'	   ),
           ('Azul'					 , 'Eco'	   ),
           ('Liga Leve'				 , 'Eco'	   ),
           ('Couro Alcantara'		 , 'Eco'	   );
           
insert into pacote_modelo (Pacote_Nome, Modelo_Nome)
	VALUES('Confort'   , 'Edge'			   ),
		  ('Eco'	   , 'Edge'			   ),
          ('Clássico'  , 'Boss 429 Mustang'),
          ('Desportivo', 'Indigo Concept'  ),
          ('Desportivo', '302 Mustang'	   ),
          ('Clássico'  , 'Model T'		   ),
          ('Desportivo', 'Thunderbird'	   ),
          ('Confort'   , 'Thunderbird'	   );
          
insert into Peca_Peca 
	VALUES(0, '177 cu in'						, 'Boss 302 V8'						),
		  (0, '177 cu in'						, '385 Engine'						),
          (0, '177 cu in'						, 'V 12'							),
          (0, '177 cu in'						, 'Lynx'							),
          (0, '177 cu in'						, '255 Horsepower 312 Cubic Inch V8'),
          (0, '177 cu in'						, '2.3 Ecoboost 290cv'				),
          (0, 'Boss 302 V8'						, '385 Engine'						),
          (0, 'Boss 302 V8'						, 'V 12'							),
          (0, 'Boss 302 V8'						, 'V 12'							),
          (0, 'Boss 302 V8'						, 'Lynx'							),
          (0, 'Boss 302 V8'						, '255 Horsepower 312 Cubic Inch V8'),
          (0, 'Boss 302 V8'						, '2.3 Ecoboost 290cv'				),
          (0, '385 Engine'						, 'V 12'							),
          (0, '385 Engine'						, 'Lynx'							),
          (0, '385 Engine'						, '255 Horsepower 312 Cubic Inch V8'),
          (0, '385 Engine'						, '2.3 Ecoboost 290cv'				),
          (0, 'V 12'							, 'Lynx'							),
          (0, 'V 12'							, '255 Horsepower 312 Cubic Inch V8'),
          (0, 'V 12'							, '2.3 Ecoboost 290cv'				),
          (0, 'Lynx'							, '255 Horsepower 312 Cubic Inch V8'),
          (0, 'Lynx'							, '2.3 Ecoboost 290cv'				),
          (0, '255 Horsepower 312 Cubic Inch V8', '2.3 Ecoboost 290cv'				),
          (0, 'Branco'							, 'Vermelho'						),
          (0, 'Branco'							, 'Azul'							),
          (0, 'Branco'							, 'Preto'							),
          (0, 'Vermelho'						, 'Azul'							),
          (0, 'Vermelho'						, 'Preto'							),
          (0, 'Azul'							, 'Preto'							),
          (0, 'Liga Leve'						, 'Ferro'							),
          (0, 'Couro Cognac'					, 'Couro Alcantara'					),
          (0, 'Couro Cognac'					, 'Couro Recaro Red'				),
          (0, 'Couro Alcantara'					, 'Couro Recaro Red'				);
          
insert into carro(id, Estado, Data, Preco, Modelo_Nome, Utilizador_Email)
	VALUES('MustTMP' , 2, '2018/12/21', 35100, '302 Mustang', 'tmp1998@hotmail.com'),
		  ('EdgeJFEG', 2, '2018/10/10', 62055, 'Edge'		, 'jfeg1998@gmail.com' );
          
insert into Peca_Carro
	VALUES('MustTMP' , 1, 'Lynx'				   ),
		  ('MustTMP' , 1, 'Preto'				   ),
          ('MustTMP' , 1, 'Liga Leve'			   ),
          ('MustTMP' , 1, 'Couro Recaro Red'	   ),
          ('MustTMP' , 1, 'Escape Regulável'	   ),
          ('MustTMP' , 1, 'Teto de Abrir'		   ),
          ('MustTMP' , 1, 'Spoiler'				   ),
          ('MustTMP' , 1, 'Vidros Escurecidos'	   ),
          ('EdgeJFEG', 1, 'V 12'				   ),
          ('EdgeJFEG', 1, 'Branco'				   ),
          ('EdgeJFEG', 1, 'Liga Leve'			   ),
          ('EdgeJFEG', 1, 'Couro Alcantara'		   ),
          ('EdgeJFEG', 1, 'Condutor Automático'	   ),
          ('EdgeJFEG', 1, 'Sistema de Climatização');

insert into carro(id, Estado, Data, Preco, Modelo_Nome, Utilizador_Email)
	VALUES('jfeg1998@gmail.com2' , 2, '2018/12/25', 35100, '302 Mustang', 'jfeg1998@gmail.com');

update peca set quantidade = 0 where nome = 'Preto';

select * from utilizador;

select * from Carro;

select * from peca;

select * from modelo;

select * from pacote;