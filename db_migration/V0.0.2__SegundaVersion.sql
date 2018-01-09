INSERT INTO `SONY`.`Categoria` (`idCategoria`, `categoria`) VALUES ('1', 'Electrodomestico');
INSERT INTO `SONY`.`Categoria` (`idCategoria`, `categoria`) VALUES ('2', 'Accesorios');
INSERT INTO `SONY`.`Categoria` (`idCategoria`, `categoria`) VALUES ('3', 'VideoJuegos');
INSERT INTO `SONY`.`Categoria` (`idCategoria`, `categoria`) VALUES ('4', 'Celulares');

INSERT INTO `SONY`.`Local` (`idLocales`, `local`) VALUES ('1', 'SONY Rivera Indarte');
INSERT INTO `SONY`.`Local` (`idLocales`, `local`) VALUES ('2', 'SONY Dinosaurio Mall');
INSERT INTO `SONY`.`Local` (`idLocales`, `local`) VALUES ('3', 'SONY Rio Ceballos');

INSERT INTO `SONY`.`Marca` (`idMarca`, `marca`) VALUES ('1', 'SONY');
INSERT INTO `SONY`.`Marca` (`idMarca`, `marca`) VALUES ('2', 'PANASONIC');
INSERT INTO `SONY`.`Marca` (`idMarca`, `marca`) VALUES ('3', 'MOTOROLA');

ALTER TABLE `SONY`.`Producto` 
ADD COLUMN `nombreProducto` VARCHAR(45) NULL AFTER `idCategoria`;

INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('1', '20.000', 'SONY', '1', '1', 'Television');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('2', '26.000', 'SONY', '1', '1', 'Heladera');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('3', '13.000', 'SONY', '1', '3', 'Play Station');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('4', '80.000', 'PANASONIC', '2', '1', 'Televison 4k');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('5', '17.000', 'MOTOROLA', '3', '4', 'MOTO G5S Plus');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('6', '55.000', 'SONY', '1', '1', 'Shaker Speker');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('7', '680', 'MOTOROLA', '3', '2', 'Auricular');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('8', '10.000', 'SONY', '1', '4', 'Sony A5');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('9', '300', 'SONY', '1', '2', 'Funda XZ');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('10', '30.243', 'PANASONIC', '2', '3', 'Camera ZOOM X');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('11', '7.500', 'MOTOROLA', '3', '4', 'MOTO Z PLAY');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('12', '40.430', 'PANASONIC', '2', '1', 'Television FULL Vision');
INSERT INTO `SONY`.`Producto` (`idProducto`, `precio`, `marca`, `idMarca`, `idCategoria`, `nombreProducto`) VALUES ('13', '165.788', 'SONY', '1', '1', 'Television 4K 99 Pulgadas');





